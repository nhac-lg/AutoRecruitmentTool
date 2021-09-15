/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import dataobjects.*;
import java.sql.*;

/**
 *
 * @author Eagle
 */
public class DBServer {
    private final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private Connection connection;
    private static String user;
    private static String password;
    private static String DB_URL;

    public boolean connect() {
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, user, password);
            return true;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
            // Could not connect to the database
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void setDatabase(String user, String password, String DB_URL){
        DBServer.user = user;
        DBServer.password = password;
        DBServer.DB_URL = DB_URL;
    }
            
    public boolean AddCandidate(Candidate oCandidate)
    {
        String query = "INSERT INTO `candidate` (`id`, `name`, `phone`, `job_title`, `cv_date`, `experience`, `expectation`, `location`, `referral`, `latest_result`)" +
        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString (2, oCandidate.getName());
            preparedStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }    

    public boolean AddUser(User oUser){
        return true;
    }
    
    public boolean UpdInfo_Candidate(String id, Candidate oCandidate){
        return true;
    }
}
