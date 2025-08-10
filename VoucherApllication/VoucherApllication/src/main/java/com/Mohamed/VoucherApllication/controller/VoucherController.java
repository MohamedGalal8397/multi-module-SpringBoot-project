package com.Mohamed.VoucherApllication.controller;


import com.Mohamed.VoucherApllication.mapper.VoucherMapper;
import com.Mohamed.VoucherApllication.model.dto.VoucherDto;
import com.Mohamed.VoucherApllication.model.entity.VoucherEntity;
import com.Mohamed.VoucherApllication.service.VoucherService.VoucherService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Vouchers")
public class VoucherController {

    @Autowired
    VoucherService voucherService;

    @Autowired
    VoucherMapper voucherMapper;


    @PostMapping("/SaveVoucher")
    public VoucherDto createVoucher(@RequestBody @Valid VoucherDto voucherDto) {
        try {


            VoucherEntity voucherEntity = voucherMapper.toEntity(voucherDto);
            VoucherEntity voucherEntitySaved = voucherService.creataVoucher(voucherEntity);
            VoucherDto voucherDtoSaved = voucherMapper.toDto(voucherEntitySaved);
            return voucherDtoSaved;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }


    @DeleteMapping("/deleteVoucher")
    public ResponseEntity<?> deleteVoucher(@RequestParam int id) {
        voucherService.deleteVoucher(id);
        String message = " Voucher is deleted";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }


    @GetMapping("/getVoucher")

    public ResponseEntity<?> findVoucher(@RequestParam int id) {
        Optional<VoucherEntity> voucherEntity = voucherService.findVoucher(id);
        if (voucherEntity.isEmpty()) {
            String message = "Voucher is not found";
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        } else {
            VoucherDto voucherDto = voucherMapper.toDto(voucherEntity.get());

            return new ResponseEntity<>(voucherDto, HttpStatus.OK);
        }
    }


    @GetMapping("/getVouchers")
    public List<VoucherDto> findVoucher(
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String direction,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Sort sort = direction.equalsIgnoreCase("asc") ?
                Sort.by(sortBy).ascending() :
                Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(page, size, sort);
        Page<VoucherEntity> voucherEntities = voucherService.findAllVouchers(pageable);

        List<VoucherDto> voucherDtos = new ArrayList<>();
        for (VoucherEntity voucherEntity : voucherEntities) {
            voucherDtos.add(voucherMapper.toDto(voucherEntity));
        }
        return voucherDtos;
    }


    @GetMapping("findVoucherByCode/{code}")
    public ResponseEntity<?> findVoucherByCode(@PathVariable("code") String code) {
        Optional<VoucherEntity> voucherEntity = voucherService.findVoucherByCode(code);
        if (voucherEntity.isEmpty()) {
            String message = "Voucher is not found";
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        } else {
            VoucherDto voucherDto = voucherMapper.toDto(voucherEntity.get());
            return new ResponseEntity<>(voucherDto, HttpStatus.OK);
        }
    }


}

