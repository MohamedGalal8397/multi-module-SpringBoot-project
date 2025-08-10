package com.Mohamed.VoucherApllication.model.entity;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import java.sql.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "roles")
public class RoleEntity implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id  ;


   private String role;

    public String getRole() {
        return role;
    }

    @ManyToMany(mappedBy = "roles")
    @ToString.Exclude
    private List<UserEntity> users;


    @Override
    public String getAuthority() {
        return role;
    }


}
