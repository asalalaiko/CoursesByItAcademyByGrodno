package by.grodno.pvt.site.webappsample.controller;

import by.grodno.pvt.site.webappsample.domain.User;
import by.grodno.pvt.site.webappsample.domain.UserAddress;
import by.grodno.pvt.site.webappsample.service.UserAddressServise;
import by.grodno.pvt.site.webappsample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class UserAddressController {

    @Autowired
    private UserAddressServise userAddressServise;
    @Autowired
    private UserService userService;




    @GetMapping("/user/address")
    public String getAllUserAddress(Model model, Authentication authentication) {

        User user = (User) authentication.getPrincipal();
        model.addAttribute("address", userAddressServise.getUserAddressesByUser(user));

        return "/user/address";
    }

    @GetMapping("/user/addressNew")
    public String gerForm(UserAddress userAddress, Model model) {
        if (userAddress == null) {
            userAddress = new UserAddress();
        }
        model.addAttribute("useraddress", userAddress);
        return "/user/addressNew";
    }

    @GetMapping("/user/address/delete/")
    public String deleteUserAddress(@RequestParam(value="id") Integer id) {
        userAddressServise.deleteUserAddress(id);
        return "redirect:/user/address";
    }

    @PostMapping("/user/addressNew")
    public String registerPage(@Valid UserAddress userAddress, Authentication authentication, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("UserAddress", userAddress);
            return "user/addressNew";
        }

        User user = (User) authentication.getPrincipal();
        userAddress.setUser(user);
        userAddressServise.saveUserAddress(userAddress);

        return "redirect:/user/address";
    }

    @GetMapping("/user/address/edit/")
    public String getAddress(@RequestParam(value="id") Integer id, Model model){
        UserAddress userAddress = userAddressServise.getUserAddress(id);
        model.addAttribute("useraddress", userAddress);

        return "useraddress";

    }


}
