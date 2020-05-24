package com.hack.plates.service;

import com.hack.plates.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
    User getById(Long id);
    User getByUsername(String username);
    User update(User user);
    void deleteById(Long id);
}
