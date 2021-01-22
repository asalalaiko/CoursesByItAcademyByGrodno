package by.grodno.pvt.site.webappsample.service;

import by.grodno.pvt.site.webappsample.domain.UserAddress;

import java.util.List;

public interface UserAddressServise {

    List<UserAddress> getUserAddresses();

    UserAddress getUserAddress(Integer id);

    void addUserAddress(List<UserAddress> userAddresses);

    void saveUserAddress(UserAddress userAddress);

    void deleteUserAddress(Integer id);


}
