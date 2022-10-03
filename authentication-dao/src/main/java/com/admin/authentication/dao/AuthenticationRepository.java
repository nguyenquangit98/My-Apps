package com.admin.authentication.dao;

import com.admin.authentication.dao.orm.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthenticationRepository extends JpaRepository<User, Integer> {
    boolean existsByUsername(String username);

    boolean existsByUsernameAndPassword(String username, String password);
}
