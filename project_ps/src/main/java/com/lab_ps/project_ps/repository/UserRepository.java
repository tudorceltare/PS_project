package com.lab_ps.project_ps.repository;

import com.lab_ps.project_ps.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findUserById(Long id);
    void deleteById(Long id);
    Optional<User> findUserByEmail(String email);

}
