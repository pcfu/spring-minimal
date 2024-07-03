package com.sephora.fuel.springminimal.repository;

import com.sephora.fuel.springminimal.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    /* Add custom methods here */
}
