package com.lab_ps.project_ps.controller;

import com.lab_ps.project_ps.exceptions.ApiExceptionResponse;
import com.lab_ps.project_ps.model.UserAuth;
import com.lab_ps.project_ps.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class AdminController {
    @Qualifier("adminServiceImpl")
    @Autowired
    private AdminService service;

    @GetMapping("admin/users")
    public ResponseEntity<List<UserAuth>> getAllUsers(){
        return ResponseEntity.status(HttpStatus.OK).body(service.getAllUsers());
    }

    @PutMapping("admin/update/{id}")
    public ResponseEntity updateUser(@RequestBody UserAuth dto) throws ApiExceptionResponse{
        return ResponseEntity.status(HttpStatus.OK).body(service.updateUserAuth(dto));
    }
}
