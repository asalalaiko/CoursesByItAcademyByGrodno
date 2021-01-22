package by.grodno.pvt.site.webappsample.service;

import by.grodno.pvt.site.webappsample.domain.Order;

import java.util.List;

public interface OrderService {

    List<Order> getOrders();

    Order getOrder(Integer id);

    void addOrder(List<Order> orders);

    void saveOrder(Order order);

    void deleteOrder(Integer id);


}
