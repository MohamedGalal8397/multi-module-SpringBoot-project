package com.Mohamed.VoucherApllication.config;


import com.Mohamed.VoucherApllication.mapper.RoleMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VoucherConfiguration {

    RoleMapper roleMapper ;


    public VoucherConfiguration(RoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }
}
