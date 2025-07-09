package com.litmus7.urs.controller;

import com.litmus7.urs.service.*;
import com.litmus7.urs.dto.*;
import com.litmus7.urs.exception.*;

public class RegistrationController {
	private UserService service;

	public RegistrationController() {
		this.service = new UserService();
	}

	public Response<User> register(User user) {
		Response<User> response = new Response<>();
		try {
			User savedUser = service.registerUser(user);
			response.setStatusCode(Response.SUCCESS_REGISTRATION);
			response.setData(savedUser);

		} catch (InvalidUsernameException | InvalidEmailException | InvalidAgeException | WeakPasswordException e) {
			response.setStatusCode(Response.ERROR_VALIDATION);
			response.setMessage("Validation error: " + e.getMessage());
		} catch (Exception e) {
			response.setStatusCode(Response.ERROR_UNKNOWN);
			response.setMessage("Unexpected error occurred.");
			e.printStackTrace();
		}

		return response;
	}

}
