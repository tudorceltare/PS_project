package com.lab_ps.project_ps.model;


import com.lab_ps.project_ps.permissions.UserType;
import lombok.*;

import javax.persistence.*;


@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private UserType type;

    private String name;
    private String phone;
    private String email;
    private String username;
    private String password;
    private String address;
    private boolean loggedIn;

}
