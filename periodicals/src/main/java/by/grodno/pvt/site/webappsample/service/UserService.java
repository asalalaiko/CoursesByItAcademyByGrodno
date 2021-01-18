package by.grodno.pvt.site.webappsample.service;

import by.grodno.pvt.site.webappsample.domain.User;

import java.util.List;

public interface UserService {

    List<User> getUsers();

    User getUser(Integer id);

    void addUser(List<User> users);

    void saveUser(User user);

    void deleteUser(Integer id);

    List<User> findByName(String name);

}
