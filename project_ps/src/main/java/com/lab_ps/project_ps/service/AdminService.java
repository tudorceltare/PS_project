package com.lab_ps.project_ps.service;

import com.lab_ps.project_ps.model.UserAuth;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AdminService {
    List<UserAuth> getAllUsers();
    UserAuth updateUserAuth(UserAuth dto);
}
