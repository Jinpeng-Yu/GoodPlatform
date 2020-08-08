package com.hitwh.shop.controller;

import com.hitwh.shop.model.entity.User;
import com.hitwh.shop.model.pojo.BaseResult;
import com.hitwh.shop.service.UserService;
import com.hitwh.shop.util.ConstUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author 孙一恒
 * @Date 2020/6/1 19:31
 * @Version 1.0
 **/
@RestController
@RequestMapping(ConstUtils.URL_USER)
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = ConstUtils.URL_LOGOUT, method = RequestMethod.POST)
    public BaseResult logout(HttpSession session) {
        BaseResult result = new BaseResult();
        userService.logout(result, session);
        return result;
    }
}
