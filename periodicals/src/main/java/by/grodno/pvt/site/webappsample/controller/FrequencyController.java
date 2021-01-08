package by.grodno.pvt.site.webappsample.controller;


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
    private FrequencyRepo frequencyRepo;
    @Autowired
    private FrequencyService frequencyService;
    @Autowired
    private ConversionService conversionService;

    @GetMapping("/frequency")
    public String getAllFrequency(Model model){
        model.addAttribute("frequency",frequencyRepo.findAll());
        return "frequency";
    }
    @PostMapping("/frequency")
    public String addFrequency(@RequestParam String name, Map<String, Object> model) {
        Frequency frequency = new Frequency(name);

        frequencyRepo.save(frequency);

        return "redirect:/frequency";
    }

    @GetMapping("/frequency/delete")
    public String deleteFrequency(@RequestParam(value="id") Integer id){

        frequencyRepo.deleteById(id);
        return "redirect:/frequency";
    }


    @GetMapping("/frequency/edit")
    public String getFrequency(@RequestParam(value="id") Integer id, Model model){
        Frequency frequency = frequencyRepo.getOne(id);
        model.addAttribute("frequency", frequency);

        return "frequency";

    }

    @PostMapping("/frequency/edit")
    public String editFrequencyy(@RequestParam (value="id") Integer id, @RequestParam String name) {
        Frequency frequency = frequencyRepo.getOne(id);
        frequency.setName(name);
        frequencyService.saveFrequency(frequency);
        return "redirect:/frequency";
    }


}
