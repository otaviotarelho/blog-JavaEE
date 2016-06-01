/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package article;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import user.User;
/**
 *
 * @author otaviotarelho
 */
public class CommentsDAO {
    private static final String SQL_GET_COMMENTS = "SELECT * FROM `comments`WHERE article = ?";
    private static final String SQL_INSERT_COMMENTS = "INSERT INTO `comments` (`authorID`, `article`, `content`, `date`) VALUES (?, ?, ?, NOW());";
    private Connection connection;
    
    public List<Comment> getComments(Long Article) throws SQLException{
        List<Comment> comments = new ArrayList<>();
        try{
            connection = new ConnectionFactory().getConnection();
            try{
                PreparedStatement stmt = connection.prepareStatement(SQL_GET_COMMENTS);
                stmt.setLong(1, Article);
                ResultSet rs = stmt.executeQuery();
                while(rs.next()){
                    Comment c = new Comment();
                    User u = new User();
                    u.setId((long)rs.getInt("authorID"));
                    c.setAuthor(u);
                    c.setId(rs.getLong("id"));
                    c.setContent(rs.getString("content"));
                    c.setDateOfCreation(rs.getString("date"));
                    comments.add(c);
                }
            } finally {
                connection.close();
            }
        
        } catch (SQLException e) {
            throw e;
        }
        
        return comments;
    }
    
    public void addNew(Comment comment) throws SQLException{
        try {
            connection = new ConnectionFactory().getConnection();
            try (PreparedStatement stmt = connection.prepareStatement(SQL_INSERT_COMMENTS)) {
                stmt.setLong(1, comment.getAuthor().getId());
                stmt.setLong(2, comment.getArticle());
                stmt.setString(3, comment.getContent());
                stmt.execute();
            } finally {
                connection.close();
            }
        } catch (SQLException e){
            throw e;
        }
    }
}
