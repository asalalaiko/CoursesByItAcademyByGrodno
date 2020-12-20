package by.grodno.pvt.site.webappsample.controller;

import by.grodno.pvt.site.webappsample.domain.Category;
import by.grodno.pvt.site.webappsample.repo.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class AdminCategoryController {

    @Autowired
    private CategoryRepo categoryRepo;


    @GetMapping("/admin/category")
    public String main(Map<String, Object> model) {
        Iterable<Category> categories = categoryRepo.findAll();

        model.put("category", categories);
        return "category";
    }

    @PostMapping
    public String add(@RequestParam String name, Map<String, Object> model) {
        Category category = new Category(name);

        categoryRepo.save(category);


        Iterable<Category> categories = categoryRepo.findAll();

        model.put("category", categories);

        return "category";
    }
}
