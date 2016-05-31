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
/**
 *
 * @author otaviotarelho
 */
public class CommentsDAO {
    private static final String SQL_GET_COMMENTS = "SELECT * FROM 'comments' "
            + "WHERE articleID = ?";
    private static final String SQL_INSERT_COMMENTS = "";
    private static final String SQL_REMOVE_COMMENTS = "";
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
                    //c.setAuthor(rs.getString("author"), rs.getLong("authorID"));
                    c.setAuthor("Otavio",(long)1);
                    c.setId(rs.getLong("id"));
                    c.setContent(rs.getString("content"));
                    c.setDateOfCreation(rs.getDate("date"));
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
            //java.sql.Date date = new java.sql.Date(comment.getDateOfCreation());
            try (PreparedStatement stmt = connection.prepareStatement(SQL_INSERT_COMMENTS)) {
                stmt.setLong(1, comment.getAuthor().getId());
                stmt.setString(2, comment.getContent());
                //stmt.setDate(3, comment.getDateOfCreation());
                stmt.execute();
            } finally {
                connection.close();
            }
        } catch (SQLException e){
            throw e;
        }
    }
    
    public void removeComment(Long id) throws SQLException {
        try {
            connection = new ConnectionFactory().getConnection();
            try (PreparedStatement stmt = connection.prepareStatement(SQL_REMOVE_COMMENTS)) {
                stmt.setLong(1, id);
                stmt.execute();
            } finally {
                connection.close();
            }
        } catch (SQLException e){
            throw e;
        }
    }
}
