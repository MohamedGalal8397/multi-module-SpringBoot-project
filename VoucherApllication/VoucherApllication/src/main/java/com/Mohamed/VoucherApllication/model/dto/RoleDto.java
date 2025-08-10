package com.Mohamed.VoucherApllication.model.dto;

import com.Mohamed.VoucherApllication.model.entity.UserEntity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoleDto {



    int id  ;

    @NotNull(message = "role can't be null")
    String role;






}
