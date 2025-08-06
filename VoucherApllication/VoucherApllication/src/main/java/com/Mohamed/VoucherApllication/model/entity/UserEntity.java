package com.Mohamed.VoucherApllication.model.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    int id  ;
    @Column(name = "first_name")
    String firstName;
    @Column(name = "last_name")
    String lastName;
    String email;
    String password;

            @ManyToMany(fetch = FetchType.EAGER)
            @JoinTable(name = "user_role" ,
                    joinColumns = @JoinColumn(name = "user_id") ,
                    inverseJoinColumns =@JoinColumn(name = "role_id") )

             List<RoleEntity> roles ;

    public List<RoleEntity> getRoles() {
        return roles;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getId() {
        return id;
    }
}
