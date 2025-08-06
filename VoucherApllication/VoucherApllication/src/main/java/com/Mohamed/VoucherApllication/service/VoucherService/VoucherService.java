package com.Mohamed.VoucherApllication.service.VoucherService;


import com.Mohamed.VoucherApllication.model.entity.VoucherEntity;

import java.util.List;
import java.util.Optional;


public interface VoucherService {


    VoucherEntity creataVoucher(VoucherEntity voucherEntity );
    void deleteVoucher(int id);
   Optional< VoucherEntity >  findVoucher(int id);
    Optional< VoucherEntity >  findVoucherByCode(String code);

   List<VoucherEntity> findAllVouchers();

    boolean voucherExist(int id);

}
