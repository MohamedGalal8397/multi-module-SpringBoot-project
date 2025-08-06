package com.Mohamed.VoucherApllication.service.UserService;

import com.Mohamed.VoucherApllication.model.entity.UserEntity;
import com.Mohamed.VoucherApllication.model.entity.VoucherEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {

    UserEntity createUser(UserEntity userEntity );
    void deleteUser(int id);
    Optional< UserEntity > findUser(int id);


    List<UserEntity> findAllUsers();

    boolean UserExist(int id);


}
