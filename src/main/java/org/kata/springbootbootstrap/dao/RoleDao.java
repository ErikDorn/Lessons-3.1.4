package org.kata.springbootbootstrap.dao;

import org.kata.springbootbootstrap.model.Role;

import java.util.List;

public interface RoleDao {

    List<Role> getAllRoles();

    Role getRole(String userRole);

    Role getRoleById(long id);

    void addRole(Role role);
}
