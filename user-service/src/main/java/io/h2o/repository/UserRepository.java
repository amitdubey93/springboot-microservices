package io.h2o.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import io.h2o.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserId(Long userId);
}
