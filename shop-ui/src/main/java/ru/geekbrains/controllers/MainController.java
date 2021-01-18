/**
 * sidebar:
 * /brands +
 * /categories +
 * /shop
 *
 * add:
 * /basket
 * /account
 * /products
 *
 * template:
 * /product/${prod.id}
 */

package ru.geekbrains.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.geekbrains.service.*;

@Controller
public class MainController {

    private final BrandService brandService;
    private final CategoryService categoryService;
    private final ProductService productService;
    private final BasketService basketService;

    @Autowired
    public MainController(BrandService brandService, CategoryService categoryService, ProductService productService, BasketService basketService) {
        this.brandService = brandService;
        this.categoryService = categoryService;
        this.productService = productService;
        this.basketService = basketService;
    }

    @GetMapping("/brands")
    public String brandListShopPageGet(Model model){
        model.addAttribute("listBrands", this.brandService.getAllBrands());
        return "brands";
    }

    @GetMapping("/brands/{id}/add")
    public String brandListShopPagePost(Model model, @PathVariable("id") Long id){
        this.basketService.addProduct(id);
        return "redirect:/brands";
    }

    @GetMapping("/categories")
    public String categoryListShopPageGet(Model model){
        model.addAttribute("listCategories", this.categoryService.getAllCategory());
        return "categories";
    }

    @GetMapping("/categories/{id}/add")
    public String categoryListShopPagePost(Model model, @PathVariable("id") Long id){
        this.basketService.addProduct(id);
        return "redirect:/categories";
    }

    @GetMapping("/product/{id}/edit")
    public String productAboutIdShopPageGet(Model model, @PathVariable("id")Long id){
        System.err.println("id = " + id);
        model.addAttribute("product", this.productService.getProductById(id));
        return "product";
    }

}
