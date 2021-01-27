package by.grodno.pvt.site.webappsample.controller;


import by.grodno.pvt.site.webappsample.domain.Order;
import by.grodno.pvt.site.webappsample.domain.Release;
import by.grodno.pvt.site.webappsample.domain.User;
import by.grodno.pvt.site.webappsample.domain.UserAddress;
import by.grodno.pvt.site.webappsample.service.OrderService;
import by.grodno.pvt.site.webappsample.service.ReleaseService;
import by.grodno.pvt.site.webappsample.service.UserAddressServise;
import by.grodno.pvt.site.webappsample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Controller
public class OrderController {

    @Autowired
    private UserAddressServise userAddressServise;
    @Autowired
    private UserService userService;
    @Autowired
    private ReleaseService releaseService;
    @Autowired
    private ConversionService convertionService;
    @Autowired
    private OrderService orderService;



    private List<Release> getSoldReleases(HttpSession session) {
        return (List<Release>) session.getAttribute("selectRelease");
    }


    @GetMapping("/user/order")
    public String getOrder (Model model, Authentication authentication, HttpSession session) {

        User user = (User) authentication.getPrincipal();
        model.addAttribute("address", userAddressServise.getUserAddressesByUser(user));

        List<Release> attribute = getSoldReleases(session);
        if (attribute == null) {
            session.setAttribute("selectRelease", new ArrayList<Release>());
        }



        List<Release> releases = getSoldReleases(session);
        double sum = 0.0;
        for (Release release : releases)
        {
            sum = sum + release.getPrice();
        }


        model.addAttribute("release", getSoldReleases(session));
        model.addAttribute("sum", sum);

        return "/user/order";
    }


    @PostMapping("/user/order")
    public String saveOrder(@RequestParam(value="address") Integer address, Model model, Authentication authentication, HttpSession session){
        List<Release> releases = getSoldReleases(session);
        double sum = 0.0;
        for (Release release : releases)
        {
            sum = sum + release.getPrice();
        }
        User user = (User) authentication.getPrincipal();
        Date date = new Date();
        UserAddress userAddress = userAddressServise.getUserAddress(address);
        Order order = new Order();
        order.setUser(user);
        order.setDateOrder(date);
        order.setSumOrder(sum);
        //order.setUserAddress(userAddress);
        orderService.saveOrder(order);


        return "redirect:/user/pay";
    }


}
