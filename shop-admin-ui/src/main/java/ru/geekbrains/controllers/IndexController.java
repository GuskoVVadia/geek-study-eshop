package ru.geekbrains.controllers;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.geekbrains.services.RoleServiceImp;
import ru.geekbrains.services.UserServiceImp;

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
