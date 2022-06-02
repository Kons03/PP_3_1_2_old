package com.kata.security.service;

import com.kata.security.model.Role;
import java.util.*;

public interface RoleService {

    List<Role> findAllRole();
    void addDefaultRole();
    Set<Role> findByIdRoles(List<Long>roles);
}