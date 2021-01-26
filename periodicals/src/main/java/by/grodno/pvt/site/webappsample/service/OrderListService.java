package by.grodno.pvt.site.webappsample.service;


import by.grodno.pvt.site.webappsample.domain.OrderList;

import java.util.List;

public interface OrderListService {

    List<OrderList> getOrderLists();

    OrderList getOrderList(Integer id);

    void addOrderList(List<OrderList> orderLists);

    void saveOrderList(OrderList orderList);

    void deleteOrderList(Integer id);


}
