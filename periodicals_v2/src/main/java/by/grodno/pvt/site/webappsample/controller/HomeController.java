package by.grodno.pvt.site.webappsample.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home (Model model){
        model.addAttribute("title", "Главная страница");
        model.addAttribute("columnQuantity", 5);

        return "home";
    }
}
