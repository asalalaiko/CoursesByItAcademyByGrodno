package by.grodno.pvt.site.webappsample.service.impl;

import by.grodno.pvt.site.webappsample.domain.User;
import by.grodno.pvt.site.webappsample.domain.UserAddress;
import by.grodno.pvt.site.webappsample.repo.UserAddressRepo;
import by.grodno.pvt.site.webappsample.service.UserAddressServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class JPAUserAddress implements UserAddressServise {

    @Autowired
    private UserAddressRepo userAddressRepo;


    @Override
    public List<UserAddress> getUserAddresses() {
        return userAddressRepo.findAll();
    }

    @Override
    public List<UserAddress> getUserAddressesByUser(User user) {
        return userAddressRepo.findByUser(user);

    }

    @Override
    public UserAddress getUserAddress(Integer id) {
        return userAddressRepo.getOne(id);
    }

    @Override
    public void addUserAddress(List<UserAddress> userAddresses) {
        userAddressRepo.saveAll(userAddresses);
    }

    @Override
    public void saveUserAddress(UserAddress userAddress) {
        userAddressRepo.save(userAddress);
    }

    @Override
    public void deleteUserAddress(Integer id) {
        userAddressRepo.deleteById(id);

    }
}
