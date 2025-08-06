package com.Mohamed.VoucherApllication.controller;


import com.Mohamed.VoucherApllication.mapper.RoleMapper;
import com.Mohamed.VoucherApllication.mapper.UserMapper;
import com.Mohamed.VoucherApllication.model.dto.RoleDto;
import com.Mohamed.VoucherApllication.model.entity.RoleEntity;
import com.Mohamed.VoucherApllication.model.entity.UserEntity;
import com.Mohamed.VoucherApllication.service.RoleService.RoleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Role")
public class RoleController {





    @Autowired
    RoleService roleService ;

    @Autowired
    RoleMapper roleMapper;


    @PostMapping("/SaveRole")
    public RoleDto createRole(@RequestBody @Valid RoleDto roleDto){
        try{


            RoleEntity roleEntity = roleMapper.toEntity(roleDto);
            RoleEntity roleEntitySaved = roleService.createRole(roleEntity);
            RoleDto RoleDtoSaved = roleMapper.toDto(roleEntitySaved);
            return RoleDtoSaved;
        }catch (Exception e ){
            e.printStackTrace();
            throw e ;
        }
    }



    @DeleteMapping("/deleteRole")
    public ResponseEntity<?> deleteRole(@RequestParam int id ){
        roleService.deleteRole(id);
        String message = " Role is deleted" ;
        return  new ResponseEntity<>(message , HttpStatus.OK);
    }




    @GetMapping("/getRole")

    public ResponseEntity<?>  findRole(@RequestParam int id){
        Optional<RoleEntity> roleEntity=  roleService.findRole(id);
        if (roleEntity.isEmpty()){
            String message = "Role is not found";
            return new ResponseEntity<>(message , HttpStatus.NOT_FOUND);
        }else {
            RoleDto RoleDto= roleMapper.toDto(roleEntity.get());
            return new ResponseEntity<>(RoleDto , HttpStatus.OK);
        }
    }




    @GetMapping( "/getRoles")
    public List<RoleDto> findRoles(){
        List<RoleEntity> roleEntities= roleService.findAllRoles();
        List<RoleDto> RoleDtos = new ArrayList<>();
        for (RoleEntity roleEntity : roleEntities){
            RoleDtos.add(roleMapper.toDto(roleEntity));
        }
        return RoleDtos;
    }

}
