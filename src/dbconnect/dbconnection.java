/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbconnect;

import java.sql.*;

/**
 *
 * @author ASUS
 */
public class dbconnection {

    static String user = "root";
    static String password = "";
    static String dbUrl = "jdbc:mysql://localhost:3306/kutuphane";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbUrl, user, password); 
    }

    public void ShowError(SQLException e) {
        System.out.println(e.getMessage() + "\n" + e.getErrorCode());

    }
}
