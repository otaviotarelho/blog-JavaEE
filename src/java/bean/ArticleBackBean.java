/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

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

/**
 *
 * @author otaviotarelho
 */
@ManagedBean
@SessionScoped

public class ArticleBackBean {

    private Article article = new Article();
    private List<Article> articles = new ArrayList<>();
    private String ErrorMessage;

    public ArticleBackBean() throws SQLException {
       
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

        try {
            a.addNew(article);
        } catch (SQLException e) {
            ErrorMessage = e.getMessage();
            Logger.getLogger(ArticleBackBean.class.getName()).log(Level.SEVERE, null, e);
            throw e;
        }

        return null;
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

    public String getArticleByUser(Long id) throws SQLException {
        ArticleDAO a = new ArticleDAO();
        try {
            a.getByUser(id);
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

        return null;
    }

    public String editArticle() throws SQLException {
        ArticleDAO a = new ArticleDAO();
        try {
            a.remove(article.getId());
        } catch (SQLException e) {
            ErrorMessage = e.getMessage();
            Logger.getLogger(ArticleBackBean.class.getName()).log(Level.SEVERE, null, e);
            throw e;
        }

        return null;
    }

}
