package by.itclass.controllers.abstraction;

import by.itclass.model.services.OrderService;
import by.itclass.model.services.ServiceFactory;

import static by.itclass.model.services.ServiceType.ORDER_SERVICE;

public class OrderAbstractController extends AbstractController {
    protected OrderService orderService;

    @Override
    public void init() throws SecurityException {
        orderService = (OrderService) ServiceFactory.getInstance(ORDER_SERVICE);
    }
}
