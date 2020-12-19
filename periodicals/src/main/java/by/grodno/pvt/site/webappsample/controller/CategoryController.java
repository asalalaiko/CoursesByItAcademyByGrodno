package by.grodno.pvt.site.webappsample.controller;

import by.grodno.pvt.site.webappsample.domain.Category;
import by.grodno.pvt.site.webappsample.dto.CategoryDTO;
import by.grodno.pvt.site.webappsample.repo.CategoryRepo;
import by.grodno.pvt.site.webappsample.service.CategoryService;
import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

//
//    @GetMapping("/category")
//    public String main(Map<String, Object> model) {
//        Iterable<Category> categories = categoryRepo.findAll();
//
//        model.put("category", categories);
//        return "category";}
//}

    @GetMapping("/category")
    public String main(Model model) {

        List<CategoryDTO> categories = categoryService.getCategories().stream().map(u -> conversionService.convert(u, CategoryDTO.class))
                .collect(Collectors.toList());

        model.addAttribute("category", categories);

        return "category";
    }

}
