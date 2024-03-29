package com.hitwh.shop.service;

import com.hitwh.shop.model.pojo.BaseResult;
import com.hitwh.shop.model.pojo.MaxOrderResult;
import com.hitwh.shop.model.pojo.SpuTypeExpenseResult;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public interface BuyerService {
    public void getCollection(BaseResult result, Integer userId, HttpSession session);

    public void addCollection(BaseResult<Object> result, Integer userId, Integer spuId, HttpSession session);

    public void deleteCollection(BaseResult<Object> result, Integer userId, Integer spuId, HttpSession session);

    public void getExpenseByTime(HttpSession session, BaseResult<List<SpuTypeExpenseResult>> result, Timestamp startTime , Timestamp endTime);

    public void getMaxOrderByTime(HttpSession session, BaseResult<MaxOrderResult> result, Timestamp startTime, Timestamp endTime);

    public void addShoppingCart(BaseResult<Object> result, Integer userId, Integer spuId, Integer number, HttpSession session);

    public void getUserInfoById(BaseResult<Object> result, HttpSession session);

    public void getProvince(BaseResult<Object> result, HttpSession session);

    public void getOrderByUserId(HttpSession session, BaseResult<Object> result);

    public void getShoppingCart(HttpSession session, BaseResult<Object> result);

    public void getCity(BaseResult<Object> result, String name, HttpSession session);

    public void getCounty(BaseResult<Object> result, String name, HttpSession session);

    public void saveUserInfo(BaseResult<Object> result, String headImg, String provinceName, String cityName, String countyName, String detail, String phone, String password, HttpSession session);

    public void getUserRole(BaseResult<Object> result, HttpSession session);

    public void createStore(String description, HttpSession session, BaseResult<Object> result);

    public void addSpuComment(BaseResult<Object> result, Integer spuId, Integer userId, Integer grade, String comment, HttpSession session);

    public void addOrder(BaseResult<Object> result, Integer spuId, Integer skuId, Integer amount, String spuName, BigDecimal price, HttpSession session);

    public void deleteOrder(BaseResult<Object> result,Integer orderId,HttpSession session);

    public void deleteShoppingCart(Integer skuId,HttpSession session,BaseResult<Object> result);
}