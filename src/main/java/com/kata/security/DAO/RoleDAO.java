package com.kata.security.DAO;

import com.kata.security.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface RoleDAO extends JpaRepository<Role, Long> {
}