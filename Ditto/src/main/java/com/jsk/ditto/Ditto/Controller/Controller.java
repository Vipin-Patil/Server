package com.jsk.ditto.Ditto.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/ditto")
public class Controller {
	
	Logger logger = LoggerFactory.getLogger(Controller.class);
	
	@PostMapping("/login/{token}")
	public ResponseEntity<Boolean> handleLogin(@PathVariable String token) {
		logger.info("Reached Server");
		if(token.equals("Test")) {
			return new ResponseEntity<>(true,HttpStatus.OK);
		}
		return new ResponseEntity<>(false,HttpStatus.OK);
	}
}
