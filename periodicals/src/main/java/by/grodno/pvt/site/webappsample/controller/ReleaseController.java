package by.grodno.pvt.site.webappsample.controller;

import by.grodno.pvt.site.webappsample.repo.ReleaseRepo;
import by.grodno.pvt.site.webappsample.service.ReleaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReleaseController {

    @Autowired
    private ReleaseRepo releaseRepo;
    @Autowired
    private ReleaseService releaseService;
    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping("/release")
    public String getReleaseById(@RequestParam(value="id") Integer id,Model model) {
        model.addAttribute("release", releaseService.getRelease(id));
        return "release";
    }


}
