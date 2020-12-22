package ru.geekbrains.services;

import ru.geekbrains.dao.RoleDao;
import ru.geekbrains.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImp {

    private RoleDao roleDao;

    @Autowired
    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    public Role save(Role role){
        return roleDao.save(role);
    }
}
