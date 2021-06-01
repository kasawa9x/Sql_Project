/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import java.sql.*;

import model.Sinhvien;
 
public class UserDAO {
 
    public Sinhvien checkLogin(String account, String password) throws SQLException,
            ClassNotFoundException {
        String jdbcURL = "jdbc:mysql://localhost:3306/dktc";
        String dbUser = "root";
        String dbPassword = "123456";
 
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
        String sql = "SELECT * FROM sinhvien WHERE taikhoan = ? AND matkhau = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, account);
        statement.setString(2, password);
 
        ResultSet result = statement.executeQuery();
 
        Sinhvien user = null;
 
        if (result.next()) {
            user = new Sinhvien();
            user.setTenSv(result.getString("tenSv"));
            user.setMaSv(result.getString("maSv"));
            user.setTaikhoan(account);
        }
 
        connection.close();
 
        return user;
    }
    
    public boolean addUser(Sinhvien user) throws SQLException,ClassNotFoundException{
    	boolean status = false;
    	String jdbcURL = "jdbc:mysql://localhost:3306/dktc";
        String dbUser = "root";
        String dbPassword = "123456";
 
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
        String sql = "INSERT INTO Sinhvien(maSv,taikhoan,matkhau,tenSv) VALUES(?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, user.getMaSv());
        statement.setString(2, user.getTaikhoan());
        statement.setString(3, user.getMatkhau());
        statement.setString(4, user.getTenSv());
        status = statement.executeUpdate() > 0;
        return status;
    }
}