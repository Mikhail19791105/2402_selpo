package by.itclass.model.services;

import by.itclass.model.entities.OrderItem;
import jakarta.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;

import static by.itclass.constants.Constants.ORDER_ITEMS_ATTR;

public class CartService {
    private static CartService service;

    public static CartService getInstance() {
        if (service == null) {
            service = new CartService();
        }
        return service;
    }

    public List<OrderItem> processCart(HttpSession session, String cartAction, OrderItem orderitem) {
        var orderItems = session.getAttribute(ORDER_ITEMS_ATTR);
        var items = orderItems != null
                ? (List<OrderItem>) orderItems
                : new ArrayList<OrderItem>();
        switch (cartAction) {
            case "add" -> items.add(orderitem);
            case "remove" -> items.remove(orderitem);
           // case "increase" -> items.forEach(it -> changePurchase(it, orderitem, true));
           // case "decrease" -> items.forEach(it -> changePurchase(it, orderitem, false));
            case "change" -> items.forEach(it -> changePurchase(it, orderitem));
        }
        return items;
    }

    private void changePurchase(OrderItem sourceItem, OrderItem changedItem) {
        if (sourceItem.equals(changedItem)) {
            sourceItem.setQuantity(changedItem.getQuantity());
        }
    }
}
