package com.hitwh.shop.service.impl;

import com.hitwh.shop.dao.AddressRepository;
import com.hitwh.shop.dao.UserRepository;
import com.hitwh.shop.model.entity.Address;
import com.hitwh.shop.model.entity.User;
import com.hitwh.shop.model.pojo.BaseResult;
import com.hitwh.shop.model.pojo.UserInfo;
import com.hitwh.shop.service.UserService;
import com.hitwh.shop.util.ConstUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author 孙一恒
 * @Date 2020/6/1 19:32
 * @Version 1.0
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    private AddressRepository addressRepository;

    @Override
    public void logout(BaseResult result, HttpSession session) {
        Integer userId = (Integer)session.getAttribute(ConstUtils.SESSION_USER_ID);
        // 当前没有用户处于登陆状态，直接返回
        if (userId == null) {
            result.construct(true, ConstUtils.MSG_LOGOUT_SUCCESS, null);
            return;
        }
        // 清除当前session中的信息
        session.removeAttribute(ConstUtils.SESSION_USER_ID);
        session.removeAttribute(ConstUtils.SESSION_PERMISSION_LIST);
        result.construct(true, ConstUtils.MSG_LOGOUT_SUCCESS, null);
    }
}
