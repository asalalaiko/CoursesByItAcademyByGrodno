package by.grodno.pvt.site.webappsample.service.impl;

import by.grodno.pvt.site.webappsample.domain.Order;
import by.grodno.pvt.site.webappsample.repo.OrderRepo;
import by.grodno.pvt.site.webappsample.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class JPAOrderService implements OrderService {

    @Autowired
    private OrderRepo orderRepo;


    @Override
    public List<Order> getOrders() {
        return orderRepo.findAll();
    }

    @Override
    public Order getOrder(Integer id) {
        return orderRepo.getOne(id);
    }

    @Override
    public void addOrder(List<Order> orders) {
        orderRepo.saveAll(orders);

    }

    @Override
    public void saveOrder(Order order) {
        orderRepo.save(order);
    }

    @Override
    public void deleteOrder(Integer id) {
        orderRepo.deleteById(id);
    }
}
