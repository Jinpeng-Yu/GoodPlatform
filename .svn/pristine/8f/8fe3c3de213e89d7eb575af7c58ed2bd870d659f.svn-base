package com.hitwh.shop.service.impl;

import com.hitwh.shop.dao.OrderRepository;
import com.hitwh.shop.dao.RoleRepository;
import com.hitwh.shop.dao.SPURepository;
import com.hitwh.shop.dao.UserRepository;
import com.hitwh.shop.model.entity.*;
import com.hitwh.shop.model.pojo.*;
import com.hitwh.shop.service.AdminService;
import com.hitwh.shop.util.ConstUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName AdminServiceImpl
 * @Description TODO
 * @Author 孙一恒
 * @Date 2020/6/1 17:20
 * @Version 1.0
 **/
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private SPURepository spuRepository;

    @Override//查看商品列表
    public void getCollection(BaseResult result, Integer userId, HttpSession session)
    {
        Integer currentId = (Integer)session.getAttribute(ConstUtils.SESSION_USER_ID);
        if(currentId != userId)
        {
            result.construct(false, ConstUtils.MSG_COLLECTION_ERROR, null);
        }
        else {

        }
    }
    @Override
    public void login(BaseResult<LoginResult> result, String userName, String password, HttpSession session) {
        User user = userRepository.findUserByUsernameAndPassword(userName, password);
        // 用户名不存在 / 密码错误
        if (user == null) {
            result.construct(false, ConstUtils.MSG_LOGIN_FAILED, null);
            return;
        }
        // 在session中记录当前用户的访问权限和当前用户的id
        List<PermissionResult> permissionResultList = roleRepository.getPermissionByUserId(user.getId());
        session.setAttribute(ConstUtils.SESSION_PERMISSION_LIST, permissionResultList);
        session.setAttribute(ConstUtils.SESSION_USER_ID, user.getId());
        List<Role> roleList = roleRepository.getRolesByUserId(user.getId());
        LoginResult loginResult = new LoginResult(user.getId(), user.getUsername(), roleList);
        result.construct(true, ConstUtils.MSG_LOGIN_SUCCESS, loginResult);
    }


    @Override//查看用户列表
    public void getUserList(BasePageResult<User> result) {
        List<User> UserList = userRepository.findUsersByDeleted(0);
        if (!UserList.isEmpty()) {
            result.setContent(UserList);
            result.setPageSize(UserList.size());

            result.construct(true, ConstUtils.MSG_QUERY_SUCCESS, (User) UserList);
        } else {
            result.construct(true, ConstUtils.MSG_SEARCH_SPU_NULL, (User) UserList);
        }
    }
    @Override//删除商品
    public void deleteCollection(BaseResult result, Integer SPUID,Integer userId, HttpSession session)
    {
        Integer currentId = (Integer)session.getAttribute(ConstUtils.SESSION_USER_ID);
    }
    @Override//删除用户
    public void deleteUser(BaseResult result, Integer deleteUserId,Integer userId, HttpSession session)
    {
        Integer currentId = (Integer)session.getAttribute(ConstUtils.SESSION_USER_ID);
        if(currentId == userId){//检查userId是否一致
            User deleteUser = userRepository.findUserById(deleteUserId);
            if(deleteUser.getDeleted() == 1 ){//检查该用户是否已经被删除
                result.construct(false, ConstUtils.MSG_DELETE_FAILED,null);
            }else{//若该用户未被删除
                userRepository.deleteById(deleteUserId);
                result.construct(true, ConstUtils.MSG_DELETE_SUCCESS, deleteUser);
            }
        }else{//userId不一致提示访问错误
            result.construct(false, ConstUtils.MSG_COLLECTION_ERROR, null);
        }
    }

    @Override
    public void getCitySales(BaseResult<List<CitySales>> result) {
        List<CitySales> citySalesList = orderRepository.getAllCitySales();
        result.construct(true, ConstUtils.MSG_SUCCESS, citySalesList);
    }

    @Override//查看用户页面
    public void showUser(BaseResult<User> result,Integer userId){
        User currentUser = userRepository.findUserById(userId);
        if(currentUser == null){
            result.construct(false, ConstUtils.MSG_SPU_NOT_EXIST, null);
        }else{
            result.construct(true,ConstUtils.MSG_QUERY_SUCCESS,currentUser);

        }
    }

    @Override
    public void deleteSPU(BaseResult<Object> result,Integer spuId, HttpSession session){
        spuRepository.deleteSpuById(spuId);
    };

}
