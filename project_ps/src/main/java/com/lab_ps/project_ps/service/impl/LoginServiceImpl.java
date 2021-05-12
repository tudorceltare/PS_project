package com.lab_ps.project_ps.service.impl;

import com.lab_ps.project_ps.dto.CredentialsDTO;
import com.lab_ps.project_ps.dto.LoginSuccessDTO;
import com.lab_ps.project_ps.exceptions.ApiExceptionResponse;
import com.lab_ps.project_ps.model.UserAuth;
import com.lab_ps.project_ps.permissions.UserType;
import com.lab_ps.project_ps.repository.UserAuthRepository;
import com.lab_ps.project_ps.service.LoginService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserAuthRepository repository;

    @Override
    public LoginSuccessDTO login(CredentialsDTO dto) throws ApiExceptionResponse{
        UserAuth user = repository.findByUsername(dto.getUsername());

        if(user == null){
            throw ApiExceptionResponse.builder().errors(Collections.singletonList("Bad credentials")).message("User not found")
                    .status(HttpStatus.NOT_FOUND).build();
        }

        LoginSuccessDTO response;
        UserType type=user.getType();
        if(type.equals(UserType.NORMAL)){
            response=LoginSuccessDTO.builder().id(user.getId()).type(type.toString()).build();
        }
        else{
            response=LoginSuccessDTO.builder().type(type.toString()).build();
        }

        if(dto.getPassword().equals(user.getPassword())){
            return response;
        }

        throw ApiExceptionResponse.builder().errors(Collections.singletonList("Bad credentials")).message("User not found")
                .status(HttpStatus.NOT_FOUND).build();
    }
}
