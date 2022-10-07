package org.kata.springbootbootstrap.service;



import org.kata.springbootbootstrap.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAllRoles();

    Role getRole(String userRole);

    Role getRoleById(long id);

    void addRole(Role role);
}
