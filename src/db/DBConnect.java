/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kushhhh
 */
public class DBConnect {
    private static final String STUDENTS_TABLE_SQL;
    private static final String FACULTY_TABLE_SQL;
    private static Connection conn = null;

    static {
        STUDENTS_TABLE_SQL = "CREATE TABLE IF NOT EXISTS students (" +
                "sap_id TEXT, date TEXT, in_time TEXT, out_time TEXT, status TEXT, PRIMARY KEY(sap_id, date, in_time))";
        FACULTY_TABLE_SQL = "CREATE TABLE IF NOT EXISTS faculty (" +
                "sap_id TEXT, date TEXT, in_time TEXT, out_time TEXT, status TEXT, PRIMARY KEY(sap_id, date, in_time))";
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:records.db");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Connection getConnection() {
        try {
            if(conn != null) {
                try (Statement stmt = conn.createStatement()) {
                    stmt.execute(STUDENTS_TABLE_SQL);
                    stmt.execute(FACULTY_TABLE_SQL);
                }
                return conn;
            } else {
                return null;
            }
                
        } catch(SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }    
}
