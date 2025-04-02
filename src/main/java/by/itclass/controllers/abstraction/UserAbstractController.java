package by.itclass.controllers.abstraction;

import by.itclass.model.services.ServiceFactory;
import by.itclass.model.services.UserService;
import jakarta.servlet.ServletException;

import static by.itclass.model.services.ServiceType.USER_SERVICE;

public class UserAbstractController extends AbstractController {
    protected UserService userService;

    @Override
    public void init() throws ServletException {
        userService = (UserService) ServiceFactory.getInstance(USER_SERVICE);
    }
}
