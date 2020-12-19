package by.grodno.pvt.site.webappsample.service;

import by.grodno.pvt.site.webappsample.domain.Category;

import java.util.List;

public interface CategoryService {


    List<Category> getCategories();

    Category getCategory(Integer id);

    void addCategory(List<Category> categories);

    void saveCategory(Category category);

    void deleteCategory(Integer number);

    List<Category> findByName(String name);

}
