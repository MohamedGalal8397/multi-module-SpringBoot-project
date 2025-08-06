package com.Mohamed.VoucherApllication.mapper;



import com.Mohamed.VoucherApllication.model.dto.VoucherDto;
import com.Mohamed.VoucherApllication.model.entity.VoucherEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@ComponentScan
@Mapper(componentModel ="spring")
public interface VoucherMapper {



//    @Mapping(source = "id", target = "id")
//    @Mapping(source = "code", target = "code")
//    @Mapping(source = "discount", target = "discount")
//    @Mapping(source = "expiredDate", target = "expiredDate")

    VoucherDto toDto (VoucherEntity voucherEntity);

//    @Mapping(source = "id", target = "id")
//    @Mapping(source = "code", target = "code")
//    @Mapping(source = "discount", target = "discount")
//    @Mapping(source = "expiredDate", target = "expiredDate")

    VoucherEntity toEntity (VoucherDto voucherDto);






}
