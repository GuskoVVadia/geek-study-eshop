package ru.geekbrains.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    private final UserServiceImp userServiceImp;
    private final RoleServiceImp roleServiceImp;

    public IndexController(UserServiceImp userServiceImp, RoleServiceImp roleServiceImp) {
        this.userServiceImp = userServiceImp;
        this.roleServiceImp = roleServiceImp;
    }

//    @Secured({"admin"})
    @RequestMapping({"/", ""})
    public String indexPage(Model model){
        return "index";
    }

}
