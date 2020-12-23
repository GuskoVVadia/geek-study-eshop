package ru.geekbrains.services;

import ru.geekbrains.domain.Role;
import ru.geekbrains.domain.User;

import java.util.List;

public interface UserService {
    User getById(Long id);
    List<Role> getRoles(User user);
    User save(User user);
    User findByName(String name);
    User update(User firstUser, User secondUser);
}
