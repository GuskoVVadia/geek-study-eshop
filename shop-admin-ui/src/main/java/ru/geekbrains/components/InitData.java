package ru.geekbrains.components;

import ru.geekbrains.dao.RoleDao;
import ru.geekbrains.dao.UserDao;
import ru.geekbrains.domain.Role;
import ru.geekbrains.domain.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


import java.util.Arrays;

@Component
public class InitData implements CommandLineRunner {

    private final RoleDao roleDao;
    private final UserDao userDao;

    public InitData(RoleDao roleDao, UserDao userDao){
        this.roleDao = roleDao;
        this.userDao = userDao;
    }

    @Override
    public void run(String... args) throws Exception {
        initData();
    }

    private void initData() throws Exception {

        System.err.println("start init");

        User admin = new User();
        admin.setName("admin");
        admin.setPassword("admin");
        admin.setFirstName("fon");
        admin.setSecondName("Adminoff");
        admin = userDao.save(admin);

        Role roleAdmin = new Role();
        roleAdmin.setName("admin");
        roleAdmin.setUsers(Arrays.asList(admin));
        roleAdmin = roleDao.save(roleAdmin);

        admin.setRoles(Arrays.asList(roleAdmin));
        admin = userDao.save(admin);

        System.err.println("end init");

    }
}
