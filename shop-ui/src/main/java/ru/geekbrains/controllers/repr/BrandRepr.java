package ru.geekbrains.controllers.repr;

import ru.geekbrains.persist.model.Brand;
import ru.geekbrains.persist.model.Product;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

public class BrandRepr {

    private Long id;
    private String name;
    private List<ProductRepr> products;

    public BrandRepr() {
    }

    public BrandRepr(Long id, String name, List<ProductRepr> products) {
        this.id = id;
        this.name = name;
        this.products = products;
    }

    public BrandRepr(Brand brand){
        this.id = brand.getId();
        this.name = brand.getName();
        this.products = brand.getProducts().stream().map(ProductRepr::new).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ProductRepr> getProducts() {
        return products;
    }

    public void setProducts(List<ProductRepr> products) {
        this.products = products;
    }
}
