package by.grodno.pvt.site.webappsample.controller.admin;


import by.grodno.pvt.site.webappsample.domain.Order;
import by.grodno.pvt.site.webappsample.domain.OrderList;
import by.grodno.pvt.site.webappsample.domain.Payment;
import by.grodno.pvt.site.webappsample.domain.Release;
import by.grodno.pvt.site.webappsample.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class AdminOrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderListService orderListService;
    @Autowired
    private  ReleaseService releaseService;
    @Autowired
    private  PaymentService paymentService;


    @GetMapping("/admin/orders")
    public String getOrder (Model model) {

        model.addAttribute("order", orderService.getOrders());
        return "/admin/orders";
    }


    @GetMapping ("/admin/ship/")
    public String orderShip (@RequestParam(value="order") Integer id, Model model){

        model.addAttribute("order", orderService.getOrder(id));

        return "/admin/ship";
    }

    @GetMapping ("/admin/shiping/")
    public String orderShiping (@RequestParam(value="order") Integer id){

        Order order = new Order();
        order = orderService.getOrder(id);
        order.setStateShipment(true);
        orderService.saveOrder(order);

        return "redirect:/admin/orders";
    }



    @GetMapping ("/admin/pay/")
    public String orderPay (@RequestParam(value="order") Integer id, Model model) {

        model.addAttribute("order", orderService.getOrder(id));
        model.addAttribute("payment", paymentService.getPayments());


        return "/admin/pay";
    }


    @PostMapping("/admin/pay")
    public String orderPayment (@RequestParam(value="order") Integer id, Payment payment){

        Order order = new Order();
        order = orderService.getOrder(id);
        order.setStatePayment(true);
        orderService.saveOrder(order);

//        Payment payment1 = new Payment();
//        payment1 = paymentService.getPayment();
        payment.setOrder(order);
        paymentService.savePayment(payment);


        return "redirect:/admin/orders";
    }





//    @GetMapping("/admin/orderPayment")
//    public String paymentOrder (@RequestParam(value="id") Integer id) {
//
//        Order order = new Order();
//        order = orderService.getOrder(id);
//        order.setStatePayment(true);
//        orderService.saveOrder(order);
//
//
//        return "redirect:/admin/orders";
//    }


}
