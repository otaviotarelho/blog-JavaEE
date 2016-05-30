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
import java.util.ArrayList;
import java.util.List;
import user.User;

/**
 *
 * @author otaviotarelho
 */
public class ArticleDAO {

    private static final String SQL_NEW = "INSERT INTO `blog`.`articles` (`title`, `body`, `date`, `authorID`) "
            + "VALUES ('?', '?', 'now()', '1');";
    private static final String SQL_SELECT_ONE = "SELECT * FROM articles WHERE id=?";
    private static final String SQL_SELECT_ALL = "SELECT * FROM articles ";
    private static final String SQL_SELECT_USER = "SELECT * FROM articles where author=?";
    private static final String SQL_REMOVE = "";
    private static final String SQL_EDIT = "";
    private Connection connection;

    public void addNew(Article article) throws SQLException {
        try {
            connection = new ConnectionFactory().getConnection();
            try {
                PreparedStatement stmt = connection.prepareStatement(SQL_NEW);
                stmt.setString(1,article.getTitle());
                stmt.setString(2,article.getBody());
                stmt.setLong(3, 1);
                stmt.execute();
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
                try (PreparedStatement stmt = connection.prepareStatement(SQL_REMOVE)) {
                    stmt.setLong(1, id);
                    stmt.execute();
                }
            } finally {
                connection.close();
            }
        } catch (SQLException e) {
            throw e;
        }
    }

    public List<Article> getAll() throws SQLException {
        List<Article> articles = new ArrayList<>();
        try {
            connection = new ConnectionFactory().getConnection();
            try {
                ResultSet rs;
                try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_ALL)) {
                    rs = stmt.executeQuery();
                    while (rs.next()) {
                        Article a = new Article();
                        a.setId(rs.getLong("id"));
                        a.setBody(rs.getString("body"));
                        a.setCreated(rs.getDate("date"));
                        a.setTitle(rs.getString("title"));
                        
                        User u = new User();
                        //u.setId(rs.getLong("authorID"));
                        //u.setName(rs.getString("author"));
                        u.setId((long)1);
                        u.setName("Otavio");
                        a.setCreator(u);
                        
                        articles.add(a);
                    }
                }
                rs.close();
            } finally {
                connection.close();
            }
        } catch (SQLException e) {
            throw e;
        }

        return articles;
    }
    
    public Article getByUser(Long user) throws SQLException {
        Article articles = new Article();
        try {
            connection = new ConnectionFactory().getConnection();
            try {
                ResultSet rs;
                try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_ALL)) {
                    stmt.setLong(1, user);
                    rs = stmt.executeQuery();
                    while (rs.next()) {
                        articles.setId(rs.getLong("id"));
                        articles.setBody(rs.getString("body"));
                        articles.setCreated(rs.getDate("date"));
                        articles.setTitle(rs.getString("title"));
                        User u = new User();
                        u.setId(rs.getLong("authorID"));
                        u.setName(rs.getString("author"));
                        articles.setCreator(u);
                    }
                }
                rs.close();
            } finally {
                connection.close();
            }
        } catch (SQLException e) {
            throw e;
        }

        return articles;
    }
    
    public Article getOne(Long art) throws SQLException {
        Article articles = new Article();
        try {
            connection = new ConnectionFactory().getConnection();
            try {
                ResultSet rs;
                try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_ONE)) {
                    stmt.setLong(1, art);
                    rs = stmt.executeQuery();
                    while (rs.next()) {
                        articles.setId(rs.getLong("id"));
                        articles.setBody(rs.getString("body"));
                        articles.setCreated(rs.getDate("date"));
                        articles.setTitle(rs.getString("title"));
                        
                        User u = new User();
                        u.setId((long)1);
                        u.setName("Otavio");
//                        u.setId(rs.getLong("authorID"));
//                        u.setName(rs.getString("author"));
                        articles.setCreator(u);
                        
                    }
                }
                rs.close();
            } finally {
                connection.close();
            }
        } catch (SQLException e) {
            throw e;
        }

        return articles;
    }

    public void edit(Article article) throws SQLException {
        try {
            connection = new ConnectionFactory().getConnection();
            try {
                try (PreparedStatement stmt = connection.prepareStatement(SQL_EDIT)) {
                    stmt.setString(1,article.getTitle());
                    stmt.setString(2,article.getBody());
                    stmt.setLong(3, article.getCreator().getId());
                    //stmt.setDate(4, article.getCreated());
                    stmt.setLong(5, article.getId());
                    stmt.execute();
                }
            } finally {
                connection.close();
            }
        } catch (SQLException e) {
            throw e;
        }
    }
}
