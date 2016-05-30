/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import article.CommentsDAO;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import user.User;
import user.UserDAO;

/**
 *
 * @author otaviotarelho
 */

@ManagedBean
@SessionScoped

public class UserBackBean implements Serializable {
    private User user = new User();
    private List<User> users = new ArrayList<>();
    private String ErrorMessage;

    public UserBackBean() throws SQLException {
        list();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
    
    public String add() throws SQLException{
        UserDAO u = new UserDAO();
        
        try {
            
            u.addNew(user);
            
        } catch (SQLException e) {
            ErrorMessage = e.getMessage();
            Logger.getLogger(ArticleBackBean.class.getName()).log(Level.SEVERE, null, e);
            throw e;
        }
        
        return null;
    }
    
    public String list() throws SQLException{
        UserDAO u = new UserDAO();
        
        try {
            
            setUsers(u.getUsers());
            
        } catch (SQLException e) {
            ErrorMessage = e.getMessage();
            Logger.getLogger(ArticleBackBean.class.getName()).log(Level.SEVERE, null, e);
            throw e;
        }
        
        return null;
    }
    
    public String remove(Long id) throws SQLException{
        UserDAO u = new UserDAO();
        
        try {
            
            u.remove(id);
            
        } catch (SQLException e) {
            ErrorMessage = e.getMessage();
            Logger.getLogger(ArticleBackBean.class.getName()).log(Level.SEVERE, null, e);
            throw e;
        }
        
        return null;
    }
    
    private static final String USERNAME = "otaviotarelho";
    private static final String PWD = "123";
    private boolean authorized;
    private String message;

    public boolean isAuthorized() {
        return authorized;
    }

    public void setAuthorized(boolean authorized) {
        this.authorized = authorized;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    public String loggin(){
        if(user.getUsername().equals(USERNAME) && user.getPwd().equals(PWD)){
            authorized = true;
            return "/admin/main";
        }
        message = "Username or password incorret!";
        return null;
    }
    
    public String logout(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/index";
    }
}
