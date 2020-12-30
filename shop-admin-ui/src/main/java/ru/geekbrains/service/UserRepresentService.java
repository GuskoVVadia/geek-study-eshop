package ru.geekbrains.service;

import ru.geekbrains.controllers.represent.UserRepresent;

import java.util.List;
import java.util.Optional;

public interface UserRepresentService {
    void save(UserRepresent userRepresent);
    List<UserRepresent> findAll();
    Optional<UserRepresent> findById(Long id);
    void delete(Long id);
}
