package com.Invoice.Models;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = true)
	private String username;

	@Column()
	private String name;

	@Column()
	private String profileurl;

	@Pattern(regexp = "^[0-9]{10,15}$", message = "Phone number must contain only digits")
	@Size(min = 10, max = 15, message = "Phone number must be between 10 to 15 digits")
	@Column(nullable = true, unique = true)
	private String phonenum;

	@Column()
	private String state;

	@Column(nullable = false)
	private String password;

	@Email
	@Column(nullable = false, unique = true)
	private String email;

	@Column(nullable = false)
	private String role;

	@Column(nullable = false)
	private boolean enabled = false;

	private String otp;
	private LocalDateTime otpExpiry;

	private String companyName;
	private String address1;
	private String address2;
	private String gstin;
	private Long companyPhone;
	private String pan;
	private String bankName;
	private String ifscCode;
	private String accountNo;
	private String bankBranchName;
	private String upiId;

	public User(Long id, String username, String name, String profileurl,
			@Pattern(regexp = "^[0-9]{10,15}$", message = "Phone number must contain only digits") @Size(min = 10, max = 15, message = "Phone number must be between 10 to 15 digits") String phonenum,
			String state, String password, @Email String email, String role, boolean enabled, String otp,
			LocalDateTime otpExpiry, String companyName, String address1, String address2, String gstin,
			Long companyPhone, String pan, String bankName, String ifscCode, String accountNo, String bankBranchName,
			String upiId) {
		this.id = id;
		this.username = username;
		this.name = name;
		this.profileurl = profileurl;
		this.phonenum = phonenum;
		this.state = state;
		this.password = password;
		this.email = email;
		this.role = role;
		this.enabled = enabled;
		this.otp = otp;
		this.otpExpiry = otpExpiry;
		this.companyName = companyName;
		this.address1 = address1;
		this.address2 = address2;
		this.gstin = gstin;
		this.companyPhone = companyPhone;
		this.pan = pan;
		this.bankName = bankName;
		this.ifscCode = ifscCode;
		this.accountNo = accountNo;
		this.bankBranchName = bankBranchName;
		this.upiId = upiId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getGstin() {
		return gstin;
	}

	public void setGstin(String gstin) {
		this.gstin = gstin;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getBankBranchName() {
		return bankBranchName;
	}

	public void setBankBranchName(String bankBranchName) {
		this.bankBranchName = bankBranchName;
	}

	public String getUpiId() {
		return upiId;
	}

	public void setUpiId(String upiId) {
		this.upiId = upiId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProfileurl() {
		return profileurl;
	}

	public void setProfileurl(String profileurl) {
		this.profileurl = profileurl;
	}

	public String getPhonenum() {
		return phonenum;
	}

	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public User() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public LocalDateTime getOtpExpiry() {
		return otpExpiry;
	}

	public void setOtpExpiry(LocalDateTime otpExpiry) {
		this.otpExpiry = otpExpiry;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + role));
	}

	public Long getCompanyPhone() {
		return companyPhone;
	}

	public void setCompanyPhone(Long companyPhone) {
		this.companyPhone = companyPhone;
	}

}