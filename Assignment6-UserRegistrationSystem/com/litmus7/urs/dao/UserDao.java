package com.litmus7.urs.dao;

import com.litmus7.urs.dto.User;
import com.litmus7.urs.exception.DaoException;
import com.litmus7.urs.util.DBUtil;

import java.sql.*;

public class UserDao {

    private static final String INSERT_USER_SQL =
        "INSERT INTO Users (username, age, email, password) VALUES (?, ?, ?, ?)";
    private static final String SELECT_USER_BY_USERNAME =
        "SELECT username,age,email,password FROM Users WHERE username = ?";


    public User saveUser(User user) throws DaoException {
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_SQL)) {

            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setInt(2, user.getAge());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.executeUpdate();

            return user;

        } catch (SQLException e) {
            throw new DaoException("Error saving user", e);
        }
    }

    public User findUserByUsername(String username) throws DaoException {
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_USERNAME)) {

            preparedStatement.setString(1, username);

            try (ResultSet resultset = preparedStatement.executeQuery()) {
                if (resultset.next()) {
                    return new User(
                        resultset.getString("username"),
                        resultset.getInt("age"),
                        resultset.getString("email"),
                        resultset.getString("password")
                    );
                } else {
                    return null; 
                }
            }

        } catch (SQLException e) {
            throw new DaoException("Error finding user by username", e);
        }
    }


       
    
}
