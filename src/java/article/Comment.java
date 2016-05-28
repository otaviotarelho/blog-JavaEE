/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package article;

import java.util.Date;
import user.User;

/**
 *
 * @author otaviotarelho
 */

public class Comment {
    private Long id;
    private User author;
    private String content;
    private Date dateOfCreation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(String name, long id) {
        this.author.setName(name);
        this.author.setId(id);
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public Comment() {
    }

    public Comment(Long id, User author, String content, Date dateOfCreation) {
        this.id = id;
        this.author = author;
        this.content = content;
        this.dateOfCreation = dateOfCreation;
    }
       
}
