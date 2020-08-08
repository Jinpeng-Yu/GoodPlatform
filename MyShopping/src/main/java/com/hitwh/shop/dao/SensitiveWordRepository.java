package com.hitwh.shop.dao;

import com.hitwh.shop.model.entity.SensitiveWord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface SensitiveWordRepository extends JpaRepository<SensitiveWord, Integer> {
    @Query("select sw.content from SensitiveWord sw where 1 = 1")
    Set<String> getAllSensitiveWords();
}
