package ru.geekbrains.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.controllers.repr.ProductRepr;
import ru.geekbrains.persist.model.Brand;
import ru.geekbrains.persist.repo.BrandRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandServiceImpl implements BrandService{

    private BrandRepository brandRepository;

    @Autowired
    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public List<ProductRepr> getProductsByBrand(Long id) {
        return this.brandRepository.getOne(id).getProducts().stream().map(ProductRepr::new).collect(Collectors.toList());
    }

    @Override
    public List<Brand> getAllBrands() {
        return this.brandRepository.findAll();
    }
}
