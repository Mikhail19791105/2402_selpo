package by.itclass.controllers.user;

import by.itclass.controllers.abstraction.UserAbstractController;
import by.itclass.model.entities.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static by.itclass.constants.Constants.*;

@WebServlet(REGISTRATION_CONTROLLER)
public class RegistrationController extends UserAbstractController {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var name = req.getParameter(NAME_PARAM);
        var email = req.getParameter(EMAIL_PARAM);
        var login = req.getParameter(LOGIN_PARAM);
        var password = req.getParameter(PASS_PARAM);
        var user = new User(name, login, email, password.toCharArray());
        if (userService.addUser(user)) {
            redirect(resp, LOGIN_JSP);
        } else {
            forward(req, resp, REGISTRATION_JSP,"Registration is not success");
        }
    }
}
