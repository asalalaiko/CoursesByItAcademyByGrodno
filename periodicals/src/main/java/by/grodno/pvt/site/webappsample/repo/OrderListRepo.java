package by.grodno.pvt.site.webappsample.repo;

import by.grodno.pvt.site.webappsample.domain.Order;
import by.grodno.pvt.site.webappsample.domain.OrderList;
import by.grodno.pvt.site.webappsample.domain.Release;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderListRepo  extends JpaRepository<OrderList, Integer> {

    List<Release> findByOrder(Order order);

    void deleteByOrder(Order order);

}
