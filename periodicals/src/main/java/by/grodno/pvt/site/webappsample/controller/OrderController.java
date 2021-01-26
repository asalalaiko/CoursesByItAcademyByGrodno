package by.grodno.pvt.site.webappsample.controller;


import by.grodno.pvt.site.webappsample.domain.User;
import by.grodno.pvt.site.webappsample.service.UserAddressServise;
import by.grodno.pvt.site.webappsample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class OrderController {

    @Autowired
    private UserAddressServise userAddressServise;
    @Autowired
    private UserService userService;

    @GetMapping("/user/order")
    public String getOrder (Model model, Authentication authentication) {

        User user = (User) authentication.getPrincipal();
        model.addAttribute("address", userAddressServise.getUserAddressesByUser(user));



        return "/user/order";
    }


    @PostMapping("/user/order")
    public String saveOrder(){




        return "redirect:/user/pay";
    }


}
