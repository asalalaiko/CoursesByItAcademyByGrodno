package by.grodno.pvt.site.webappsample.service.impl;


import by.grodno.pvt.site.webappsample.domain.User;
import by.grodno.pvt.site.webappsample.repo.UserRepo;
import by.grodno.pvt.site.webappsample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class JPAUserService implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public List<User> getUsers() {
        return userRepo.findAll();
    }

    @Override
    public User getUser(Integer id) {
        return userRepo.getOne(id);
    }

    @Override
    public void addUser(List<User> users) {
        userRepo.saveAll(users);

    }

    @Override
    public void saveUser(User user) {
        userRepo.save(user);
    }

    @Override
    public void deleteUser(Integer id) {
        userRepo.deleteById(id);
    }

    @Override
    public List<User> findByName(String name) {
        return null;
    }
}
