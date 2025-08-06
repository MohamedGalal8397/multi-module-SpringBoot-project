package com.Mohamed.VoucherApllication.mapper;


import com.Mohamed.VoucherApllication.model.dto.UserDto;
import com.Mohamed.VoucherApllication.model.entity.RoleEntity;
import com.Mohamed.VoucherApllication.model.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface UserMapper {

//    @Mapping(target = "roles", expression = "java(mapRoles(user.getRoles()))")
    UserDto toDto(UserEntity userEntity);


    UserEntity toEntity (UserDto userDto);

     default List<String> mapRoles(List<RoleEntity> roles) {
        return roles.stream().map(RoleEntity::getRole).collect(Collectors.toList());
    }

}
