/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filter;

import bean.UserBackBean;
import java.io.IOException;
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
@WebFilter(filterName = "AdminFilter", urlPatterns = {"/faces/admin/*"},
        dispatcherTypes = {DispatcherType.REQUEST})

public class AdminFilter implements Filter {
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest) request).getSession(true);
        UserBackBean mb = new UserBackBean();
        mb.setUser((User) session.getAttribute("user"));
        if(mb.getUser() != null && mb.getUser().isAuthorized()){
            chain.doFilter(request, response);
        }
        else {
            String contextPath = ((HttpServletRequest) request).getContextPath();
            mb.setMessage("Please, enter your login or password");
            ((HttpServletResponse) response).sendRedirect(contextPath + "/faces/login.xhtml");
        }
    }
    
    @Override
    public void destroy() {

    }
}
