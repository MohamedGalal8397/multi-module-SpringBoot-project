package com.Mohamed.VoucherApllication.repository;

import com.Mohamed.VoucherApllication.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer > {

    Optional<UserEntity> findByEmail(String email);
}
