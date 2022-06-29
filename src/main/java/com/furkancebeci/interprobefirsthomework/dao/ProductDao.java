package com.furkancebeci.interprobefirsthomework.dao;

import com.furkancebeci.interprobefirsthomework.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ProductDao extends JpaRepository<Product, Long> {

    List<Product> findAllByExpirationDateLessThan(Date date);

    List<Product> findAllByExpirationDateAfterOrExpirationDateIsNull(Date date);
}
