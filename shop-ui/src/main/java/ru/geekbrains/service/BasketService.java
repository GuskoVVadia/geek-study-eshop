package ru.geekbrains.service;

import ru.geekbrains.controllers.repr.ProductRepr;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public interface BasketService extends Serializable {
    void addProduct(Long id);
    void removeProduct(Long id);
    BigDecimal getTotal();
    List<ProductRepr> getProductsUser();
}
