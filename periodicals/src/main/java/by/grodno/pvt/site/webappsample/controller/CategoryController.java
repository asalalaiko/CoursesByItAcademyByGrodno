package by.grodno.pvt.site.webappsample.controller;

import by.grodno.pvt.site.webappsample.domain.Category;
import by.grodno.pvt.site.webappsample.dto.CategoryDTO;
import by.grodno.pvt.site.webappsample.repo.CategoryRepo;
import by.grodno.pvt.site.webappsample.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class CategoryController {

    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ConversionService conversionService;



    @GetMapping("/category")
    public String getAllCategories(Model model) {

        List<CategoryDTO> categories = categoryService.getCategories().stream().map(u -> conversionService.convert(u, CategoryDTO.class))
                .collect(Collectors.toList());

        model.addAttribute("category", categories);

        return "category";
    }

    @PostMapping("/category")
    public String addCategory(@RequestParam String name, Map<String, Object> model) {
        Category category = new Category(name);

        categoryRepo.save(category);

        return "redirect:/category";
    }

    @GetMapping("/category/delete")
    public String deleteCategory(@RequestParam(value="id") Integer id){
        categoryRepo.deleteById(id);
        return "redirect:/category";
    }


    @GetMapping("/category/edit")
    public String getCategory(@PathVariable(value="id") Integer id, Model model){
        List<CategoryDTO> category = categoryService.getCategory(id).stream().map(u -> conversionService.convert(u, CategoryDTO.class))
                .collect(Collectors.toList());

        model.addAttribute("category", category);
        return "redirect:/category/edit";
    }






//    @DeleteMapping("/category/delete")
//    public String deleteCategory(@RequestParam(value="id") Integer id) {
//        categoryRepo.deleteById(id);
//        return "redirect:/category";
//    }
}
