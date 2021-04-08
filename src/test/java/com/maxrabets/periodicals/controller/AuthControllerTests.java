package com.maxrabets.periodicals.controller;

import static org.junit.jupiter.api.Assertions.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.*;

import com.maxrabets.periodicals.repository.UserRepository;
import com.maxrabets.periodicals.requests.RegistrationRequest;
import com.maxrabets.periodicals.service.UserService;
import com.maxrabets.periodicals.config.*;

//@RunWith(SpringJUnit5ClassRunner.class)
//@SpringBootTest
@ExtendWith(SpringExtension.class)
//@ExtendWith(SpringRunner.class)
@ContextConfiguration(classes = {ApplicationContextConfig.class})
//@AutoConfigureMockMvc
//@WebMvcTest(AuthController.class)
class AuthControllerTests {
	
	@Autowired
	AuthController authController;
	
	@Test
	void registerUser_CorrectData_UserRegistered() throws Exception {
		//AuthController authController = new AuthController();
		ResponseEntity<?> expectedResponse = ResponseEntity.ok(null);
		RegistrationRequest registrationRequest = new RegistrationRequest();
		
		
		//UserService userService = new UserService(userRepository);
		//ReflectionTestUtils.setField(authController, "userService", userService);
		//HttpServletResponse httpResponse = iefRuntimeParam2.getResponse();
		//httpResponse
		
		ResponseEntity<?> response = authController.registerUser(
				registrationRequest, null);
		
		assertEquals(response.getStatusCodeValue(),
				expectedResponse.getStatusCodeValue());
	}

	@Test
	void auth_CorrectEmailAndPassword_UserAuthenticated() throws Exception {
		fail("Not yet implemented");
	}

}
