package com.example.hikariConfg.user;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class UserController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserRepository userRepository;

	@RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
	public ResponseEntity<UserEntity> getAllApps(final HttpServletRequest request,
			@PathVariable(value = "userId", required = true) long userId) {
		LOGGER.info("URI= {}", request.getRequestURI());
		Optional<UserEntity> userEntity;
		try {
			userEntity = userRepository.findById(userId);
			if (userEntity.isPresent())
				return new ResponseEntity<>(userEntity.get(), HttpStatus.OK);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
