package by.grodno.pvt.site.webappsample.service.impl;

import by.grodno.pvt.site.webappsample.domain.Category;
import by.grodno.pvt.site.webappsample.repo.CategoryRepo;
import by.grodno.pvt.site.webappsample.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public  class JPACategoryService implements CategoryService {
    @Autowired
    private CategoryRepo repo;

    @Override
    public List<Category> getCategoryes() {
        return null;
    }

    @Override
    public Category getCategory(Integer id) {
        return null;
    }

    @Override
    public void addCategory(List<Category> categories) {
        repo.saveAll(categories);
    }

    @Override
    public void saveCategory(Category category) {

    }

    @Override
    public void deleteCategory(Integer number) {

    }

    @Override
    public List<Category> findByExample(Category categorySample) {
        return null;
    }

    @Override
    public Page<Category> getPage(Integer pageNum, Integer pageSize) {
        return null;
    }

    @Override
    public List<Category> findByFName(String fname) {
        return null;
    }
}
