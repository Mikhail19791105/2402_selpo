package by.itclass.model.services;

import java.util.Map;

import static by.itclass.model.services.ServiceType.*;

public class ServiceFactory {
    private  static Map<ServiceType, Service> services;

    public static void init() {
        services = Map.ofEntries(
                Map.entry(CART_SERVICE, new CartService()),
                Map.entry(LAPTOP_SERVICE, new LaptopService()),
                Map.entry(ORDER_SERVICE, new OrderService()),
                Map.entry(TV_SERVICE, new TvService()),
                Map.entry(USER_SERVICE, new UserService())
        );
    }

    public static  Service getInstance(ServiceType serviceType) {
        return services.get(serviceType);
    }
}
