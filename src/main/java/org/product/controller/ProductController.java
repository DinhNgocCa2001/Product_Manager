package org.product.controller;

import org.product.service.interfaceCustomer.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @GetMapping("/get-data-integration")
    public ResponseEntity<?> getDataIntegration(@RequestParam(defaultValue = "0") int page,
                                                @RequestParam(defaultValue = "10") int size){
        return new ResponseEntity<>(iProductService.getDataIntegration(page, size), HttpStatus.OK);
    }
}
