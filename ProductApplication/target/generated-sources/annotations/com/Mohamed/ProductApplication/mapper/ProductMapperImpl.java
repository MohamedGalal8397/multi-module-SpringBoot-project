package com.Mohamed.ProductApplication.mapper;

import com.Mohamed.ProductApplication.model.dto.ProductDto;
import com.Mohamed.ProductApplication.model.entity.ProductEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-06T16:41:53+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.7 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductDto toDto(ProductEntity productEntity) {
        if ( productEntity == null ) {
            return null;
        }

        ProductDto.ProductDtoBuilder productDto = ProductDto.builder();

        productDto.name( productEntity.getName() );
        productDto.id( productEntity.getId() );
        productDto.description( productEntity.getDescription() );
        productDto.voucherCode( productEntity.getVoucherCode() );
        productDto.price( productEntity.getPrice() );

        return productDto.build();
    }

    @Override
    public ProductEntity toEntity(ProductDto productDto) {
        if ( productDto == null ) {
            return null;
        }

        ProductEntity.ProductEntityBuilder productEntity = ProductEntity.builder();

        productEntity.name( productDto.getName() );
        productEntity.id( productDto.getId() );
        productEntity.description( productDto.getDescription() );
        productEntity.voucherCode( productDto.getVoucherCode() );
        productEntity.price( productDto.getPrice() );

        return productEntity.build();
    }
}
