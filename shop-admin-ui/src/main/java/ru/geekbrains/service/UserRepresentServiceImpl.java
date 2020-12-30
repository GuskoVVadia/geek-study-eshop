package ru.geekbrains.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.geekbrains.persist.model.User;
import ru.geekbrains.persist.repo.UserRepository;
import ru.geekbrains.controllers.represent.UserRepresent;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserRepresentServiceImpl implements UserRepresentService{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserRepresentServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void save(UserRepresent userRepresent) {
        User user = new User();
        user.setId(userRepresent.getId());
        user.setName(userRepresent.getName());
        user.setPassword(passwordEncoder.encode(userRepresent.getPassword()));
        user.setEmail(userRepresent.getEmail());
        user.setFirstName(userRepresent.getFirstName());
        user.setLastName(userRepresent.getLastName());
        user.setRoles(userRepresent.getRoles());
        this.userRepository.save(user);
    }

    @Override
    public List<UserRepresent> findAll() {
        return this.userRepository.findAll().stream().map(UserRepresent::new).collect(Collectors.toList());
    }

    @Override
    public Optional<UserRepresent> findById(Long id) {
        return this.userRepository.findById(id).map(UserRepresent::new);
    }

    @Override
    public void delete(Long id) {
        this.userRepository.deleteById(id);
    }
}
