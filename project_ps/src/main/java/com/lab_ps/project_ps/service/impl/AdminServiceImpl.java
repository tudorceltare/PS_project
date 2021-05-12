package com.lab_ps.project_ps.service.impl;

import com.lab_ps.project_ps.model.UserAuth;
import com.lab_ps.project_ps.repository.UserAuthRepository;
import com.lab_ps.project_ps.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    UserAuthRepository repository;

    @Override
    public List<UserAuth> getAllUsers() {
        return (List<UserAuth>) repository.findAll();
    }

    @Override
    public UserAuth updateUserAuth(UserAuth dto) {
        UserAuth persistedUser = repository.findById(dto.getId()).get();
        repository.save(persistedUser);
        return persistedUser;
    }
}
