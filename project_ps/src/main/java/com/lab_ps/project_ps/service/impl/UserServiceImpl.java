package com.lab_ps.project_ps.service.impl;

import com.lab_ps.project_ps.exceptions.UserNotFoundException;
import com.lab_ps.project_ps.model.User;
import com.lab_ps.project_ps.repository.UserRepository;
import com.lab_ps.project_ps.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User addUser(User user) {
        // the incoming user should not have an id
        return repository.save(user);
    }

    @Override
    public List<User> saveUserList(List<User> list) {

//        for(User user : list){
//            if(repository.existsById(user.getId()) && user.getId() != null){
//                updateUser(user);
//            } else if(user.getId() != null){
//                addUser(user);
//            }
//        }

        return (List<User>)repository.saveAll(list);
    }

    @Override
    public List<User> findAllUsers() {
        return repository.findAll();
    }

    @Override
    public User updateUser(User user) {
        User persistedUser = repository.findUserById(user.getId()).get();
        if(user.getName() != null)
            persistedUser.setName(user.getName());
        if(user.getPhone() != null)
            persistedUser.setPhone(user.getPhone());
        if(user.getEmail() != null)
            persistedUser.setEmail(user.getEmail());
        if(user.getType() != null)
            persistedUser.setType(user.getType());
        if(user.getUsername() != null)
            persistedUser.setUsername(user.getUsername());
        if(user.getPassword() != null)
            persistedUser.setPassword(user.getPassword());

        return  repository.save(persistedUser);
    }

    @Override
    public User findUserByEmail(String email) {
        return repository.findUserByEmail(email).orElseThrow(() -> new UserNotFoundException("User with email " + email + " not found"));
    }

    @Override
    public User findUserById(Long id) {
        return repository.findUserById(id).orElseThrow(() -> new UserNotFoundException("User with id= " + id + " not found"));
    }

    @Override
    public void deleteUserById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public boolean login(User user) {
        return false;
    }

    @Override
    public boolean logout(User user) {
        return false;
    }
}
