/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author kushhhh
 */
public class DBConnect {
    public static Connection getConnection() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:records.db");
            return conn;
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }    
}
