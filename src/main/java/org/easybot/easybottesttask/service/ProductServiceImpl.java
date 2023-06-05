package org.easybot.easybottesttask.service;

import lombok.RequiredArgsConstructor;
import org.easybot.easybottesttask.entity.Product;
import org.easybot.easybottesttask.entity.ProductType;
import org.easybot.easybottesttask.exceptions.ObjectNotFoundException;
import org.easybot.easybottesttask.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;
    @Override
    public Product addProduct(Product product) {
        return repository.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        repository.findById(id).orElseThrow(
                () -> new ObjectNotFoundException(String.format(
                "Product with Id %s not found.", id)
        ));
        product.setId(id);
        return repository.save(product);
    }

    @Override
    public Product getById(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new ObjectNotFoundException(String.format(
                        "Product with Id %s not found.", id)
                ));
    }

    @Override
    public List<Product> getByProductType(ProductType productType) {
        return repository.findByType(productType);
    }
}
