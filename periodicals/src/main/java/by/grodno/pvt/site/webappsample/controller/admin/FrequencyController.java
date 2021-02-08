package by.grodno.pvt.site.webappsample.controller.admin;


import by.grodno.pvt.site.webappsample.domain.Frequency;
import by.grodno.pvt.site.webappsample.repo.FrequencyRepo;
import by.grodno.pvt.site.webappsample.service.FrequencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class FrequencyController {

    @Autowired
    private FrequencyService frequencyService;
    @Autowired
    private ConversionService conversionService;

    @GetMapping("/admin/frequency")
    public String getAllFrequency(Model model){
        model.addAttribute("frequency", frequencyService.getFrequencies());
        return "/admin/frequency";
    }
    @PostMapping("/admin/frequency")
    public String addFrequency(@RequestParam String name, Map<String, Object> model) {
        Frequency frequency = new Frequency(name);
        frequencyService.saveFrequency(frequency);

        return "redirect:/admin/frequency";
    }

    @GetMapping("/admin/frequency/delete")
    public String deleteFrequency(@RequestParam(value="id") Integer id){
        frequencyService.deleteFrequency(id);
        return "redirect:/admin/frequency";
    }


    @GetMapping("/admin/frequency/edit")
    public String getFrequency(@RequestParam(value="id") Integer id, Model model){
        Frequency frequency = frequencyService.getFrequency(id);
        model.addAttribute("frequency", frequency);

        return "/admin/frequency";

    }

    @PostMapping("/admin/frequency/edit")
    public String editFrequencyy(@RequestParam (value="id") Integer id, @RequestParam String name) {
        Frequency frequency = frequencyService.getFrequency(id);
        frequency.setName(name);
        frequencyService.saveFrequency(frequency);
        return "redirect:/admin/frequency";
    }


}
