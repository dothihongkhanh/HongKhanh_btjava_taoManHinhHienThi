/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaswing_dthkhanh.dao;

import javaswing_dthkhanh.model.User_dthkhanh;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class UserDao_dthkhanh {

    public List<User_dthkhanh> getAllUsers() throws SQLException {
        List<User_dthkhanh> users = new ArrayList<User_dthkhanh>();

        Connection connection = JDBCConnection_dthkhanh.getJBDCConnection();

        String sql = "SELECT * FROM USER_DoThiHongKhanh";
        try {

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                User_dthkhanh user = new User_dthkhanh();
                user.setId(rs.getInt("ID"));
                user.setName(rs.getString("NAME"));
                user.setPhone(rs.getString("PHONE"));
                user.setUsername(rs.getString("USERNAME"));
                user.setPassword(rs.getString("PASSWORD"));
                user.setAbout(rs.getString("ABOUT"));
                user.setFavourites(rs.getString("FAVOURITES"));
                user.setRole(rs.getString("ROLE"));

                users.add(user);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;

    }

    public void addUser(User_dthkhanh user) throws SQLException {
        Connection connection = JDBCConnection_dthkhanh.getJBDCConnection();
        String sql = "INSERT INTO USER_DoThiHongKhanh (NAME, PHONE, USERNAME, PASSWORD, FAVOURITES, ABOUT,  ROLE) VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPhone());
            preparedStatement.setString(3, user.getUsername());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getFavourites());
            preparedStatement.setString(6, user.getAbout());
            preparedStatement.setString(7, user.getRole());

            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUser(User_dthkhanh user) throws SQLException {
        Connection connection = JDBCConnection_dthkhanh.getJBDCConnection();
        String sql = "UPDATE USER_DoThiHongKhanh SET NAME = ?, USERNAME = ?, PASSWORD = ?,ABOUT = ?," + "FAVOURITES = ?, ROLE = ? WHERE ID =?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPhone());
            preparedStatement.setString(3, user.getUsername());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getAbout());
            preparedStatement.setString(6, user.getFavourites());
            preparedStatement.setString(7, user.getRole());

            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delateUser(int id) throws SQLException {
        Connection connection = JDBCConnection_dthkhanh.getJBDCConnection();

        String sql = "delete from USER_DoThiHongKhanh where id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
