package com.jsk.ditto.Ditto.AuthController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsk.ditto.Ditto.dto.AuthResponse;
import com.jsk.ditto.Ditto.dto.LoginRequest;
import com.jsk.ditto.Ditto.dto.SignupRequest;
import com.jsk.ditto.Ditto.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	private static final Logger logger = LoggerFactory.getLogger(AuthService.class);
	
    @Autowired
    private AuthService authService;

	@PostMapping("/signup")
	public ResponseEntity<?> signup(@RequestBody SignupRequest request) {
		authService.signup(request);
		logger.info("User Registered");
		return ResponseEntity.ok("User registered successfully");
	}

	@PostMapping("/login")
	public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
		String token = authService.login(request);
		logger.info("Logged IN");
		return ResponseEntity.ok(new AuthResponse(token));
	}
}
