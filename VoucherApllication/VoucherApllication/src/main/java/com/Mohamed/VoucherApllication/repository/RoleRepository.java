package com.Mohamed.VoucherApllication.repository;


import com.Mohamed.VoucherApllication.model.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository <RoleEntity , Integer>{
}
