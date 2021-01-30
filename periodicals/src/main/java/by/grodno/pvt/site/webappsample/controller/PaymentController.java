package by.grodno.pvt.site.webappsample.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PaymentController {

    @GetMapping("/user/pay")
    public String getPay (Model model) {


        return "/user/pay";
    }

    @PostMapping("/user/pay")
    public String postPay (Model model) {


        return "/";
    }


}
