/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import java.util.Date;

/**
 *
 * @author otaviotarelho
 */
public class User {
    private Long id;
    private String username;
    private String pwd;
    private Integer type;
    private String name;
    private Date lastSignIn;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getLastSignIn() {
        return lastSignIn;
    }

    public void setLastSignIn(Date lastSignIn) {
        this.lastSignIn = lastSignIn;
    }

    public User() {
    }

    public User(Long id, String username, String pwd, Integer type, String name) {
        this.id = id;
        this.username = username;
        this.pwd = pwd;
        this.type = type;
        this.name = name;
    }
    
}
