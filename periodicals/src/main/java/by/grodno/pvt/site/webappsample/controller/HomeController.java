package by.grodno.pvt.site.webappsample.controller;

import by.grodno.pvt.site.webappsample.service.ReleaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {


    @Autowired
    private ReleaseService releaseService;

    @GetMapping("/")
    public String home (Model model){
        model.addAttribute("title", "Главная страница");
        model.addAttribute("release", releaseService.getReleases());


        return "home";
    }


}