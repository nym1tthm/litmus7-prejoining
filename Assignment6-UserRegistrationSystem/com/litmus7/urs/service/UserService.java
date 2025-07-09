package com.litmus7.urs.service;

import com.litmus7.urs.dao.*;
import com.litmus7.urs.dto.*;
import com.litmus7.urs.exception.*;

import java.util.Optional;

public class UserService {
    private UserDao userDao;

    public UserService() {
        this.userDao = new UserDao();
    }

    public User registerUser(User user)
            throws InvalidUsernameException, InvalidAgeException, InvalidEmailException, WeakPasswordException, DaoException {

        if (user.getUsername() == null || user.getUsername().trim().isEmpty()) {
            throw new InvalidUsernameException("Username cannot be empty.");
        }

        if (user.getAge() < 18 || user.getAge() > 60) {
            throw new InvalidAgeException("Age must be between 18 and 60.");
        }

        String email = user.getEmail();
        if (email == null || !email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            throw new InvalidEmailException("Invalid email format. Must contain '@' and '.'.");
        }

        if (user.getPassword() == null || user.getPassword().length() < 6) {
            throw new WeakPasswordException("Password too weak. Must be at least 6 characters.");
        }


        User existing = userDao.findUserByUsername(user.getUsername());
        if (existing != null) {
            throw new InvalidUsernameException("Username '" + user.getUsername() + "' is already taken.");
        }

        return userDao.saveUser(user);
    }
}
