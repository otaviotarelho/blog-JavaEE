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
    private static final String SQL_NEW = "";
    private static final String SQL_REMOVE = "";
    private static final String SQL_USERS = "SELECT * FROM users";
    private Connection connection;
    
    public void addNew(User user) throws SQLException {
        try {
            connection = new ConnectionFactory().getConnection();
            try {
                PreparedStatement stmt = connection.prepareStatement(SQL_NEW);
                stmt.setString(1, user.getName());
                stmt.setString(2, user.getUsername());
                stmt.setString(3, user.getPwd());
                stmt.setInt(3, user.getType());
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
                    User u = new User();
                    u.setId(rs.getLong("id"));
                    u.setName(rs.getString("name"));
                    u.setUsername(rs.getString("username"));
                    u.setType(rs.getInt("type"));
                    u.setLastSignIn(rs.getDate("lastsingin"));
                    u.setPwd(rs.getString("pwd"));
                    users.add(u);
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
