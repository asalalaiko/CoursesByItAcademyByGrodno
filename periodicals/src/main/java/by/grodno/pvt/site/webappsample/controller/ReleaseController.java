package by.grodno.pvt.site.webappsample.controller;

import by.grodno.pvt.site.webappsample.domain.Release;
import by.grodno.pvt.site.webappsample.repo.ReleaseRepo;
import by.grodno.pvt.site.webappsample.service.ReleaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class ReleaseController  {

    @Autowired
    private ReleaseRepo releaseRepo;
    @Autowired
    private ReleaseService releaseService;


    @GetMapping("/release")
    public String getAllRelease(Model model){
        model.addAttribute("release",releaseRepo.findAll());
        return "release";
    }
    @PostMapping("/release")
    public String addRelease(@RequestParam String name, @RequestParam String description, Map<String, Object> model) {
        Release release = new Release(name, description);

        releaseRepo.save(release);

        return "redirect:/release";
    }

    @GetMapping("/release/delete")
    public String deleteRelease(@RequestParam(value="id") Integer id){

        releaseRepo.deleteById(id);
        return "redirect:/release";
    }


    @GetMapping("/release/edit")
    public String getRelease(@RequestParam(value="id") Integer id, Model model){
        Release release = releaseRepo.getOne(id);
        model.addAttribute("release", release);

        return "release";

    }

    @PostMapping("/release/edit")
    public String editRelease(@RequestParam (value="id") Integer id, @RequestParam String name, @RequestParam String description) {
        Release release = releaseRepo.getOne(id);
        release.setName(name);
        release.setDescription(description);
        releaseService.saveRelease(release);
        return "redirect:/release";
    }




}
