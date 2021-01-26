package by.grodno.pvt.site.webappsample.repo;

import by.grodno.pvt.site.webappsample.domain.OrderList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderListRepo  extends JpaRepository<OrderList, Integer> {
}
