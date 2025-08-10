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

    public int getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public Double getDiscount() {
        return discount;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }
}
