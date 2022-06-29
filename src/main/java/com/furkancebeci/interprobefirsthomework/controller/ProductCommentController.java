package com.furkancebeci.interprobefirsthomework.controller;
import com.furkancebeci.interprobefirsthomework.dao.ProductCommentDao;
import com.furkancebeci.interprobefirsthomework.entity.ProductComment;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/productcomments")
public class ProductCommentController {

    private final ProductCommentDao productCommentDao;

    @PostMapping("/save")
    public ProductComment save(@RequestBody ProductComment productComment){
        return productCommentDao.save(productComment);
    }

    @GetMapping("/comments")
    public List<ProductComment> findAll(){
        return productCommentDao.findAll();
    }

    @GetMapping("/product/{id}")
    public List<ProductComment> findAllCommentsForProduct(@RequestParam Long productId){
        return productCommentDao.findAllByProduct_Id(productId);
    }

    @GetMapping("/date")
    public List<ProductComment> findAllCommentsForProduct(
            @RequestParam Long productId,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd")Date firstDate,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd")Date secondDate){
        return productCommentDao.findAllByProduct_IdAndCommentDateBetween(productId, firstDate, secondDate);
    }

    @GetMapping("/users/{id}")
    public List<ProductComment> findAllCommentsByUser(@RequestParam Long userId){
        return productCommentDao.findAllByUsers_Id(userId);
    }

    @GetMapping("/users/date/{id}")
    public List<ProductComment> findAllCommentsByUserWithDate(
            @RequestParam Long userId,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd")Date firstDate,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd")Date secondDate){
        return productCommentDao.findAllByUsers_IdAndCommentDateBetween(userId, firstDate, secondDate);
    }
}
