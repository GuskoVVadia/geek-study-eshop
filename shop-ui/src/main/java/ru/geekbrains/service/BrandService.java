package ru.geekbrains.service;

import ru.geekbrains.controllers.repr.ProductRepr;
import ru.geekbrains.persist.model.Brand;

import java.util.List;

public interface BrandService {
    List<ProductRepr> getProductsByBrand(Long id);
    List<Brand> getAllBrands();
}
