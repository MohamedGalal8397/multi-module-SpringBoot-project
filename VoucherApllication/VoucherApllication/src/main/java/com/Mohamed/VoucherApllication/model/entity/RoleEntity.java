package com.Mohamed.VoucherApllication.model.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
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
    int id  ;

    @Column(name = "name")
   private String role;

    public String getRole() {
        return role;
    }

    @ManyToMany(mappedBy = "roles")
    private List<UserEntity> users;


    @Override
    public String getAuthority() {
        return "";
    }
}
