package by.grodno.pvt.site.webappsample.service.impl;

import by.grodno.pvt.site.webappsample.domain.Category;
import by.grodno.pvt.site.webappsample.repo.CategoryRepo;
import by.grodno.pvt.site.webappsample.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public  class JPACategoryService implements CategoryService {
    @Autowired
    private CategoryRepo repo;

    @Override
    public List<Category> getCategories() {
        return repo.findAll();
    }

    @Override
    public Category getCategory(Integer id) {
        return repo.getOne(id);
    }

    @Override
    public void addCategory(List<Category> category) {
        repo.saveAll(category);
    }

    @Override
    public void saveCategory(Category category) {
        repo.save(category);
    }

    @Override
    public void deleteCategory(Integer id) { repo.deleteById(id);    }

    @Override
    public List<Category> findByName(String name) {
        return null;
    }


}
