package com.Mohamed.VoucherApllication.model.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class VoucherDto {





    int id  ;
    @NotNull(message = "Voucher name can't be null")
    String  code ;

    @NotNull(message = "Voucher discount can't be null")
    Double discount  ;


    @NotNull(message = "Voucher expired date can't be null")
    Date expiredDate;



}
