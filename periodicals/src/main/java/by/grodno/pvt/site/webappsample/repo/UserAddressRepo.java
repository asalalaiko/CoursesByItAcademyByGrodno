package by.grodno.pvt.site.webappsample.repo;

import by.grodno.pvt.site.webappsample.domain.User;
import by.grodno.pvt.site.webappsample.domain.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserAddressRepo extends JpaRepository<UserAddress, Integer> {
    List<UserAddress> findByUser(User user);

}
