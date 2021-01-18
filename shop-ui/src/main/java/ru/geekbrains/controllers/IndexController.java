package ru.geekbrains.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping(value = {" ", "index"})
    public String startPageIndexGet(Model model){
        model.addAttribute("activePage", "none");
        return "index";
    }
}
