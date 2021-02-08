package by.grodno.pvt.site.webappsample.controller.admin;

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
    private LanguageService languageService;
    @Autowired
    private ConversionService conversionService;

    @GetMapping("/admin/language")
    public String getAllLanguage(Model model){
        model.addAttribute("language", languageService.getLanguages());
        return "/admin/language";
    }
    @PostMapping("/admin/language")
    public String addLanguage(@RequestParam String name, Map<String, Object> model) {
        Language language = new Language(name);
        languageService.saveLanguage(language);

        return "redirect:/admin/language";
    }

    @GetMapping("/admin/language/delete")
    public String deleteLanguage(@RequestParam(value="id") Integer id){
        languageService.deleteLanguage(id);
        return "redirect:/admin/language";
    }


    @GetMapping("/admin/language/edit")
    public String getLanguage(@RequestParam(value="id") Integer id, Model model){
        Language language = languageService.getLanguage(id);
        model.addAttribute("language", language);

        return "/admin/language";

    }

    @PostMapping("/admin/language/edit")
    public String editLanguagey(@RequestParam (value="id") Integer id, @RequestParam String name) {
        Language language = languageService.getLanguage(id);
        language.setName(name);
        languageService.saveLanguage(language);
        return "redirect:/admin/language";
    }





}
