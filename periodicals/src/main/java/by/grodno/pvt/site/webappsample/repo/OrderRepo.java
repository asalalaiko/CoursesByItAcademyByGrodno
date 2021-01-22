package by.grodno.pvt.site.webappsample.repo;

import by.grodno.pvt.site.webappsample.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order, Integer> {

}
