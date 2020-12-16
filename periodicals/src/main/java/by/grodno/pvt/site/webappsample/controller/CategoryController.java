package by.grodno.pvt.site.webappsample.controller;

import by.grodno.pvt.site.webappsample.dto.CategoryDTO;
import by.grodno.pvt.site.webappsample.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ConversionService conversionService;


    @GetMapping("/categoryes")
    public String getCategoryes(Model model) {

        List<CategoryDTO> categoryes = categoryService.getCategoryes().stream().map(u -> conversionService.convert(u,CategoryDTO.class))
                .collect(Collectors.toList());

        model.addAttribute("categoryes", categoryes);

        return "categoryes";
    }

}
