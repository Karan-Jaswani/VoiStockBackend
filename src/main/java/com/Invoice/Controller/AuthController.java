package com.Invoice.Controller;

import com.Invoice.Models.User;
import com.Invoice.Repository.UserRepository;
import com.Invoice.Response.ApiResponse;
import com.Invoice.Response.LoginRequest;
import com.Invoice.Response.LoginResponse;
import com.Invoice.Response.OtpVerificationRequest;
import com.Invoice.Service.CustomUserDetailsService;
import com.Invoice.Service.JwtService;
import com.Invoice.Service.RegistrationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	private final RegistrationService registrationService;
	private final UserRepository userRepository;
	private final JwtService jwtService;
	private final AuthenticationManager authenticationManager;
	private final CustomUserDetailsService userDetailsService;

	public AuthController(RegistrationService registrationService, UserRepository userRepository, JwtService jwtService,
			AuthenticationManager authenticationManager, CustomUserDetailsService userDetailsService) {
		this.registrationService = registrationService;
		this.userRepository = userRepository;
		this.jwtService = jwtService;
		this.authenticationManager = authenticationManager;
		this.userDetailsService = userDetailsService;
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<?> getUser(@PathVariable Long id) {
		User user = new User();
		try {
			user = userRepository.findById(id).orElse(null);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User not found.");
		}
		return ResponseEntity.ok(user);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable Long id) {
		try {
			User oldUser = userRepository.findById(id).orElse(null);
			oldUser.setName(user.getName());
			oldUser.setPhonenum(user.getPhonenum());
			oldUser.setUsername(user.getUsername());
			oldUser.setState(user.getState());
			oldUser.setProfileurl(user.getProfileurl());
			userRepository.save(oldUser);
			return ResponseEntity.ok(oldUser);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User not found.");
		}
	}

	@PutMapping("/update/company/{id}")
	public ResponseEntity<?> updateCompanyDetails(@RequestBody User user, @PathVariable Long id) {
		try {
			User oldUser = userRepository.findById(id).orElse(null);
			oldUser.setAccountNo(user.getAccountNo());
			oldUser.setAddress1(user.getAddress1());
			oldUser.setAddress2(user.getAddress2());
			oldUser.setBankBranchName(user.getBankBranchName());
			oldUser.setBankName(user.getBankName());
			oldUser.setCompanyName(user.getCompanyName());
			oldUser.setGstin(user.getGstin());
			oldUser.setIfscCode(user.getIfscCode());
			oldUser.setCompanyPhone(user.getCompanyPhone());
			oldUser.setPan(user.getPan());
			oldUser.setUpiId(user.getUpiId());
			userRepository.save(oldUser);
			return ResponseEntity.ok(oldUser);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User not found.");
		}
	}

	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody User user) {
		try {
			registrationService.registerUser(user);
			return ResponseEntity.ok("User registered. Check your email for OTP.");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Registration failed: " + e.getMessage());
		}
	}

	@PostMapping("/verify-otp")
	public ResponseEntity<ApiResponse> verifyOtp(@RequestBody OtpVerificationRequest request) {
		boolean verified = registrationService.verifyOtp(request.getEmail(), request.getOtp());
		if (verified) {
			System.out.println("|========> User with Email "+ request.getEmail()+ " Registered Successfully at "+LocalTime.now());
			return ResponseEntity.ok(new ApiResponse(true, "Email verified!"));
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ApiResponse(false, "Invalid or expired OTP."));
		}
	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
		String email = loginRequest.getEmail();
		String password = loginRequest.getPassword();

		try {
			// Load the user from the database based on the provided email
			User user = userRepository.findByEmail(email)
					.orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));

			// Check if the provided password matches the stored password
			if (password.equals(user.getPassword()) && user.isEnabled()) {
				// If the passwords match, generate the JWT token
				String token = jwtService.generateToken(user.getEmail());
				String username = user.getUsername();
				String phonenum = (user.getPhonenum() != null) ? user.getPhonenum() : "";
				String state = (user.getState() != null) ? user.getState() : "";
				Long userid = (user.getId() != null) ? user.getId() : 0;
				String profileurl = (user.getProfileurl() != null) ? user.getProfileurl() : "";
				String name = (user.getName() != null) ? user.getName() : "";
				// Return the success response with the token
				LoginResponse response = new LoginResponse(true, token, username, email, phonenum, state, userid,
						profileurl, name);
				System.out.println("|========> User Logged In : "+username+" from "+state+" at "+LocalTime.now());
				return ResponseEntity.ok(response);
			}

			// If authentication fails
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
					.body(new ApiResponse(false, "Invalid email or password."));
		} catch (UsernameNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(false, e.getMessage()));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ApiResponse(false, "Login failed: " + e.getMessage()));
		}
	}

}
