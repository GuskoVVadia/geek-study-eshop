/**
 *
 */
// FIXME: 16.01.2021

package ru.geekbrains.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import ru.geekbrains.controllers.repr.ProductRepr;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@Scope(scopeName = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class BasketServiceImpl implements BasketService{

    private static final long serialVersionUID = -7574801610677095945L;
    private static final Logger logger = LoggerFactory.getLogger(BasketServiceImpl.class);

    private final List<ProductRepr> basket;
    private final ProductService productService;

    @Autowired
    public BasketServiceImpl(ProductService productService){
        this.productService = productService;
        this.basket = new ArrayList<>();
    }

    @PostConstruct
    void post(){
        logger.info("construct session Bean. serial::{}", serialVersionUID);
    }

//   TODO на случай включения авторизации - можно сохранять корзину авторизованного пользователя
    @PreDestroy
    void pre(){
        logger.info("destruct bean");
    }

    @Override
    public void addProduct(Long id) {
        this.basket.add(this.productService.getProductById(id));
    }

    @Override
    public void removeProduct(Long id) {
        this.basket.remove(this.productService.getProductById(id));
    }

    @Override
    public BigDecimal getTotal() {

        BigDecimal decimal = new BigDecimal(0);
        for (ProductRepr repr: basket){
            decimal = decimal.add(repr.getPrice());
        }
        return decimal;
    }

    @Override
    public List<ProductRepr> getProductsUser() {
        return this.basket;
    }
}
