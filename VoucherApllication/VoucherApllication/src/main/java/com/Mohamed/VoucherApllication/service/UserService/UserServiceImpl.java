package com.Mohamed.VoucherApllication.service.UserService;

import com.Mohamed.VoucherApllication.model.entity.UserEntity;
import com.Mohamed.VoucherApllication.model.entity.VoucherEntity;
import com.Mohamed.VoucherApllication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserEntity createUser(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    @Override
    public void deleteUser(int id) {
         userRepository.deleteById(id);
    }

    @Override
    public Optional<UserEntity> findUser(int id) {
        return userRepository.findById(id);
    }

    @Override
    public List<UserEntity> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public boolean UserExist(int id) {
        return userRepository.existsById(id);
    }
}
