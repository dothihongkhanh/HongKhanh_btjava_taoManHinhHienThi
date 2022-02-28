/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaswing_dthkhanh.dao;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author DELL
 */
public class JDBCConnection_dthkhanh {

    public static Connection getJBDCConnection() throws SQLException {
        final String url = "jdbc:sqlserver://localhost:1433;databaseName=BanHang_DoThiHongKhanh";
        final String user = "sa";
        final String password = "123456";

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    public static void main(String[] args) throws SQLException {
        Connection connection = getJBDCConnection();
        if (connection != null) {
            System.out.println("Thanh cong");
        } else {
            System.out.println("That bai");
        }
        //public static void main(String[] args) {
        /*var server="DESKTOP-J8SR7CQ\\SQLEXPRESS";
        var user = "sa";
        var password = "123456";
        var db = "BanHang_DoThiHongKhanh";
        var port = 1433;
        SQLServerDataSource ds = new SQLServerDataSource();
        ds.setUser(user);
        ds.setPassword(password);
        ds.setDatabaseName(db);
        ds.setServerName(server);
        ds.setPortNumber(port);
        try( Connection conn = ds.getConnection()){
            System.out.println("Ket noi thanh cong");
            System.out.println(conn.getCatalog());
                
    }catch (SQLException ex)
    {
        ex.printStackTrace();
    }
        return null;
    }
         */
    }
}
