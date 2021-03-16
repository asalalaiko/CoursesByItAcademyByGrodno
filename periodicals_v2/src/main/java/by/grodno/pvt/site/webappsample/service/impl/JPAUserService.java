package by.grodno.pvt.site.webappsample.service.impl;

import by.grodno.pvt.site.webappsample.domain.User;
import by.grodno.pvt.site.webappsample.domain.UserRole;
import by.grodno.pvt.site.webappsample.repo.UserRepo;
import by.grodno.pvt.site.webappsample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class JPAUserService implements UserService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @Override
    public User getUser(Integer id) {
        return userService.getUser(id);
    }

    @Override
    public boolean addUser(User user) {
        User userFromDb = (User) userService.findByUsername(user.getUsername());


        if (userFromDb != null) {
            return false;
        }

        user.setActive(false);
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
        userService.deleteUser(id);
    }

    @Override
    public User findByUsername(String username) {
        return userRepo.findByUsername(username);
    }


    @Override
    public  User findByIdGoogle(String idGoogle){
        return  userRepo.findByIdGoogle(idGoogle);
    }

}
