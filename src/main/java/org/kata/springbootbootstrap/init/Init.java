package org.kata.springbootbootstrap.init;

import org.kata.springbootbootstrap.model.Role;
import org.kata.springbootbootstrap.model.User;
import org.kata.springbootbootstrap.service.RoleService;
import org.kata.springbootbootstrap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class Init {
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public Init(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }


    @PostConstruct
    private void dataBaseInit() {
        Role roleAdmin = new Role("ADMIN");
        Role roleUser = new Role("USER");
        Set<Role> adminSet = new HashSet<>();
        Set<Role> userSet = new HashSet<>();

        roleService.addRole(roleAdmin);
        roleService.addRole(roleUser);

        adminSet.add(roleAdmin);
        adminSet.add(roleUser);
        userSet.add(roleUser);


        User admin = new User("Admin", "Adminov", 27, "admin@mail.ru", "admin",
                "admin", adminSet);
        User newUser = new User("User", "Userov", 23, "user@mail.ru", "user",
                "user", userSet);


        userService.saveUser(newUser);
        userService.saveUser(admin);
    }
}
