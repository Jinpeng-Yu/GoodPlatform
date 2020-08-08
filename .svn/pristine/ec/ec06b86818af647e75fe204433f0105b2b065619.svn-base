package com.hitwh.shop.dao;

import com.hitwh.shop.model.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

    @Query(value = "select new com.hitwh.shop.model.entity.Comment(c.id, c.skuId, c.userId, c.grade, c.content, c.date, c.state, c.deleted) " +
            "from Spu spu,Sku sku,Comment c " +
            "where spu.id = :spuId and sku.spuId = spu.id and c.skuId = sku.id and spu.deleted = 0 and sku.deleted = 0 and c.deleted = 0 " +
            "order by c.date DESC")
    List<Comment> findCommentsBySpuId(@Param("spuId") Integer spuId);
}
