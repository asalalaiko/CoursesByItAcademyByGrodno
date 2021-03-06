package by.grodno.pvt.site.webappsample.controller.admin;

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
    private PublisherService publisherService;


    @GetMapping("/admin/publisher")
    public String getAllPublisher(Model model){
        model.addAttribute("publisher",publisherService.getPublishers());
        return "/admin/publisher";
    }
    @PostMapping("/admin/publisher")
    public String addPublisher(@RequestParam String name, @RequestParam String contact, Map<String, Object> model) {
        Publisher publisher = new Publisher(name, contact);
        publisherService.savePublisher(publisher);

        return "redirect:/admin/publisher";
    }

    @GetMapping("/admin/publisher/delete")
    public String deletePublisher(@RequestParam(value="id") Integer id){
        publisherService.deletePublisher(id);
        return "redirect:/admin/publisher";
    }


    @GetMapping("/admin/publisher/edit")
    public String getPublisher(@RequestParam(value="id") Integer id, Model model){

        model.addAttribute("publisher", publisherService.getPublisher(id));

        return "/admin/publisher";

    }

    @PostMapping("/admin/publisher/edit")
    public String editPublisher(@RequestParam (value="id") Integer id, @RequestParam String name, @RequestParam String contact) {

        Publisher publisher = publisherService.getPublisher(id);
        publisher.setName(name);
        publisher.setContact(contact);
        publisherService.savePublisher(publisher);
        return "redirect:/admin/publisher";
    }






}
