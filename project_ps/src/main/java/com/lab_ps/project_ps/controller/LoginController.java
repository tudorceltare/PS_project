package com.lab_ps.project_ps.controller;

import com.lab_ps.project_ps.dto.CredentialsDTO;
import com.lab_ps.project_ps.exceptions.ApiExceptionResponse;
import com.lab_ps.project_ps.service.LoginService;
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
public class LoginController {

    @Qualifier("loginServiceImpl")
    @Autowired
    private LoginService service;

    @PostMapping("/login")
    public ResponseEntity loginReq(@RequestBody CredentialsDTO dto) throws ApiExceptionResponse{
        return ResponseEntity.status(HttpStatus.OK).body(service.login(dto));
    }


}
