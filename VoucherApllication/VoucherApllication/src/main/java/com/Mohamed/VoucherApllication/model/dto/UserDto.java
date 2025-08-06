package com.Mohamed.VoucherApllication.model.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.sql.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {



    int id  ;

    @NotNull (message = "First Name can't be null ")
    String firstName;
    @NotNull (message = "Last Name can't be null ")
    String lastName;

    @NotNull (message = "Email can't be null ")
    @Column(unique = true, nullable = false)
    String email;
    @NotNull (message = "Password can't be null ")
    String password;

    private List<String> roles;


}
