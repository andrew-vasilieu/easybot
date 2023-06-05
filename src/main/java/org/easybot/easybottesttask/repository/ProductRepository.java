package org.easybot.easybottesttask.repository;

import org.easybot.easybottesttask.entity.Product;
import org.easybot.easybottesttask.entity.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByType(ProductType type);
}
