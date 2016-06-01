/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filter;

import beans.ArticleBackBean;
import beans.UserBackBean;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import user.User;

/**
 *
 * @author otaviotarelho
 */
@WebFilter(filterName = "AdminFilter", urlPatterns = {"/faces/admin/*"}, dispatcherTypes = {DispatcherType.REQUEST})

public class AdminFilter implements Filter {
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest) request).getSession(false);
        User user = ((User) session.getAttribute("user"));
        if(user != null && user.isAuthorized() && user.getType() != 2){
            chain.doFilter(request, response);
            Logger.getLogger(AdminFilter.class.getName()).log(Level.SEVERE, null, user.getType());
        }
        else {
            user = new User();
            session.setAttribute("user", user);
            String contextPath = ((HttpServletRequest) request).getContextPath();
            ((HttpServletResponse) response).
                    sendRedirect(contextPath + "/faces/index.xhtml");
        }
    }
    
    @Override
    public void destroy() {

    }
}
