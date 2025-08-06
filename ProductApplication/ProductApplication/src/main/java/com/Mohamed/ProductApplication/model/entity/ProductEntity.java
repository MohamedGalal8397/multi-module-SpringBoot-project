package com.Mohamed.ProductApplication.model.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "products")
public class ProductEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        int id  ;

           String name ;
          String  description ;
           Double price ;


           // عشان مش تتسجل ف data base
           @Transient
            String voucherCode;


}
