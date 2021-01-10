package by.grodno.pvt.site.webappsample.controller;

import by.grodno.pvt.site.webappsample.domain.Publisher;
import by.grodno.pvt.site.webappsample.repo.PublisherRepo;
import by.grodno.pvt.site.webappsample.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class PublisherController {

    @Autowired
    private PublisherRepo publisherRepo;
    @Autowired
    private PublisherService publisherService;


    @GetMapping("/publisher")
    public String getAllPublisher(Model model){
        model.addAttribute("publisher",publisherRepo.findAll());
        return "publisher";
    }
    @PostMapping("/publisher")
    public String addPublisher(@RequestParam String name, @RequestParam String contact, Map<String, Object> model) {
        Publisher publisher = new Publisher(name, contact);

        publisherRepo.save(publisher);

        return "redirect:/publisher";
    }

    @GetMapping("/publisher/delete")
    public String deletePublisher(@RequestParam(value="id") Integer id){

        publisherRepo.deleteById(id);
        return "redirect:/publisher";
    }


    @GetMapping("/publisher/edit")
    public String getPublisher(@RequestParam(value="id") Integer id, Model model){
        Publisher publisher = publisherRepo.getOne(id);
        model.addAttribute("publisher", publisher);

        return "publisher";

    }

    @PostMapping("/publisher/edit")
    public String editPublisher(@RequestParam (value="id") Integer id, @RequestParam String name) {
        Publisher publisher = publisherRepo.getOne(id);
        publisher.setName(name);
        publisherService.savePublisher(publisher);
        return "redirect:/publisher";
    }






}
