package by.itclass.controllers.order;

import by.itclass.controllers.abstraction.AbstractController;
import by.itclass.model.entities.OrderItem;
import by.itclass.model.services.CartService;
import by.itclass.model.services.ServiceFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static by.itclass.constants.Constants.*;
import static by.itclass.model.services.ServiceType.CART_SERVICE;

@WebServlet(CART_CONTROLLER)
public class CartController extends AbstractController {
    private CartService cartService;

    @Override
    public void init() throws ServletException {
        cartService = (CartService) ServiceFactory.getInstance(CART_SERVICE);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var cartAction = req.getParameter(CART_ACTION_PARAM);
        var itemType = Integer.parseInt(req.getParameter(ITEM_TYPE_PARAM));
        var itemID = Integer.parseInt(req.getParameter(ITEM_ID_PARAM));
        var itemVendor = req.getParameter(ITEM_VENDOR_PARAM);
        var itemModel = req.getParameter(ITEM_MODEL_PARAM);
        var itemPrice = Double.parseDouble (req.getParameter(ITEM_PRICE_PARAM));
        var quantity = Integer.parseInt( req.getParameter(QUANTITY_PARAM));
        var item = new OrderItem(itemType,itemID,itemVendor,itemModel,itemPrice,quantity);
        var session = req.getSession();
        var items = cartService.processCart(session, cartAction, item);
        session.setAttribute(ORDER_ITEMS_ATTR, items);
        if ("add".equals(cartAction)) {
            redirectToProductPage(resp, itemType);
        } else {
            redirect(resp, CART_JSP);
        }
    }
    private void redirectToProductPage(HttpServletResponse resp, int itemType) throws IOException {
        switch (itemType) {
            case 1 -> redirect(resp, TV_CONTROLLER);
            case 2 -> redirect(resp, LAPTOP_CONTROLLER);
        }
    }
}
