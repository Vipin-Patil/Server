package com.jsk.ditto.Ditto.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.jsk.ditto.Ditto.dto.LoginRequest;
import com.jsk.ditto.Ditto.dto.SignupRequest;
import com.jsk.ditto.Ditto.model.User;
import com.jsk.ditto.Ditto.repository.UserRepository;
import com.jsk.ditto.Ditto.security.JwtUtil;

@Service
public class AuthService {
	
	private static final Logger logger = LoggerFactory.getLogger(AuthService.class);
	
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    public void signup(SignupRequest request) {
        if (userRepository.findByUsername(request.username).isPresent()) {
        	logger.error("User Already Exsist");
            throw new RuntimeException("User already exists");
        }

        User user = new User();
        user.setUsername(request.username);
        user.setPassword(passwordEncoder.encode(request.password));
        userRepository.save(user);
    }

    public String login(LoginRequest request) {
        User user = userRepository.findByUsername(request.username)
                .orElseThrow(() -> new RuntimeException("User not found"));
        if(user == null) {
        	logger.error("User not found");
        }

        if (!passwordEncoder.matches(request.password, user.getPassword())) {
        	logger.error("Invalid Credentials");
            throw new RuntimeException("Invalid credentials");
        }
        
        logger.info("Token Genrated");
        return jwtUtil.generateToken(user.getUsername());
    }
}

