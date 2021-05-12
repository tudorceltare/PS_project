package com.lab_ps.project_ps.repository;

import com.lab_ps.project_ps.model.UserAuth;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAuthRepository extends CrudRepository<UserAuth, Long> {
    UserAuth findByUsername(String username);
}
