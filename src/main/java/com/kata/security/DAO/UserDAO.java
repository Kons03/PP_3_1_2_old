package com.kata.security.DAO;

import com.kata.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface UserDAO extends JpaRepository<User,Long> {
    @Query("SELECT u FROM User u JOIN FETCH u.roles WHERE u.username = :username")
    User findByUsername(@Param("username")String username);
}