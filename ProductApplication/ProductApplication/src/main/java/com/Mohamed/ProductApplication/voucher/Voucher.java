package com.Mohamed.ProductApplication.voucher;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Voucher {

    int id  ;

    String  code ;


    Double discount  ;

    Date expiredDate;




}
