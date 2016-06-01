/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package article;

import java.io.Serializable;
import user.User;

/**
 *
 * @author otaviotarelho
 */

public class Comment implements Serializable{
    private Long id;
    private User author;
    private Long article;
    private String content;
    private String dateOfCreation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(String dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public Comment() {
    }

    public Long getArticle() {
        return article;
    }

    public void setArticle(Long article) {
        this.article = article;
    }
    
}
