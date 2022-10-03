package com.admin;

import com.admin.orm.Authentication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthenticationRepository extends JpaRepository<Integer, Authentication> {
    boolean existsByUsername(String username);

    boolean existsByUsernameAndPassword(String username, String password);
}
