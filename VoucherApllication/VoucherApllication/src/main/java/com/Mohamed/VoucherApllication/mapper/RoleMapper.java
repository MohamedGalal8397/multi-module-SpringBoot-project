package com.Mohamed.VoucherApllication.mapper;


import com.Mohamed.VoucherApllication.model.dto.RoleDto;
import com.Mohamed.VoucherApllication.model.entity.RoleEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel =  "spring")
public interface RoleMapper {

    RoleDto toDto (RoleEntity roleEntity);
    RoleEntity toEntity (RoleDto roleDto);

    List<RoleDto> toDtoList(List<RoleEntity> entities);

    List<RoleEntity> toEntityList(List<RoleDto> dtos);


}
