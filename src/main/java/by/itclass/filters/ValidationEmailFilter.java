package by.itclass.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

import static by.itclass.constants.Constants.*;

@WebFilter(value = REGISTRATION_CONTROLLER, dispatcherTypes = DispatcherType.REQUEST)
public class ValidationEmailFilter implements Filter {
    public static final String EMAIL_REGEX = "^[\\w]+(?:\\.\\w+)*@[\\w]+(?:\\.\\w+)*$";

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        var email = servletRequest.getParameter(EMAIL_PARAM);
        if (!email.matches(EMAIL_REGEX)) {
            servletRequest.setAttribute(MESSAGE_ATTR, "Wrong email");
            servletRequest.getRequestDispatcher(REGISTRATION_JSP).forward(servletRequest, servletResponse);
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
