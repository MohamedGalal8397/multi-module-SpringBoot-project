package com.Mohamed.VoucherApllication.service.VoucherService;


import com.Mohamed.VoucherApllication.model.entity.VoucherEntity;
import com.Mohamed.VoucherApllication.repository.VoucherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VoucherServiceImpl  implements VoucherService {

    @Autowired
    VoucherRepository voucherRepository ;


    @Override
    public VoucherEntity creataVoucher(VoucherEntity voucherEntity) {
        return voucherRepository.save(voucherEntity);
    }

    @Override
    public void deleteVoucher(int id) {
         voucherRepository.deleteById(id);

    }

    @Override
    public Optional< VoucherEntity > findVoucher(int id) {
        return voucherRepository.findById(id);
    }

    @Override
    public List<VoucherEntity> findAllVouchers() {
        return voucherRepository.findAll() ;
    }

    @Override
    public boolean voucherExist(int id) {
        return voucherRepository.existsById(id);
    }

    @Override
    public Optional<VoucherEntity> findVoucherByCode(String code) {

        return voucherRepository.findByCode(code);
    }
}
