package com.Invoice.Service;

import java.time.LocalDateTime;
import java.util.Optional;

import com.Invoice.Models.User;
import com.Invoice.Repository.UserRepository;
import com.Invoice.Service.EmailService;
import com.Invoice.Service.OtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

	private final UserRepository userRepository;
	private final OtpService otpService;
	private final EmailService emailService;

	@Autowired
	public RegistrationService(UserRepository userRepository, OtpService otpService, EmailService emailService) {
		this.userRepository = userRepository;
		this.otpService = otpService;
		this.emailService = emailService;
	}

	public void registerUser(User user) {
		// Check if the user already exists by email
		Optional<User> existingUserOptional = userRepository.findByEmail(user.getEmail());

		// Generate a new OTP and set the expiration time
		String otp = otpService.generateOtp();
		LocalDateTime otpExpiry = otpService.getOtpExpiryTime();
		user.setName(user.getUsername());
		user.setProfileurl("https://webcrumbs.cloud/placeholder");
		// Set the OTP and expiry details
		user.setOtp(otp);
		user.setOtpExpiry(otpExpiry);

		if (existingUserOptional.isPresent()) {
			// Update existing user with new OTP and expiry time
			User existingUser = existingUserOptional.get();
			existingUser.setOtp(otp);
			existingUser.setOtpExpiry(otpExpiry);
			userRepository.save(existingUser);

			// Send OTP email to existing user
			emailService.sendOtpEmail(existingUser.getEmail(), otp);
		} else {
			// Save new user with OTP
			userRepository.save(user);
			new Thread(() -> emailService.sendOtpEmail(user.getEmail(), otp)).start();
		}
	}

	public boolean verifyOtp(String email, String otp) {
		// Find the user by email
		User user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));

		// Verify OTP and check expiry
		if (user.getOtp().equals(otp) && user.getOtpExpiry().isAfter(LocalDateTime.now())) {
			// OTP is valid, enable the user and clear OTP details
			user.setEnabled(true);
			user.setOtp(null);
			user.setOtpExpiry(null);
			userRepository.save(user);

			// Run email sending in a separate thread to avoid blocking the main flow
			new Thread(() -> sendRegistrationSuccessEmail(user.getEmail())).start();
//            
//            // Send success email
//            sendRegistrationSuccessEmail(user.getEmail());
			return true;
		}
		return false; // Invalid or expired OTP
	}

	private void sendRegistrationSuccessEmail(String email) {
		String subject = "Welcome to VoiStock!";
		String message = """
				Dear User,

				Thank you for completing your registration with Learn Without Limits!

				Your account is now activated. You can log in using the following credentials:

				Email: %s

				Please keep this email for your records.

				Happy Learning,
				BiteCodes Team
				""".formatted(email);

		emailService.sendEmail(email, subject, message);
	}
}
