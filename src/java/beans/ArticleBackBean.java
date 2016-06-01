/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import article.Article;
import article.ArticleDAO;
import java.io.Serializable;
import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import user.User;

/**
 *
 * @author otaviotarelho
 */
@ManagedBean
@SessionScoped

public class ArticleBackBean implements Serializable {

    private Article article = new Article();
    private List<Article> articles = new ArrayList<>();
    private String ErrorMessage;

    public ArticleBackBean() throws SQLException {
       
    }
    
    public void newArticle() {
        article = new Article();
    }
    
    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public String getErrorMessage() {
        return ErrorMessage;
    }

    public void setErrorMessage(String ErrorMessage) {
        this.ErrorMessage = ErrorMessage;
    }

    public String registerNewArticle() throws SQLException {
        ArticleDAO a = new ArticleDAO();
        User user = null;
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
        user = (User) session.getAttribute("user");
        
        try {
            article.setCreator(user);
            a.addNew(article);
        } catch (SQLException e) {
            ErrorMessage = e.getMessage();
            Logger.getLogger(ArticleBackBean.class.getName()).log(Level.SEVERE, null, e);
            throw e;
        }

        return "main";
    }

    public String getAllArticle() throws SQLException {
        ArticleDAO a = new ArticleDAO();

        try {
            setArticles(a.getAll());
        } catch (SQLException e) {
            ErrorMessage = e.getMessage();
            Logger.getLogger(ArticleBackBean.class.getName()).log(Level.SEVERE, null, e);
            throw e;
        }

        return null;
    }

    public String getArticle(Long id) throws SQLException {
        ArticleDAO a = new ArticleDAO();
        try {
            setArticle(a.getOne(id));
        } catch (SQLException e) {
            ErrorMessage = e.getMessage();
            Logger.getLogger(ArticleBackBean.class.getName()).log(Level.SEVERE, null, e);
            throw e;
        }

        return null;
    }

    public String removeArticle(Long id) throws SQLException {
        ArticleDAO a = new ArticleDAO();
        try {
            a.remove(id);
        } catch (SQLException e) {
            ErrorMessage = e.getMessage();
            Logger.getLogger(ArticleBackBean.class.getName()).log(Level.SEVERE, null, e);
            throw e;
        }

        return "main";
    }

    public String editArticle() throws SQLException {
        ArticleDAO a = new ArticleDAO();
        try {
            a.edit(article);
        } catch (SQLException e) {
            ErrorMessage = e.getMessage();
            Logger.getLogger(ArticleBackBean.class.getName()).log(Level.SEVERE, null, e);
            throw e;
        }

        return "main";
    }

}
