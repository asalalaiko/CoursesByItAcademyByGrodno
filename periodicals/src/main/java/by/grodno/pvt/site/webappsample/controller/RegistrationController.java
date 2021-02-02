package by.grodno.pvt.site.webappsample.controller;


import by.grodno.pvt.site.webappsample.domain.User;
import by.grodno.pvt.site.webappsample.domain.dto.CaptchaResponseDto;
import by.grodno.pvt.site.webappsample.domain.UserRole;
import by.grodno.pvt.site.webappsample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {

    private final static String CAPTCHA_URL = "https://www.google.com/recaptcha/api/siteverify?secret=%s&response=%s";

    @Autowired
    private UserService userSevice;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Value("${recaptcha.secret}")
    private String secret;
    @Autowired
    private RestTemplate restTemplate;



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
    String registerPage(@RequestParam("g-recaptcha-response") String captchaResponse,
                        @Valid User user,
                        BindingResult bindingResult,
                        Model model) {
            String url = String.format(CAPTCHA_URL, secret, captchaResponse);
            CaptchaResponseDto response = restTemplate.postForObject(
                    url, Collections.emptyList(), CaptchaResponseDto.class);


        if (!response.isSuccess()) {
            model.addAttribute("captchaError", "Fill captcha");
        }



        if (user.getPassword() != null ) {
            model.addAttribute("passwordError", "Passwords are different!");
        }

        if (bindingResult.hasErrors() || !response.isSuccess()) {
            Map<String, String> errors = ControllerUtils.getErrors(bindingResult);

            model.mergeAttributes(errors);

            return "registerView";
        }

        if (!userSevice.addUser(user)) {
            model.addAttribute("usernameError", "User exists!");
            return "registerView";
        }



        return "redirect:/login";
    }

}
