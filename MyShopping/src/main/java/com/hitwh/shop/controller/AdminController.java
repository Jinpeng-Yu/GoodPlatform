package com.hitwh.shop.controller;

import com.hitwh.shop.model.entity.User;
import com.hitwh.shop.model.pojo.BasePageResult;
import com.hitwh.shop.model.pojo.BaseResult;
import com.hitwh.shop.model.pojo.CitySales;
import com.hitwh.shop.model.pojo.LoginResult;
import com.hitwh.shop.service.AdminService;
import com.hitwh.shop.service.PublicService;
import com.hitwh.shop.util.ConstUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * @ClassName AdminController
 * @Description 管理员的功能接口
 * @Author 孙一恒
 * @Date 2020/6/1 17:14
 * @Version 1.0
 **/
@RestController
@RequestMapping(ConstUtils.URL_ADMIN)
public class AdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private PublicService publicService;

//    @RequestMapping(value = ConstUtils.URL_GET_COMMODITY_ITEM_LIST, method = RequestMethod.GET)
//    public BaseResult<Object> getCommodityItemList() {
//        BaseResult<Object> result = new BaseResult<>();
//        adminService.getCommodityItemList(result);
//        return result;
//    }

    //管理员登录
    @RequestMapping(value = ConstUtils.URL_LOGIN, method = RequestMethod.POST)
    public BaseResult<LoginResult> login(HttpSession session,
                                         @RequestParam("username") String username,
                                         @RequestParam("password") String password) {
        BaseResult<LoginResult> result = new BaseResult<>();
        adminService.login(result, username, password, session);
        return result;
    }

    //查询商品类表
    @RequestMapping(value = "/getSPUList",method = RequestMethod.GET)
    public BaseResult<Object> getCollection(@RequestParam("userId") Integer userId, HttpSession session){
        BaseResult <Object> result= new BaseResult<>();
        adminService.getCollection(result, userId, session);
        return result;
    }
    //查看用户信息
    @RequestMapping(value = "/getUserList",method = RequestMethod.GET)
    public BasePageResult<User> getUserList(){
        BasePageResult<User> result = new BasePageResult<>();
        adminService.getUserList(result);
        return result;
    }
    //删除商品
    @RequestMapping(value = ConstUtils.URL_DELETE_COLLECTION,method = RequestMethod.GET)
    public BaseResult<Object> deleteCollection(@RequestParam("SPUID") Integer SPUID ,
                                               @RequestParam("UserId") Integer UserID,
                                               HttpSession session){
        BaseResult <Object> result= new BaseResult<>();
        adminService.deleteCollection(result, SPUID,UserID, session);
        return result;
    }
    //删除用户
    @RequestMapping(value = "/deleteUser",method = RequestMethod.GET)
    public BaseResult<Object> deleteUser(@RequestParam("DeleteUserID") Integer DeleteUserID,
                                        @RequestParam("UserID") Integer UserID,
                                         HttpSession session){
        BaseResult <Object> result= new BaseResult<>();
        adminService.deleteUser(result,DeleteUserID, UserID, session);
        return result;
    }

    @RequestMapping(value = ConstUtils.URL_GET_CITY_SALES, method = RequestMethod.GET)
    public BaseResult<List<CitySales>> getCitySales() {
        BaseResult<List<CitySales>> result = new BaseResult<>();
        adminService.getCitySales(result);
        return result;
    }
    //删除商品
    @RequestMapping(value = "/deleteSPU", method = RequestMethod.GET)
    public BaseResult<Object> deleteSPU(HttpSession session,
                                         @RequestParam("spuId") Integer spuId) {
        BaseResult<Object> result = new BaseResult<>();
        adminService.deleteSPU(result, spuId,  session);
        return result;
    }
}
