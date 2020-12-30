package ru.geekbrains.controllers;

import liquibase.pro.packaged.S;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.geekbrains.controllers.represent.UserRepresent;
import ru.geekbrains.error.NotFoundException;
import ru.geekbrains.persist.repo.RoleRepository;
import ru.geekbrains.service.UserRepresentService;
import ru.geekbrains.service.UserRepresentServiceImpl;

import javax.validation.Valid;

@Controller
public class UserController {

    private final RoleRepository roleRepository;
    private final UserRepresentService userRepresentService;

    @Autowired
    public UserController(RoleRepository roleRepository, UserRepresentService userRepresentService) {
        this.roleRepository = roleRepository;
        this.userRepresentService = userRepresentService;
    }

    @GetMapping("/login")
    public String loginPageGet(){
        return "login";
    }

    @GetMapping("/users")
    public String adminPageUsersPageGet(Model model){
        model.addAttribute("activePage", "Users");
        model.addAttribute("users", this.userRepresentService.findAll());
        return "users";
    }

    @GetMapping("/user/create")
    public String adminPageUserCreateGet(Model model){
        model.addAttribute("create", true);
        model.addAttribute("activePage", "Users");
        model.addAttribute("user", new UserRepresent());
        model.addAttribute("roles", this.roleRepository.findAll());
        return "user_form";
    }

    @GetMapping("/user/{id}/edit")
    public String adminPageUserEditGet(Model model, @PathVariable("id") Long id){
        model.addAttribute("edit", true);
        model.addAttribute("activePage", "Users");
        model.addAttribute("user", this.userRepresentService.findById(id).orElseThrow(NotFoundException::new));
        model.addAttribute("roles", this.roleRepository.findAll());
        return "user_form";
    }

    @PostMapping("/user")
    public String adminPageUserPost(@Valid UserRepresent userRepresent, Model model,
                                    BindingResult bindingResult){
        model.addAttribute("activePage", "Users");

        if (bindingResult.hasErrors()){
            return "user_form";
        }

        userRepresentService.save(userRepresent);
        return "redirect:/users";
    }

    @DeleteMapping("/user/{id}/edit")
    public String adminPageUserDelete(Model model, @PathVariable("id") Long id){
        this.userRepresentService.delete(id);
        return "redirect:/users";
    }

    @GetMapping("/roles")
    public String adminPageRolesPageGet(Model model){
        model.addAttribute("activePage", "Roles");
        return "index";
    }


}
