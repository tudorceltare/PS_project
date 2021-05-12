package com.lab_ps.project_ps.service;

import com.lab_ps.project_ps.dto.CredentialsDTO;
import com.lab_ps.project_ps.dto.LoginSuccessDTO;
import com.lab_ps.project_ps.exceptions.ApiExceptionResponse;
import org.springframework.stereotype.Component;

@Component
public interface LoginService {
    LoginSuccessDTO login(CredentialsDTO dto) throws ApiExceptionResponse;
}
