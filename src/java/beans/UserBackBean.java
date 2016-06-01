/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    private User newUser = new User();
    private List<User> users = new ArrayList<>();
    private String ErrorMessage;

    public UserBackBean(){
        
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

    public User getNewUser() {
        return newUser;
    }

    public void setNewUser(User newUser) {
        this.newUser = newUser;
    }
    
    public String add(long local) throws SQLException{
        UserDAO u = new UserDAO();
        
        try {
            
            u.addNew(newUser);
            
        } catch (SQLException e) {
            ErrorMessage = e.getMessage();
            Logger.getLogger(ArticleBackBean.class.getName()).log(Level.SEVERE, null, e);
            throw e;
        }
        if(local == 1){
          return "./index.html";  
        }
        else{
          return "./users.html";  
        }
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
    
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    public String loggin() throws SQLException{
        UserDAO u = new UserDAO();
        User aux = new User();
        
        aux = u.getUser(user.getUsername());
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(true);
        
        if(user.getUsername().equals(aux.getUsername()) && user.getPwd().equals(aux.getPwd())){
            user = aux;
            user.setAuthorized(true);
            session.setAttribute("user", user);
            if(user.getType() == 1){
                return "/admin/main";
            }
            else{
                return "/index";
            }
        }
        message = "Username or password incorret!";
        return null;
    }
    
    public String logout(){
        user.setAuthorized(false);
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/index";
    }
}
