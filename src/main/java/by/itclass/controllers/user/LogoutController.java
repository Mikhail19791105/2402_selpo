package by.itclass.controllers.user;

import by.itclass.controllers.abstraction.AbstractController;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static by.itclass.constants.Constants.INDEX_JSP;
import static by.itclass.constants.Constants.LOGOUT_CONTROLLER;

@WebServlet(LOGOUT_CONTROLLER)
public class LogoutController extends AbstractController {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var session = req.getSession();
        session.invalidate();
        redirect(resp,INDEX_JSP);
    }
}
