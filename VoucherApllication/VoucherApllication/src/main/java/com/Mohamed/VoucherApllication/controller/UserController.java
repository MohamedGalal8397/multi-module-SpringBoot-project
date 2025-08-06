package com.Mohamed.VoucherApllication.controller;


import com.Mohamed.VoucherApllication.mapper.UserMapper;
import com.Mohamed.VoucherApllication.model.dto.UserDto;
import com.Mohamed.VoucherApllication.model.dto.UserDto;
import com.Mohamed.VoucherApllication.model.entity.UserEntity;
import com.Mohamed.VoucherApllication.service.UserService.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/User")
public class UserController {


    @Autowired
    UserService userService ;

    @Autowired
    UserMapper userMapper;


    @PostMapping("/SaveUser")
    public UserDto createUser(@RequestBody @Valid UserDto userDto){
        try{


            UserEntity userEntity = userMapper.toEntity(userDto);
            UserEntity userEntitySaved = userService.createUser(userEntity);
            UserDto UserDtoSaved = userMapper.toDto(userEntitySaved);
            return UserDtoSaved;
        }catch (Exception e ){
            e.printStackTrace();
            throw e ;
        }
    }



    @DeleteMapping("/deleteUser")
    public ResponseEntity<?> deleteUser(@RequestParam int id ){
        userService.deleteUser(id);
        String message = " Voucher is deleted" ;
        return  new ResponseEntity<>(message , HttpStatus.OK);
    }




    @GetMapping("/getUser")

    public ResponseEntity<?>  findUser(@RequestParam int id){
        Optional<UserEntity> userEntity=  userService.findUser(id);
        if (userEntity.isEmpty()){
            String message = "User is not found";
            return new ResponseEntity<>(message , HttpStatus.NOT_FOUND);
        }else {
            UserDto UserDto= userMapper.toDto(userEntity.get());
            return new ResponseEntity<>(UserDto , HttpStatus.OK);
        }
    }




    @GetMapping( "/getUsers")
    public List<UserDto> findUsers(){
        List<UserEntity> userEntities= userService.findAllUsers();
        List<UserDto> UserDtos = new ArrayList<>();
        for (UserEntity userEntity : userEntities){
            UserDtos.add(userMapper.toDto(userEntity));
        }
        return UserDtos;
    }


}
