/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import article.Comment;
import article.CommentsDAO;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import user.User;

/**
 *
 * @author otaviotarelho
 */

@ManagedBean
@SessionScoped
public class CommentBackBean  implements Serializable {
    private Comment comment = new Comment();
    private List<Comment> comments = new ArrayList<>();
    private String ErrorMessage;

    public CommentBackBean() {
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
    
    public int getSize(){
        return this.comments.size();
    }
    
    public String add(long article, long user) throws SQLException{
        CommentsDAO c = new CommentsDAO();
        
        try {
            User author = new User();
            author.setId((long)user);
            comment.setArticle(article);
            comment.setAuthor(author);
            c.addNew(comment);
            
        } catch (SQLException e) {
            ErrorMessage = e.getMessage();
            Logger.getLogger(ArticleBackBean.class.getName()).log(Level.SEVERE, null, e);
            throw e;
        }
        
        return null;
    }
    
    public String list(long art) throws SQLException {
        CommentsDAO c = new CommentsDAO();
        
        try {
            
            this.setComments(c.getComments(art));
            
        } catch (SQLException e) {
            ErrorMessage = e.getMessage();
            Logger.getLogger(ArticleBackBean.class.getName()).log(Level.SEVERE, null, e);
            throw e;
        }
        return null;
    }
    
}
