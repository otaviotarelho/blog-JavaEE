/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author otaviotarelho
 */
public class UserDAO {
    private static final String SQL_NEW = "INSERT INTO `users` (`name`, `username`, `pwd`, `type`, `valid`) VALUES (?, ?, ?, ?, 1)";
    private static final String SQL_REMOVE = "UPDATE `blog`.`users` SET `valid`='0' WHERE `id`=?;";
    private static final String SQL_USERS = "SELECT * FROM users";
    private static final String SQL_USER = "SELECT * FROM users where username = ?";
    private Connection connection;
    
    public void addNew(User user) throws SQLException {
        try {
            connection = new ConnectionFactory().getConnection();
            try {
                PreparedStatement stmt = connection.prepareStatement(SQL_NEW);
                stmt.setString(1, user.getName());
                stmt.setString(2, user.getUsername());
                stmt.setString(3, user.getPwd());
                stmt.setInt(4, user.getType());
                stmt.execute();
                stmt.close();
            } finally {
                connection.close();
            }
        } catch (SQLException e) {
            throw e;
        }
    }
    
    public void remove(Long id) throws SQLException {
        try {
            connection = new ConnectionFactory().getConnection();
            try {
                PreparedStatement stmt = connection.prepareStatement(SQL_REMOVE);
                stmt.setLong(1, id);
                stmt.execute();
                stmt.close();
            } finally {
                connection.close();
            }
        } catch (SQLException e) {
            throw e;
        }
    }
    
    public List<User> getUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        
        try {
            connection = new ConnectionFactory().getConnection();
            try {
                PreparedStatement stmt = connection.prepareStatement(SQL_USERS);
                ResultSet rs = stmt.executeQuery();
                
                while(rs.next()) {
                    if(rs.getInt("valid") != 0){
                        User u = new User();
                        u.setId(rs.getLong("id"));
                        u.setName(rs.getString("name"));
                        u.setUsername(rs.getString("username"));
                        u.setType(rs.getInt("type"));
                        u.setLastSignIn(rs.getDate("lastsingin"));
                        u.setPwd(rs.getString("pwd"));
                        users.add(u);
                    }
                }
                
                stmt.close();
            } finally {
                connection.close();
            }
        } catch (SQLException e) {
            throw e;
        }
        
        return users;
    }
    
    public User getUser(String username) throws SQLException {
        User users = new User();
        
        try {
            connection = new ConnectionFactory().getConnection();
            try {
                PreparedStatement stmt = connection.prepareStatement(SQL_USER);
                stmt.setString(1, username);
                ResultSet rs = stmt.executeQuery();
                
                while(rs.next()) {
                    if(rs.getInt("valid") != 0){
                        users.setId(rs.getLong("id"));
                        users.setName(rs.getString("name"));
                        users.setUsername(rs.getString("username"));
                        users.setType(rs.getInt("type"));
                        users.setLastSignIn(rs.getDate("lastsingin"));
                        users.setPwd(rs.getString("pwd"));
                    }
                }
                
                stmt.close();
            } finally {
                connection.close();
            }
        } catch (SQLException e) {
            throw e;
        }
        
        return users;
    }
}
