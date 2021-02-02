package by.grodno.pvt.site.webappsample.service;

import by.grodno.pvt.site.webappsample.domain.User;
import by.grodno.pvt.site.webappsample.domain.UserRole;
import by.grodno.pvt.site.webappsample.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

public interface UserService {

    List<User> getUsers();

    User getUser(Integer id);

    boolean addUser(User user);

    public void saveUser(User user);

    void deleteUser(Integer id);

    List<User> findByUsername(String username);






}
