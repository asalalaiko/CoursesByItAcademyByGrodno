package by.grodno.pvt.site.webappsample.controller.admin;


import by.grodno.pvt.site.webappsample.domain.*;
import by.grodno.pvt.site.webappsample.service.*;
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
public class AdminOrderController {

    @Autowired
    private OrderService orderService;


    @GetMapping("/admin/orders")
    public String getOrder (Model model) {

        model.addAttribute("order", orderService.getOrders());
        return "/admin/orders";
    }

    @GetMapping("/admin/orderPayment")
    public String paymentOrder (@RequestParam(value="id") Integer id) {

        Order order = new Order();
        order = orderService.getOrder(id);
        order.setStatePlayment(true);
        orderService.saveOrder(order);


        return "redirect:/admin/orders";
    }


}
