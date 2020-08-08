package com.hitwh.shop.util;

import com.hitwh.shop.dao.RoleRepository;
import com.hitwh.shop.dao.UserRepository;
import com.hitwh.shop.model.pojo.PermissionResult;
import com.hitwh.shop.model.pojo.RolePermissionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Du on 2019/4/9.
 */
@Component
public class SecurityBean {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    // 用来验证某用户的角色列表是否具有访问该uri的权限
    public boolean checkRolePermission(List<PermissionResult> permissionResultList, String uri) {
        for (PermissionResult pr : permissionResultList) {
            if (uri.startsWith(pr.getUrlPrefix())) {
                return true;
            }
        }
        return false;
    }
}
