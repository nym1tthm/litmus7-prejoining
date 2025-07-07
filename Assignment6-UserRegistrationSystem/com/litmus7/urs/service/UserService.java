package com.litmus7.urs.service;
import com.litmus7.urs.dao.*;
import com.litmus7.urs.dto.*;
import java.util.*;
import com.litmus7.urs.exception.*;


public class UserService {
	private UserDao userDao;
	public UserService () {
		this.userDao = new UserDao();
	}
	public void registerUser (User user) throws InvalidUsernameException, InvalidAgeException, InvalidEmailException, WeakPasswordException{
		if (user.getUsername() == null || user.getUsername().trim().isEmpty()) {
            throw new InvalidUsernameException("Username cannot be empty.");
        }
		
		if (user.getAge() < 18 || user.getAge() > 60) {
            throw new InvalidAgeException("Age must be between 18 and 60.");
        }

        String email = user.getEmail();
        if (email == null || !email.contains("@") || !email.contains(".")) { 
            throw new InvalidEmailException("Invalid email format. Must contain '@' and '.'.");
        }


        if (user.getPassword() == null || user.getPassword().length() < 6) {
            throw new WeakPasswordException("Password too weak. Must be at least 6 characters.");
        }

        List<User> existingUsers = userDao.loadDataFromSql();


        for (User existing : existingUsers) {
            if (existing.getUsername().equalsIgnoreCase(user.getUsername())) {
                throw new InvalidUsernameException("Username '" + user.getUsername() + "' is already taken.");
            }
        }


        for (User existing : existingUsers) {
            if (existing.getEmail().equalsIgnoreCase(user.getEmail())) {
                throw new InvalidEmailException ("Email '" + user.getEmail() + "' is already registered.");
            }
        }

        userDao.saveUser(user);
        
	}
}	
	
	
	
	
	
	
	


    
