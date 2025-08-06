package com.Mohamed.VoucherApllication.model.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "vouchers")
public class VoucherEntity {


     @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)

     int id  ;
     String code;
     Double discount  ;
     @Column(name = "expired_date")
     Date expiredDate ;



}
