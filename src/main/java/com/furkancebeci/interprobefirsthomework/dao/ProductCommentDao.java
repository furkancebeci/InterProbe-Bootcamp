package com.furkancebeci.interprobefirsthomework.dao;

import com.furkancebeci.interprobefirsthomework.entity.ProductComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ProductCommentDao extends JpaRepository<ProductComment, Long> {

   List<ProductComment> findAllByProduct_Id(Long productId);

   List<ProductComment> findAllByProduct_IdAndCommentDateBetween(Long productId, Date firstDate, Date secondDate);

   List<ProductComment> findAllByUsers_Id(Long userId);

   List<ProductComment> findAllByUsers_IdAndCommentDateBetween(Long userId, Date firstDate, Date secondDate);
}
