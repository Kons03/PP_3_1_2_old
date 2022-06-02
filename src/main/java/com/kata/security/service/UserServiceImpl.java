package com.kata.security.service;

import com.kata.security.DAO.RoleDAO;
import com.kata.security.DAO.UserDAO;
import com.kata.security.model.Role;
import com.kata.security.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;
    private final RoleDAO roleDAO;
    private final PasswordEncoder passwordEncoder;

//    @Autowired
    public UserServiceImpl(UserDAO userDAO, RoleDAO roleDAO, PasswordEncoder passwordEncoder) {
        this.userDAO = userDAO;
        this.roleDAO = roleDAO;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User passwordCoder(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return user;
    }

    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Override
    public User getById(long id) {
        return userDAO.getById(id);
    }

    @Override
    public void save(User user) {
        userDAO.save(passwordCoder(user));
    }

    @Override
    public void deleteById(long id) {
        userDAO.deleteById(id);
    }

    @Override
    public User findByUsername(String username) {
        return userDAO.findByUsername(username);
    }

    @Override
    @PostConstruct
    public void addDefaultUser() {
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(roleDAO.findById(1L).get());

        Set<Role> roleSet2 = new HashSet<>();
        roleSet2.add(roleDAO.findById(1L).get());
        roleSet2.add(roleDAO.findById(2L).get());

        User user1 = new User("Sergey", "Nemchinkyi", 50000, "serega@foxminded.ua", (byte) 45, "serega_fox", "serega123", roleSet2);
        User user2 = new User("Sid", "Vicious", 18000,  "sid_h@sexpistols.com", (byte) 20, "sid_h", "sid123", roleSet);
        User user3 = new User("Donald", "Trump", 88000, "don_trump@maga.com", (byte) 50, "don_t", "don123", roleSet);

        save(user1);
        save(user2);
        save(user3);
    }
}