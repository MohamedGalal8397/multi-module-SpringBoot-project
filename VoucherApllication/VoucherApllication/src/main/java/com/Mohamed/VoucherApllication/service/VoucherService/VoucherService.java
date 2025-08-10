package com.Mohamed.VoucherApllication.service.VoucherService;


import com.Mohamed.VoucherApllication.model.entity.VoucherEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;


public interface VoucherService {


    VoucherEntity creataVoucher(VoucherEntity voucherEntity );
    void deleteVoucher(int id);
   Optional< VoucherEntity >  findVoucher(int id);
    Optional< VoucherEntity >  findVoucherByCode(String code);

   Page<VoucherEntity> findAllVouchers(Pageable pageable);

   //Sort.by(Sort.Direction.ASC, "fieldName")
    boolean voucherExist(int id);

}
