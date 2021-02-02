package by.grodno.pvt.site.webappsample.service.impl;


import by.grodno.pvt.site.webappsample.domain.User;
import by.grodno.pvt.site.webappsample.repo.UserRepo;
import by.grodno.pvt.site.webappsample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import by.grodno.pvt.site.webappsample.domain.UserRole;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class JPAUserService implements UserService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<User> getUsers() {
        return userRepo.findAll();
    }

    @Override
    public User getUser(Integer id) {
        return userRepo.getOne(id);
    }

    @Override
    public boolean addUser(User user) {
        User userFromDb = userRepo.findByUsername(user.getUsername());

        if (userFromDb != null) {
            return false;
        }




        user.setActive(true);
        user.setRoles(UserRole.USER);
        user.setActivationCode(UUID.randomUUID().toString());


        user.setPassword(passwordEncoder.encode(user.getPassword()));

        saveUser(user);
        return true;
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
    public List<User> findByUsername(String username) {
        return null;
    }


}
