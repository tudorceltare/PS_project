package com.lab_ps.project_ps.controller;

import com.lab_ps.project_ps.model.User;
import com.lab_ps.project_ps.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/user")
public class UserController {
    @Qualifier("userServiceImpl")
    @Autowired
    private UserService service;

    @GetMapping("/all")
    public ResponseEntity<List<User>> findAllUsers(){
        List<User> users = service.findAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<User> findUserById(@PathVariable("id") Long id){
        User user = service.findUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user){
        User newUser = service.addUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @PutMapping("/save-list")
    public ResponseEntity<List<User>> addUser(@RequestBody List<User> list){
        List<User> newList = service.saveUserList(list);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        User updatedUser = service.updateUser(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id){
        service.deleteUserById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
