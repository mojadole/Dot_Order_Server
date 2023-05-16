package com.dotorder.DotOrder.repository;

import com.dotorder.DotOrder.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Integer> {
    Optional<Users> findById(String id);
}
