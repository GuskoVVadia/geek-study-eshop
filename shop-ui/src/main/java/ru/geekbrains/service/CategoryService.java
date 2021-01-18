package ru.geekbrains.service;

import ru.geekbrains.controllers.repr.ProductRepr;
import ru.geekbrains.persist.model.Category;

import java.util.List;

public interface CategoryService {
    List<ProductRepr> getProductsByCategory(Long id);
    List<Category> getAllCategory();
}
