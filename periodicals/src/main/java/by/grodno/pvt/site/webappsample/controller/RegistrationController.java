package by.grodno.pvt.site.webappsample.controller;


import by.grodno.pvt.site.webappsample.domain.User;
import by.grodno.pvt.site.webappsample.domain.UserRole;
import by.grodno.pvt.site.webappsample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Collections;

@Controller
public class RegistrationController {
    @Autowired
    private UserService service;

    @GetMapping("/activate/{id}")
    String activation(@PathVariable Integer id) {

   //    service.activateUser(id);

        return "redirect:/login";
    }

    @GetMapping("/register")
    String getForm(User user, Model model) {
        if (user == null) {
            user = new User();
        }
        model.addAttribute("user", user);
        return "registerView";
    }


    @PostMapping("/register/new")
    String registerPage(@Valid User user, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("User", user);
            return "registerView";
        }
        user.setRoles(UserRole.USER);
        service.saveUser(user);

        return "redirect:/login";
    }

}
