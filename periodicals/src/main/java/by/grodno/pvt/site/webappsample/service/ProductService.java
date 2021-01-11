package by.grodno.pvt.site.webappsample.service;


import by.grodno.pvt.site.webappsample.domain.Product;
import org.springframework.stereotype.Service;

import java.util.List;


public interface   ProductService {


    List<Product> getProducts();

    Product getProduct(Integer id);

    void addProduct(List<Product> products);

    void saveProduct(Product product);

    void deleteProduct(Integer id);

    List<Product> findByName(String name);
}
