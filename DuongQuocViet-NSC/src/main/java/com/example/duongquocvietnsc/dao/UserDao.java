package com.example.duongquocvietnsc.dao;

import com.example.duongquocvietnsc.model.User;
import com.example.duongquocvietnsc.utils.ConnectionUtils;

import java.sql.*;

public class UserDao {
    Connection connection = ConnectionUtils.getConnection();

    public User getUser(String pName, String password) {
        User user = null;
        String sql = "select * from users where username = '"+pName +"' and password = " +password;
        try {
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);
            while (resultSet.next()){
                String name = resultSet.getString("username");
                String pass = resultSet.getString("password");
                user = new User(name, pass);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

}
