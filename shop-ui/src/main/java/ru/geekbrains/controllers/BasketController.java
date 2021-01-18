package ru.geekbrains.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.geekbrains.service.BasketService;
import ru.geekbrains.service.BasketServiceImpl;

@Controller
public class BasketController {

    private final BasketServiceImpl basketService;

    @Autowired
    public BasketController(BasketServiceImpl basketService) {
        this.basketService = basketService;
    }

    @RequestMapping("/basket")
    public String basketUserPageGet(Model model){
        model.addAttribute("basket", this.basketService.getProductsUser());
        return "basket";
    }

    @RequestMapping(value = "/basket/{prodId}/delete", method = RequestMethod.DELETE)
    public String basketProductDelete(Model model, @PathVariable("prodId") Long id){
        this.basketService.removeProduct(id);
        return "redirect:/basket";
    }


}
