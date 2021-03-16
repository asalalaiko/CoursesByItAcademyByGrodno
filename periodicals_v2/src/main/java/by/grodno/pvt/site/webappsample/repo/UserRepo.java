package by.grodno.pvt.site.webappsample.repo;

import by.grodno.pvt.site.webappsample.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserRepo extends JpaRepository<User, Integer> {
    User findByUsername(String username);

    User  findByIdGoogle(String idGoogle);
}
