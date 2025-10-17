package com.Invoice.Controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/auth")
public class ProfileController {
//	private final String UPLOAD_DIR = "src/main/resources/static/uploads/";
	private static final String UPLOAD_DIR = System.getProperty("user.home") + "/uploads/";

	@Value("${app.api.url}")
	private String apiUrl;

	@PostMapping("/upload")
	public ResponseEntity<String> uploadProfilePicture(@RequestParam("file") MultipartFile file) {
		if (file.isEmpty()) {
			return ResponseEntity.badRequest().body("Please select a file to upload.");
		}

		try {
			// Ensure the directory exists
			Path path = Paths.get(UPLOAD_DIR + file.getOriginalFilename());
			Files.createDirectories(path.getParent());
			Files.write(path, file.getBytes());

			// Construct the full URL
			String fileUrl = apiUrl + "/uploads/" + file.getOriginalFilename();
			return ResponseEntity.ok(fileUrl); // Return full URL of uploaded file
		} catch (IOException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Failed to upload file: " + e.getMessage());
		}
	}
}