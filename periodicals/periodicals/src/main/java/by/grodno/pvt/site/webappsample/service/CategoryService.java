package by.grodno.pvt.site.webappsample.service;

import by.grodno.pvt.site.webappsample.domain.Category;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CategoryService {

    List<Category> getCategoryes();

    Category getCategory(Integer id);

    void addCategory(List<Category> categories);

    void saveCategory(Category category);

    void deleteCategory(Integer number);

    List<Category> findByExample(Category categorySample);

    Page<Category> getPage(Integer pageNum, Integer pageSize);

    List<Category> findByFName(String fname);
}
