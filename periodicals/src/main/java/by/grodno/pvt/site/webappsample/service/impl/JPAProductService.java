package by.grodno.pvt.site.webappsample.service.impl;


import by.grodno.pvt.site.webappsample.domain.Product;
import by.grodno.pvt.site.webappsample.repo.ProductRepo;
import by.grodno.pvt.site.webappsample.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class JPAProductService implements ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Override
    public List<Product> getProducts() {
        return productRepo.findAll();
    }

    @Override
    public Product getProduct(Integer id) {
        return productRepo.getOne(id);
    }

    @Override
    public void addProduct(List<Product> products) {
    productRepo.saveAll(products);
    }

    @Override
    public void saveProduct(Product product) {
    productRepo.save(product);
    }

    @Override
    public void deleteProduct(Integer id) {
    productRepo.deleteById(id);
    }

    @Override
    public List<Product> findByName(String name) {
        return null;
    }
}
