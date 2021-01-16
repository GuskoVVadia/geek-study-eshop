package ru.geekbrains.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.controllers.repr.ProductRepr;
import ru.geekbrains.persist.repo.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductRepr getProductById(Long id) {
        return new ProductRepr(this.productRepository.getOne(id));
    }
}
