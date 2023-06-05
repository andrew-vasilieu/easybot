package org.easybot.easybottesttask.service;

import org.easybot.easybottesttask.entity.Product;
import org.easybot.easybottesttask.entity.ProductType;

import java.util.List;

public interface ProductService {
    Product addProduct(Product product);
    Product updateProduct(Long id, Product product);
    Product getById(Long id);
    List<Product> getByProductType(ProductType productType);
}
