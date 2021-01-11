package by.grodno.pvt.site.webappsample.controller;

import by.grodno.pvt.site.webappsample.domain.Language;
import by.grodno.pvt.site.webappsample.repo.LanguageRepo;
import by.grodno.pvt.site.webappsample.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class LanguageController {
    @Autowired
    private LanguageRepo languageRepo;
    @Autowired
    private LanguageService languageService;
    @Autowired
    private ConversionService conversionService;

    @GetMapping("/language")
    public String getAllLanguage(Model model){
        model.addAttribute("language",languageRepo.findAll());
        return "language";
    }
    @PostMapping("/language")
    public String addLanguage(@RequestParam String name, Map<String, Object> model) {
        Language language = new Language(name);

        languageRepo.save(language);

        return "redirect:/language";
    }

    @GetMapping("/language/delete")
    public String deleteLanguage(@RequestParam(value="id") Integer id){

        languageRepo.deleteById(id);
        return "redirect:/language";
    }


    @GetMapping("/language/edit")
    public String getLanguage(@RequestParam(value="id") Integer id, Model model){
        Language language = languageRepo.getOne(id);
        model.addAttribute("language", language);

        return "language";

    }

    @PostMapping("/language/edit")
    public String editlanguagey(@RequestParam (value="id") Integer id, @RequestParam String name) {
        Language language = languageRepo.getOne(id);
        language.setName(name);
        languageService.saveLanguage(language);
        return "redirect:/language";
    }





}
