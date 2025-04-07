package by.itclass.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

import static by.itclass.constants.Constants.*;

@WebFilter({LOGIN_CONTROLLER, REGISTRATION_CONTROLLER, LOGIN_JSP, REGISTRATION_JSP})
public class RegisteredUserFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        var session = ((HttpServletRequest)servletRequest).getSession();
        var  user = session.getAttribute(USER_ATTR);
        if (user != null) {
            servletRequest.getRequestDispatcher(HOME_JSP).forward(servletRequest, servletResponse);
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
