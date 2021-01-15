package by.grodno.pvt.site.webappsample.controller;

import by.grodno.pvt.site.webappsample.domain.Product;
import by.grodno.pvt.site.webappsample.repo.ProductRepo;
import by.grodno.pvt.site.webappsample.repo.PublisherRepo;
import by.grodno.pvt.site.webappsample.service.ProductService;
import by.grodno.pvt.site.webappsample.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Controller
public class ProductController {

    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private ProductService productService;
    @Autowired
    private PublisherRepo publisherRepo;
    @Autowired
    private PublisherService publisherService;


    @GetMapping("/product")
    public String getAllProduct(Model model){
        model.addAttribute("product", productRepo.findAll());
        model.addAttribute("publisher", publisherRepo.findAll());
        return "product";
    }


    @PostMapping("/product")
    public String addProduct(@RequestParam String name, @RequestParam String isin, @RequestParam String date_first_available, Model publisher) throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-mm-dd");

        Product product = new Product(name, isin, df.parse(date_first_available));
        productService.saveProduct(product);


        return "redirect:/product";

    }


}
