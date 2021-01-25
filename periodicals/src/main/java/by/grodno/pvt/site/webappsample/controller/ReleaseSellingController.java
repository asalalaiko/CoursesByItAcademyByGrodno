package by.grodno.pvt.site.webappsample.controller;


import by.grodno.pvt.site.webappsample.domain.Release;
import by.grodno.pvt.site.webappsample.repo.ReleaseRepo;
import by.grodno.pvt.site.webappsample.service.ReleaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ReleaseSellingController {

    @Autowired
    private ReleaseService releaseService;
    @Autowired
    private ConversionService convertionService;


    private List<Release> getSoldReleases(HttpSession session) {
        return (List<Release>) session.getAttribute("selectRelease");
    }


    @GetMapping("/release/buy")
    public String editUserForm(@RequestParam(value="id") Integer id, HttpSession session) {

        List<Release> attribute = getSoldReleases(session);

        if (attribute == null) {
            session.setAttribute("selectRelease", new ArrayList<Release>());
        }
        getSoldReleases(session).add(convertionService.convert(releaseService.getRelease(id).getId(), Release.class));


        return "redirect:?id="+id;
    }

    @GetMapping("/sold")
    public String sold(Model model, HttpSession session) {

        List<Release> attribute = getSoldReleases(session);

        if (attribute == null) {
            session.setAttribute("selectRelease", new ArrayList<Release>());
        }

        model.addAttribute("release", getSoldReleases(session));

        return "getSoldReleases";
    }

    @GetMapping("/sold/delete")
    public String soldDelAll(Model model, HttpSession session){
        getSoldReleases(session).clear();
        return "getSoldReleases";
    }

    @GetMapping ("/sold/delete/{num}")
    public String soldDelOne(@PathVariable Integer num, Model model, HttpSession session){


        getSoldReleases(session).remove(convertionService.convert(releaseService.getRelease(num).getId(), Release.class));

        return "redirect:/sold";
    }

    @GetMapping("/sold/apply")
    public String soldApply(Model model, HttpSession session){


    return "apply";
    }
}
