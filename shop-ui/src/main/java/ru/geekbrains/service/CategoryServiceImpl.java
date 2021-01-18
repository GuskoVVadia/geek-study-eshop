package ru.geekbrains.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.controllers.repr.ProductRepr;
import ru.geekbrains.persist.model.Category;
import ru.geekbrains.persist.repo.CategoryRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService{

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<ProductRepr> getProductsByCategory(Long id) {
        return this.categoryRepository.getOne(id).getProducts().stream().map(ProductRepr::new).collect(Collectors.toList());
    }

    @Override
    public List<Category> getAllCategory() {
        return this.categoryRepository.findAll();
    }
}
