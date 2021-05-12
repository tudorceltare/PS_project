package com.lab_ps.project_ps.controller;

import com.lab_ps.project_ps.dto.RegisterDTO;
import com.lab_ps.project_ps.exceptions.ApiExceptionResponse;
import com.lab_ps.project_ps.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class RegisterController {
    @Qualifier("registerServiceImpl")
    @Autowired
    private RegisterService service;

    @PostMapping("/register")
    public ResponseEntity registerReq(@RequestBody RegisterDTO dto) throws ApiExceptionResponse{
        return ResponseEntity.status(HttpStatus.OK).body(service.register(dto));
    }
}
