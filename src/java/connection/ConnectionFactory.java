/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author otaviotarelho
 */
public class ConnectionFactory {
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/blog";
    private static final String DATABASE_USER = "root";
    private static final String DATABASE_PWD = "root";
    
    public Connection getConnection() throws SQLException {
        try{
            return DriverManager.getConnection(DATABASE_URL, DATABASE_USER,
                    DATABASE_PWD);
        }
        catch (SQLException e){
            throw e;
        }
    }
}
