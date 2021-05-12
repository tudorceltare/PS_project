package com.lab_ps.project_ps.service.impl;

import com.lab_ps.project_ps.dto.CreationSuccessDTO;
import com.lab_ps.project_ps.dto.RegisterDTO;
import com.lab_ps.project_ps.exceptions.ApiExceptionResponse;
import com.lab_ps.project_ps.model.Address;
import com.lab_ps.project_ps.model.Contact;
import com.lab_ps.project_ps.model.UserAuth;
import com.lab_ps.project_ps.permissions.UserType;
import com.lab_ps.project_ps.repository.UserAuthRepository;
import com.lab_ps.project_ps.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private UserAuthRepository repository;
    @Override
    public CreationSuccessDTO register(RegisterDTO dto) throws ApiExceptionResponse {
        System.out.println(dto.toString());
        UserAuth user = repository.findByUsername(dto.getUsername());

        if(user != null){
            throw ApiExceptionResponse.builder().errors(Collections.singletonList("Bad credentials")).message("User exists")
                    .status(HttpStatus.NOT_FOUND).build();
        }
        user = new UserAuth();
        user.setName(dto.getName());
        user.setType(UserType.NORMAL);
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        Address address = Address.builder().city(dto.getCity()).number(dto.getNumber()).street(dto.getStreet()).build();
        System.out.println("Address is : " + address.toString());
        user.setAddress(address);
        Contact contact = Contact.builder().phoneNumber(dto.getPhoneNumber()).email(dto.getEmail()).build();
        System.out.println("Contact is : " + contact.toString());
        user.setContact(contact);
        repository.save(user);
        System.out.println(user.toString());
        return CreationSuccessDTO.builder().id(repository.findByUsername(dto.getUsername()).getId()).build();
    }
}
