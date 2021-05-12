package com.lab_ps.project_ps.service;

import com.lab_ps.project_ps.dto.CreationSuccessDTO;
import com.lab_ps.project_ps.dto.RegisterDTO;
import com.lab_ps.project_ps.exceptions.ApiExceptionResponse;
import org.springframework.stereotype.Component;

@Component
public interface RegisterService {
    CreationSuccessDTO register(RegisterDTO dto) throws ApiExceptionResponse;
}
