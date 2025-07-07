package com.litmus7.urs.dao;

import java.util.*;
import com.litmus7.urs.dto.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
	public List<User> loadDataFromSql(){
		List<User> userList = new ArrayList<>();
		
		String dburl = "jdbc:mysql://localhost:3306/UserRegistrationSys";
        String user = "root";
        String pass = "password";

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
        	conn = DriverManager.getConnection(dburl,user,pass);
        	stmt = conn.createStatement();
        	rs = stmt.executeQuery("SELECT * FROM Users");
        	
        	while(rs.next()) {
        		String username = rs.getString("username");
        		int age = rs.getInt("age");
                String email = rs.getString("email");
                String password = rs.getString("password");
                
                User userObj = new User(username,age,email,password);
                userList.add(userObj);
                
        	}
        }catch (SQLException e) {
        	e.printStackTrace();
        }
        finally {
            try {
            	if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }	
        return userList;	
        
       
	}
	
	public void saveUser(User userObj) {
        String dburl = "jdbc:mysql://localhost:3306/UserRegistrationSys";
        String user = "root";
        String pass = "password";

        Connection conn = null;
        Statement stmt = null;

        try {
            conn = DriverManager.getConnection(dburl, user, pass);
            stmt = conn.createStatement();
            String sql = String.format(
                "INSERT INTO Users (username, age, email, password) VALUES ('%s', %d, '%s', '%s')",
                userObj.getUsername(),
                userObj.getAge(),
                userObj.getEmail(),
                userObj.getPassword()
            );
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
