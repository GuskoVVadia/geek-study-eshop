package ru.geekbrains.controllers.repr;

import ru.geekbrains.persist.model.Category;
import ru.geekbrains.persist.model.Product;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public class CategoryRepr implements Serializable {

    private long id;

    private String name;

    private List<ProductRepr> listProducts;

    public CategoryRepr() {
    }

    public CategoryRepr(long id, String name, List<ProductRepr> listProducts) {
        this.id = id;
        this.name = name;
        this.listProducts = listProducts;
    }

    public CategoryRepr(Category category) {
        this.id = category.getId();
        this.name = category.getName();
        this.listProducts = category.getProducts().stream().map(ProductRepr::new).collect(Collectors.toList());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ProductRepr> getListProducts() {
        return listProducts;
    }

    public void setListProducts(List<ProductRepr> listProducts) {
        this.listProducts = listProducts;
    }
}
