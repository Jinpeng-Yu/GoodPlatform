package com.hitwh.shop.aop;

import com.hitwh.shop.dao.RoleRepository;
import com.hitwh.shop.dao.UserRepository;
import com.hitwh.shop.model.pojo.BasePageResult;
import com.hitwh.shop.model.pojo.BaseResult;
import com.hitwh.shop.model.pojo.PermissionResult;
import com.hitwh.shop.util.ConstUtils;
import com.hitwh.shop.util.SecurityBean;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName SecurityAspect
 * @Description 用来控制访问权限
 * @Author 孙一恒
 * @Date 2019/6/12 15:58
 * @Version 1.0
 **/

@Aspect
@Component
public class SecurityAspect {
    @Value("${server.servlet.context-path}")
    private String contextPath;

    // 用于打印日志
    private Logger logger = LoggerFactory.getLogger(SecurityAspect.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private SecurityBean securityBean;

    // 切点
    // 拦截除了测试接口和公共接口的所有接口
    @Pointcut("execution(public * com.hitwh.shop.controller.*.*(..)) && !execution(public * com.hitwh.shop.controller.TestController.*(..))")
    public void checkPermission() {

    }

    @Around("checkPermission()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
        //正在被通知的方法相关信息
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        //获取被拦截的方法
        Method method = signature.getMethod();
        //获取被拦截的方法名
        String methodName = method.getName();
        //返回的结果,可以在这里拦截错误，对结果进行修改
        Object result = null;
        //返回方法参数
        Object[] args = joinPoint.getArgs();
        logger.info("拦截到了方法:" + methodName);
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        logger.info("uri:" + request.getRequestURI());
        String uri = request.getRequestURI().replaceFirst(contextPath,"");
        logger.info("After replace uri:" + uri);
        if (!judgeLogin(request, uri)) {
            return checkReturnType(method);
        }
//        try {
//            result = joinPoint.proceed();
//        } catch (Throwable throwable) {
//            throwable.printStackTrace();
//            result = error500();
//        }
//        System.out.println(result);
        return joinPoint.proceed();
    }


    private Object checkReturnType(Method method){
        Class c = method.getReturnType();
        if (c == BaseResult.class){
            BaseResult<String> baseResult = new BaseResult<>();
            baseResult.construct(false, ConstUtils.MSG_NO_PERMISSION, null);
            return baseResult;
        }
        if (c == BasePageResult.class){
            BasePageResult<List<String>> baseResult = new BasePageResult<>();
            baseResult.construct(false, ConstUtils.MSG_NO_PERMISSION, new ArrayList<>());
            return baseResult;
        }
        return null;
    }

    private BaseResult error500() {
        return new BaseResult<Object>(false, ConstUtils.ERROR_500, null);
    }


    /**
     * 判断当前用户的权限是否能够访问当前接口
     */
    private boolean judgeLogin(HttpServletRequest request, String uri) {
        HttpSession session = request.getSession();
        try {
            // 如果用户未登陆, 则查询并为其设置游客权限
            if (session.getAttribute(ConstUtils.SESSION_USER_ID) == null && session.getAttribute(ConstUtils.SESSION_PERMISSION_LIST) == null) {
                List<PermissionResult> permissionList = roleRepository.getVisitorPermission();
                session.setAttribute(ConstUtils.SESSION_PERMISSION_LIST, permissionList);
                return securityBean.checkRolePermission(permissionList, uri);
            } else {
                // 用户已登陆，则查看其是否具有当前请求的权限
                List<PermissionResult> permissionList = (List<PermissionResult>) session.getAttribute(ConstUtils.SESSION_PERMISSION_LIST);
                return securityBean.checkRolePermission(permissionList, uri);
            }
        } catch (Exception e) {
//            e.printStackTrace();
            return false;
        }
    }
}
