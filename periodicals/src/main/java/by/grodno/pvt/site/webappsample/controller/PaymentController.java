package by.grodno.pvt.site.webappsample.controller;


import by.grodno.pvt.site.webappsample.domain.Order;
import by.grodno.pvt.site.webappsample.domain.Payment;
import by.grodno.pvt.site.webappsample.service.OrderService;
import by.grodno.pvt.site.webappsample.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;



@Controller
public class PaymentController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private PaymentService paymentService;


    @GetMapping("/user/pay/")
    public String getPay (@RequestParam(value="order") Integer orderId, Model model) {

        Order order = orderService.getOrder(orderId);
        model.addAttribute("order", order);

        return "/user/pay";

    }

    @PostMapping("/user/pay/")
    public String postPay (@RequestParam(value="order") Integer orderId,
                           @RequestParam String holdername,
                           @RequestParam String cardno,
                           @RequestParam String cvcpwd,
                           @RequestParam String exp,
                           @RequestParam String sum) {

        Payment payment = new Payment();
        Date date = new Date();
        String transaction =  "Payment: " +holdername +"|"+ cardno +"|"+ cvcpwd +"|"+ exp +"summa:" + sum;


        payment.setDatePay(date);
        payment.setTransaction(transaction);
        paymentService.savePayment(payment);

        return "redirect:/";

    }


}
