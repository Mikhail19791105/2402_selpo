package by.itclass.controllers.abstraction;

import by.itclass.model.services.OrderService;
import by.itclass.model.services.ServiceFactory;
import by.itclass.model.services.UserService;
import jakarta.servlet.ServletException;

import static by.itclass.model.services.ServiceType.ORDER_SERVICE;
import static by.itclass.model.services.ServiceType.USER_SERVICE;

public class AdminAbstractController extends AbstractController {
    protected UserService userService;
    protected OrderService orderService;

    @Override
    public void init() throws ServletException {
        userService = (UserService) ServiceFactory.getInstance(USER_SERVICE);
        orderService = (OrderService) ServiceFactory.getInstance(ORDER_SERVICE);
    }
}
