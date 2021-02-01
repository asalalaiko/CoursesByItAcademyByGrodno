package by.grodno.pvt.site.webappsample.controller.admin;

import by.grodno.pvt.site.webappsample.domain.*;
import by.grodno.pvt.site.webappsample.repo.ProductRepo;
import by.grodno.pvt.site.webappsample.repo.PublisherRepo;
import by.grodno.pvt.site.webappsample.service.*;
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
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private FrequencyService frequencyService;
    @Autowired
    private LanguageService languageService;



    @GetMapping("/admin/product")
    public String getAllProduct(Model model){

        model.addAttribute("publisher", publisherService.getPublishers());
        model.addAttribute("product", productService.getProducts());
        model.addAttribute("category", categoryService.getCategories());
        model.addAttribute("frequency", frequencyService.getFrequencies());
        model.addAttribute("language", languageService.getLanguages());

        return "/admin/product";
    }


    @PostMapping("/admin/product")
    public String addProduct(@RequestParam String productName,
                             @RequestParam String isin,
                             @RequestParam String dateFirstAvailable,
                             Publisher publisher,
                             Category category,
                             Frequency frequency,
                             Language language) throws ParseException {

        DateFormat df = new SimpleDateFormat("yyyy-mm-dd");

       Product product = new Product(productName, isin, df.parse(dateFirstAvailable));
       product.setPublisher(publisher);
       product.setCategory(category);
       product.setFrequency(frequency);
       product.setLanguage(language);
       productService.saveProduct(product);
       return "redirect:/admin/product";

    }
    @GetMapping("/admin/product/delete")
    public String deleteProduct(@RequestParam(value="id") Integer id){

        productRepo.deleteById(id);

        return "redirect:/admin/product";
    }

    @GetMapping("/admin/product/edit")
    public String getProduct(@RequestParam(value="productId") Integer productId, Model model) {
        model.addAttribute("publisher", publisherService.getPublishers());
        model.addAttribute("product", productService.getProducts());
        model.addAttribute("category", categoryService.getCategories());
        model.addAttribute("frequency", frequencyService.getFrequencies());
        model.addAttribute("language", languageService.getLanguages());

        Product product = productRepo.getOne(productId);
        model.addAttribute("product", product);

        return "/admin/product";
    }

    @PostMapping("/admin/product/edit")
    public String editProduct(@RequestParam(value="productId") Integer productId,
                              @RequestParam String productName,
                              @RequestParam String isin,
                              @RequestParam String dateFirstAvailable,
                              Publisher publisher,
                              Category category,
                              Frequency frequency,
                              Language language) throws ParseException {

        Product product = productRepo.getOne(productId);
        product.setName(productName);
        product.setIsin(isin);

        DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
        product.setDateFirstAvailable(df.parse(dateFirstAvailable));


        product.setPublisher(publisher);
        product.setCategory(category);
        product.setFrequency(frequency);
        product.setLanguage(language);

        productService.saveProduct(product);
        return "redirect:/admin/product";

    }


}
