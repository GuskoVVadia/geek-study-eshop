package ru.geekbrains.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.geekbrains.domain.User;

@Service
public class UserDetailServiceImp implements UserDetailsService {

    private final UserServiceImp userServiceImp;
    private final RoleServiceImp roleServiceImp;

    public UserDetailServiceImp(UserServiceImp userServiceImp, RoleServiceImp roleServiceImp) {
        this.userServiceImp = userServiceImp;
        this.roleServiceImp = roleServiceImp;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = this.userServiceImp.findByName(s);
        if (user == null){
            throw new UsernameNotFoundException("invalid");
        }

        return new org.springframework.security.core.userdetails.User
                        (user.getUsername(), user.getPassword(), user.getRoles());
    }
}
