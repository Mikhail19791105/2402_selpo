package by.itclass.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static by.itclass.constants.Constants.*;

@WebFilter({TV_CONTROLLER, LAPTOP_CONTROLLER, HOME_JSP, CART_JSP, ADMIN_JSP})
public class AuthFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        var session = ((HttpServletRequest)servletRequest).getSession();
        var  user = session.getAttribute(USER_ATTR);
        if (user == null) {
            var req = (HttpServletRequest)servletRequest;
            var resp = (HttpServletResponse)servletResponse;
            resp.sendRedirect(req.getContextPath() + LOGIN_JSP);
        }else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
