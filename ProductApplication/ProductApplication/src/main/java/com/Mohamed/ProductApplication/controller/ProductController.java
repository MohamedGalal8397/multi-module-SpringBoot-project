package com.Mohamed.ProductApplication.controller;


import com.Mohamed.ProductApplication.mapper.ProductMapper;
import com.Mohamed.ProductApplication.model.dto.ProductDto;
import com.Mohamed.ProductApplication.model.entity.ProductEntity;
import com.Mohamed.ProductApplication.service.ProductService;

import com.Mohamed.ProductApplication.voucher.Voucher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Product")
public class ProductController {

        @Autowired
        ProductMapper productMapper ;
        @Autowired
        ProductService productService ;
        @Autowired
        RestTemplate restTemplate ;


        // voucherService.url stored in properties in Voucher app
        @Value("${voucherService.url}")
        // value of voucherService.url will be stored in voucherServiceUrl
        private  String voucherServiceUrl ;

    @PostMapping("/createProduct")
    public ProductDto saveProduct(@RequestBody ProductDto productDto){
       ProductEntity productEntity = productMapper.toEntity(productDto);
       ProductEntity productEntitySaved = productService.saveProduct(productEntity);
       ProductDto productDtoSaved = productMapper.toDto(productEntitySaved);
       return productDtoSaved;
    }


    @PostMapping("/createProductByCode")
    public ProductDto saveProductByCode(@RequestBody ProductDto productDto){

              Voucher voucher =  restTemplate.getForObject(voucherServiceUrl + productDto.getVoucherCode()
                                                            , Voucher.class) ;

        productDto.setPrice( productDto.getPrice() *( 1- voucher.getDiscount()) );
        ProductEntity productEntity = productMapper.toEntity(productDto);
        ProductEntity productEntitySaved = productService.saveProduct(productEntity);
        ProductDto productDtoSaved = productMapper.toDto(productEntitySaved);
        return productDtoSaved;
    }





    @GetMapping("/getProduct")
    public ResponseEntity<?> getProduct(@RequestParam int id){
     Optional < ProductEntity > productEntity =  productService.getProduct(id);
     if (productEntity.isEmpty()){
         String message = "Product is not Found";
         return  new ResponseEntity<>(message , HttpStatus.NOT_FOUND);
     }else{
         ProductDto productDto = productMapper.toDto(productEntity.get());
         return  new ResponseEntity<>(productDto , HttpStatus.OK);
     }
    }




   // List<ProductEntity> getProducts();
    @GetMapping ("/getProducts")
   public List<ProductDto> getAllProducts(){
       List <ProductEntity> productEntities = productService.getProducts();
       List<ProductDto> productDtos = new ArrayList<>();
       for (ProductEntity productEntity :productEntities){
        productDtos .add(   productMapper.toDto(productEntity));
       }
       return productDtos ;
   }






    @DeleteMapping("/deleteProduct")
    public ResponseEntity<?> deleteProduct (@RequestParam int id){
       if ( productService.productExist(id) ){
           productService.deleteProduct(id);
           String message ="Product is deleted";
           return  new ResponseEntity<>(message ,HttpStatus.OK);
       }else {
           String message ="Product is not Found";
           return new ResponseEntity<>(message , HttpStatus.NOT_FOUND);
       }
    }





}
