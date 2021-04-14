package com.lab_ps.project_ps;

import com.lab_ps.project_ps.model.User;
import com.lab_ps.project_ps.permissions.UserType;
import com.lab_ps.project_ps.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTests {
    private UserService service;

    @Test
    void testDelete(){

    }

    @Test
    void findUserByIdTest(){
        User u = new User();
        u.setId(1L);
        u.setAddress("Somesului 3");
        u.setEmail("catalin@gmail.com");
        u.setLoggedIn(false);
        u.setUsername("cata");
        u.setName("Catalin Marian");
        u.setPassword("cata_password");
        u.setPhone("0748123456");
        u.setType(UserType.NORMAL);

        User u2;
        u2 = service.findUserById(1L);
        System.out.println(u);
        System.out.println(u2);
        assertTrue(u.equals(u2));
    }

    @Test
    void updateUserTest(){
        User u = new User();
        u.setId(1L);
        u.setAddress("Somesului 3");
        u.setEmail("catalin@gmail.com");
        u.setLoggedIn(false);
        u.setUsername("cata");
        u.setName("Catalin Marian");
        u.setPassword("cata_password");
        u.setPhone("0748123456");
        u.setType(UserType.NORMAL);

        User u2;
        u2 = service.updateUser(u);
        System.out.println(u);
        System.out.println(u2);
        assertTrue(u.equals(u2));
    }

}
