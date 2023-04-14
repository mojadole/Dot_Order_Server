package com.dotorder.DotOrder.repository;

import com.dotorder.DotOrder.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Integer> {
}
