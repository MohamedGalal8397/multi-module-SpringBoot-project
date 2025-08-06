package com.Mohamed.ProductApplication.mapper;


import com.Mohamed.ProductApplication.model.dto.ProductDto;
import com.Mohamed.ProductApplication.model.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan
@Mapper (componentModel = "spring")
public interface ProductMapper {


   @Mapping(source = "name" , target = "name")
   @Mapping(source = "id" , target = "id")
   @Mapping(source = "description" , target = "description")
   @Mapping(source = "voucherCode" , target = "voucherCode")
   @Mapping(source = "price" , target = "price")





    ProductDto toDto (ProductEntity productEntity);

    @Mapping(source = "name" , target = "name")
    @Mapping(source = "id" , target = "id")
    @Mapping(source = "description" , target = "description")
    @Mapping(source = "voucherCode" , target = "voucherCode")
    @Mapping(source = "price" , target = "price")

    ProductEntity toEntity(ProductDto productDto);

}
