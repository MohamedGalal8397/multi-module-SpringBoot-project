package com.Mohamed.VoucherApllication.service.RoleService;

import com.Mohamed.VoucherApllication.model.entity.RoleEntity;
import com.Mohamed.VoucherApllication.model.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface RoleService {



    RoleEntity createRole(RoleEntity roleEntity );
    void deleteRole(int id);
    Optional<RoleEntity> findRole(int id);


    List<RoleEntity> findAllRoles();

    boolean RoleExist(int id);


}
