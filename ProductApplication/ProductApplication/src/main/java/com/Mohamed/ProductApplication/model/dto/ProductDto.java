package com.Mohamed.ProductApplication.model.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id  ;

    @NotNull (message = "Product Name can't br null")
    String name ;

    @NotNull (message = "Product description can't br null")
    String  description ;

    @NotNull (message = "Product Price can't br null")
    Double price ;

    @NotNull (message = "Voucher Code can't br null")
    String voucherCode;




}
