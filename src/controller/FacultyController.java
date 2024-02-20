/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import db.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kushhhh
 */
public class FacultyController {
    private Connection conn;
    private PreparedStatement statement;
    
    public FacultyController() {
        conn = DBConnect.getConnection();
        
    }
    
    public int getRowCount() {
        try {
            this.statement = this.conn.prepareStatement("SELECT COUNT(*) FROM faculty ORDER BY in_time, date DESC");
            ResultSet rs = this.statement.executeQuery();
            rs.next();
            return rs.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(FacultyController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return -1;
    }
    
    public ResultSet getAll() {
        ResultSet rs;
        try {
            this.statement = this.conn.prepareStatement("SELECT * FROM faculty");
            rs = this.statement.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public ResultSet getFacultyWithinDateRange(String from, String to) {
        ResultSet rs;
        try {
            this.statement = this.conn.prepareStatement("SELECT * FROM faculty WHERE date >= ? AND date <= ?");
            this.statement.setString(1, from);
            this.statement.setString(2, to);
            rs = this.statement.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(FacultyController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public void insert(String sapId, String date, String time) {
        boolean isIn = false;
        String inTime = "";
        String todayDate = DateTimeFormatter.ofPattern("yyyy/MM/dd").format(LocalDateTime.now());
                
        try {
            statement = this.conn.prepareStatement("SELECT sap_id, date, in_time, status FROM faculty WHERE sap_id = ? AND date = ?");
            statement.setString(1, sapId);
            statement.setString(2, date);
            
            ResultSet rs = statement.executeQuery();
            if(rs != null) {
                while(rs.next()) {
                    if("in".equals(rs.getString(4)) && todayDate.equals(rs.getString(2))){
                        isIn = true; 
                        inTime = rs.getString(3);
                        System.out.println(isIn + " - " + inTime);
                    }
                }
            } 
            
            if(! isIn) {
                System.out.println("Inserting record for " + sapId);
                statement = conn.prepareStatement("INSERT INTO faculty(sap_id, date, in_time, status) VALUES (?, ?, ?, ?)");
                statement.setString(1, sapId);
                statement.setString(2, date);
                statement.setString(3, time);
                statement.setString(4, "in");
                statement.execute();
                
            } else {
                statement = conn.prepareStatement("UPDATE faculty SET out_time = ?, status = ? WHERE sap_id = ? AND in_time = ?");
                statement.setString(1, time);
                statement.setString(2, "out");
                statement.setString(3, sapId);
                statement.setString(4, inTime);
                statement.execute();
            }
        } catch (SQLException ex) {
            Logger.getLogger(FacultyController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(FacultyController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
