package com.Mohamed.VoucherApllication.service.RoleService;


import com.Mohamed.VoucherApllication.model.entity.RoleEntity;
import com.Mohamed.VoucherApllication.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository ;

    @Override
    public RoleEntity createRole(RoleEntity roleEntity) {
        return roleRepository.save(roleEntity);
    }

    @Override
    public void deleteRole(int id) {

    }

    @Override
    public Optional<RoleEntity> findRole(int id) {
        return roleRepository.findById(id);
    }

    @Override
    public List<RoleEntity> findAllRoles() {
        return List.of();
    }

    @Override
    public boolean RoleExist(int id) {
        return false;
    }
}
