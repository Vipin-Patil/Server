package com.jsk.ditto.Ditto.AuthController;

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

    @Autowired
    private AuthService authService;

	public AuthController(AuthService authService) {
		this.authService = authService;
	}

	@PostMapping("/signup")
	public ResponseEntity<?> signup(@RequestBody SignupRequest request) {
		authService.signup(request);
		return ResponseEntity.ok("User registered successfully");
	}

	@PostMapping("/login")
	public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
		String token = authService.login(request);
		return ResponseEntity.ok(new AuthResponse(token));
	}
}
