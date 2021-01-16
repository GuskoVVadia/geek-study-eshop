package ru.geekbrains.service;

import ru.geekbrains.controllers.repr.ProductRepr;

import java.io.Serializable;

public interface ProductService extends Serializable {
    ProductRepr getProductById(Long id);
}
