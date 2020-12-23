package ru.geekbrains.services;

import ru.geekbrains.dao.UserDao;
import ru.geekbrains.domain.Role;
import ru.geekbrains.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User getById(Long id) {
        return userDao.findById(id).orElse(null);
    }

    @Override
    public List<Role> getRoles(User user) {
        return userDao.getOne(user.getId()).getRoles();
    }

    @Override
    public User save(User user){

         return userDao.save(user);
    }

    @Override
    public User findByName(String name) {
        return userDao.findUserByName(name);
    }

    @Override
    public User update(User firstUser, User secondUser) {
        return null;
    }
}
