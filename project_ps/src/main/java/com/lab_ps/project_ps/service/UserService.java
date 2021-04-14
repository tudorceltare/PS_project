package com.lab_ps.project_ps.service;

import com.lab_ps.project_ps.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserService {
    User addUser(User user);
    List<User> saveUserList(List<User> list);
    List<User> findAllUsers();
    User updateUser(User user);
    User findUserByEmail(String email);
    User findUserById(Long id);
    void deleteUserById(Long id);
    boolean login(User user);
    boolean logout(User user);

}
