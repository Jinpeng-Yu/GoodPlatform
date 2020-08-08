package com.hitwh.shop.dao;

import com.hitwh.shop.model.entity.Spu;
import com.hitwh.shop.model.entity.SpuType;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @ClassName RoleRepository
 * @Description TODO
 * @Author 苏嘉尧
 * @Date 2019/6/16 11:57
 * @Version 1.0
 **/

public interface SPURepository extends JpaRepository<Spu, Integer> {

//    @Query(value = "select new com.hitwh.shop.model.entity.Spu(s.id,s.spuTypeId,s.storeId,s.name,s.img,s.date,s.description,s.state,s.deleted) " +
//            "from Spu s, SpuType st where st.name = :SpuType and st.id = s.spuTypeId and s.deleted = 0 and st.deleted = 0")
//    List<Spu> findSpuBySpuType(@Param("SpuType") String SpuType);
//
//    List<Spu> findSpuByNameLike(String SpuName);

    @Query(value = "select new com.hitwh.shop.model.entity.Spu(s.id,s.spuTypeId,s.storeId,s.name,s.img,s.date,s.description,s.state,s.deleted) " +
            "from Spu s where s.deleted = 0 and s.name like :SpuName")
    Page<Spu> findSpusByPageByName(Pageable pageable, @Param("SpuName") String SpuName);

    @Query(value = "select new com.hitwh.shop.model.entity.Spu(s.id,s.spuTypeId,s.storeId,s.name,s.img,s.date,s.description,s.state,s.deleted) " +
            "from Spu s, SpuType st where st.name = :SpuType and st.id = s.spuTypeId and s.deleted = 0 and st.deleted = 0")
    Page<Spu> findSpusByPageByType(Pageable pageable, @Param("SpuType") String SpuType);

    @Query(value = "select new com.hitwh.shop.model.entity.Spu(s.id,s.spuTypeId,s.storeId,s.name,s.img,s.date,s.description,s.state,s.deleted) " +
            "from Spu s where s.id = :spuId and s.deleted = 0")
    Spu findSpuById(@Param("spuId")Integer spuId);

    @Query(value = "select new com.hitwh.shop.model.entity.Spu(s.id,s.spuTypeId,s.storeId,s.name,s.img,s.date,s.description,s.state,s.deleted) from Spu s where s.deleted = 0")
    Page<Spu> findAllSpuByPage(Pageable pageable);

    @Query(value = "select new com.hitwh.shop.model.entity.Spu(s.id,s.spuTypeId,s.storeId,s.name,s.img,s.date,s.description,s.state,s.deleted) " +
            "from Spu s where s.deleted = :deleted")
    Page<Spu> findSpusByPageByDeleted(Pageable pageble, @Param("deleted")Integer deleted);

    @Query(value = "select s from Spu s, User u, Store store where u.id = :userId and store.userId = u.id " +
            "and s.storeId = store.id and s.deleted = 0 and u.deleted = 0 and store.deleted = 0")
    Page<Spu> findSpusByUserId(Pageable pageble, Integer userId);

    @Query(value = "select s from Spu s, User u, Store store where u.id = :userId and store.userId = u.id " +
            "and s.storeId = store.id and s.name like %:query% and s.deleted = 0 and u.deleted = 0 and store.deleted = 0")
    Page<Spu> findSpusByNameByUserId(Pageable pageable, String query, Integer userId);

    @Transactional
    @Modifying
    @Query(value = "update Spu s set s.deleted = 1 where s.id = :spuId")
    void deleteSpuById(Integer spuId);

    @Transactional
    @Modifying
    @Query(value = "update Spu s set s.name = :spuName, s.img = :spuImg, s.description = :spuIntroduce where s.id = :spuId")
    void updateSpuById(Integer spuId, String spuName, String spuImg, String spuIntroduce);

}
