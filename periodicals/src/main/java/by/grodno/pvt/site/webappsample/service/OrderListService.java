package by.grodno.pvt.site.webappsample.service;


import by.grodno.pvt.site.webappsample.domain.Order;
import by.grodno.pvt.site.webappsample.domain.OrderList;
import by.grodno.pvt.site.webappsample.domain.Release;

import java.util.List;

public interface OrderListService {

    List<OrderList> getOrderLists();

    OrderList getOrderList(Integer id);

    void addOrderList(List<OrderList> orderLists);

    void saveOrderList(OrderList orderList);

    void deleteOrderList(Integer id);

    void deleteByOrder(Order order);

    List<Release> getReleasesByOrder(Order order);

}
