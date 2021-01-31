package by.grodno.pvt.site.webappsample.service.impl;

import by.grodno.pvt.site.webappsample.domain.Order;
import by.grodno.pvt.site.webappsample.domain.OrderList;
import by.grodno.pvt.site.webappsample.domain.Release;
import by.grodno.pvt.site.webappsample.repo.OrderListRepo;
import by.grodno.pvt.site.webappsample.service.OrderListService;
import by.grodno.pvt.site.webappsample.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class JPAOrderListService implements OrderListService {

    @Autowired
    private OrderListRepo orderListRepo;

    @Override
    public List<Release> getReleasesByOrder(Order order) {return  orderListRepo.findByOrder(order);}

    @Override
    public List<OrderList> getOrderLists() {
        return orderListRepo.findAll();
    }

    @Override
    public OrderList getOrderList(Integer id) {
        return orderListRepo.getOne(id);
    }

    @Override
    public void addOrderList(List<OrderList> orderLists) {
        orderListRepo.saveAll(orderLists);

    }

    @Override
    public void saveOrderList(OrderList orderList) {
        orderListRepo.save(orderList);
    }

    @Override
    public void deleteOrderList(Integer id) {
        orderListRepo.deleteById(id);
    }

    @Override
    public void deleteByOrder(Order order) {orderListRepo.deleteByOrder(order);}


}
