/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author kushhhh
 */
public class DBConnect {
    private static final String STUDENTS_TABLE_SQL;
    private static final String FACULTY_TABLE_SQL;
    
    static {
        STUDENTS_TABLE_SQL = "CREATE TABLE IF NOT EXISTS students (" +
                "sap_id TEXT, date TEXT, in_time TEXT, out_time TEXT, status TEXT, PRIMARY KEY(sap_id, in_time))";
        FACULTY_TABLE_SQL = "CREATE TABLE IF NOT EXISTS faculty (" +
                "sap_id TEXT, date TEXT, in_time TEXT, out_time TEXT, status TEXT, PRIMARY KEY(sap_id, in_time))";
    }
    
    public static Connection getConnection() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:records.db");
            try (Statement stmt = conn.createStatement()) {
                stmt.execute(STUDENTS_TABLE_SQL);
                stmt.execute(FACULTY_TABLE_SQL);
            }
            return conn;
        } catch(SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }    
}
