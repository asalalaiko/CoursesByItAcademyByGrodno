package by.grodno.pvt.site.webappsample.repo;

import by.grodno.pvt.site.webappsample.domain.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAddressRepo extends JpaRepository<UserAddress, Integer> {
}
