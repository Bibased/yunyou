package com.yunyou.filter;

import com.yunyou.common.util.ApplicationContextProxy;
import com.yunyou.dal.entity.User;
import com.yunyou.service.UserService;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by dell on 2017/4/7.
 */
public class UserFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session=request.getSession();
        User user = (User) session.getAttribute("user");
        UserService userService = ApplicationContextProxy.getBean("userService");
        if(!userService.legalUser(user))
        {
            response.sendRedirect("/signin.html");
            return;
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
