package com.furkancebeci.interprobefirsthomework.controller;

import com.furkancebeci.interprobefirsthomework.dao.ProductDao;
import com.furkancebeci.interprobefirsthomework.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductDao productDao;


    @PostMapping("/save")
    public Product save(@RequestBody Product product){
        return productDao.save(product);
    }

    @GetMapping("/findall")
    public List<Product> findAll(){
        return productDao.findAll();
    }

    @GetMapping("/expired")
    public List<Product> findAllByExpirationDateLessThan(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date date){
        return productDao.findAllByExpirationDateLessThan(date);
    }

    @GetMapping("/notexpired")
    public List<Product> findAllByExpirationDateAfter(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date date){
        return productDao.findAllByExpirationDateAfterOrExpirationDateIsNull(date);
    }
}
