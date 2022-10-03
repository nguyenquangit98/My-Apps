package com.admin.authentication.dao;

import com.admin.authentication.dao.orm.Authentication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthenticationRepository extends JpaRepository<Authentication, Integer> {
    boolean existsByUsername(String username);

    boolean existsByUsernameAndPassword(String username, String password);
}
