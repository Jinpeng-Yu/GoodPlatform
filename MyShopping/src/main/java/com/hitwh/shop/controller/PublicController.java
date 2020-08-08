package com.hitwh.shop.controller;

import com.hitwh.shop.dao.SensitiveWordRepository;
import com.hitwh.shop.model.pojo.BasePageResult;
import com.hitwh.shop.model.pojo.BaseResult;
import com.hitwh.shop.model.pojo.LoginResult;
import com.hitwh.shop.model.pojo.SPUResultForBuyer;
import com.hitwh.shop.service.PublicService;
import com.hitwh.shop.util.ConstUtils;
import com.hitwh.shop.util.SensitiveWordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

/**
 * @ClassName PublicController
 * @Description 公共访问的接口放到这里
 * @Author 孙一恒
 * @Date 2020/6/1 17:05
 * @Version 1.0
 **/
@RestController
@RequestMapping(ConstUtils.URL_PUBLIC)
public class PublicController {
    @Autowired
    private PublicService publicService;

    @Autowired
    private SensitiveWordRepository sensitiveWordRepository;

    /**
     * 进行sensitive_word相关的初始化
     */
    @PostConstruct
    public void init() {
        SensitiveWordUtil.init(sensitiveWordRepository.getAllSensitiveWords());
    }

    //发送验证码
    @RequestMapping(value = ConstUtils.URL_SEND_VERIFY_MAIL, method = RequestMethod.GET)
    public BaseResult<Object> sendVerifyMail(@RequestParam("email") String email, HttpSession session) {
        BaseResult<Object> result = new BaseResult<>();
        publicService.sendVerifyMail(result, email, session);
        return result;
    }

    //发送邮件更改密码
    @RequestMapping(value = ConstUtils.URL_SEND_VERIFY_MAIL_PW, method = RequestMethod.GET)
    public BaseResult<Object> sendVerifyMailPW(@RequestParam("email") String email, HttpSession session){
        BaseResult<Object> result = new BaseResult<>();
        publicService.sendVerifyMailPW(result, email, session);
        return result;
    }

    //注册
    @RequestMapping(value = ConstUtils.URL_REGISTER, method = RequestMethod.GET)
    public BaseResult<Object> register(@RequestParam("username") String username, @RequestParam("email") String email,
                                       @RequestParam("password") String password, @RequestParam("captcha") String captcha,
                                       HttpSession session) {
        BaseResult<Object> result = new BaseResult<>();
        publicService.register(result, username, email, password, captcha, session);
        return result;
    }

    //忘记密码邮件验证
    @RequestMapping(value = ConstUtils.URL_FORGET, method = RequestMethod.GET)
    public BaseResult<Object> forget(@RequestParam("email") String email,@RequestParam("captcha") String captcha,HttpSession session){
        BaseResult<Object> result = new BaseResult<>();
        publicService.forget(result, email, captcha, session);
        return result;
    }

    //登录
    @RequestMapping(value = ConstUtils.URL_LOGIN, method = RequestMethod.GET)
    public BaseResult<LoginResult> login(HttpSession session, @RequestParam("username") String username,
                                         @RequestParam("password") String password) {
        BaseResult<LoginResult> result = new BaseResult<>();
        publicService.login(result, username, password, session);
        return result;
    }

    //直接展示所有商品(分页）
    @RequestMapping(value = ConstUtils.URL_SHOW_ALL_SPU, method = RequestMethod.GET)
    public BasePageResult<Object> searchSPUByName(@RequestParam("pageNo") int pageNo, @RequestParam("pageSize")int pageSize){
        BasePageResult<Object> result = new BasePageResult<>();
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        publicService.showAllSPU(result,pageable);
        return result;
    }

    //根据名字查询商品(分页）
    @RequestMapping(value = ConstUtils.URL_SEARCH_SPU_BY_NAME, method = RequestMethod.GET)
    public BasePageResult<Object> searchSPUByName(@RequestParam("pageNo") int pageNo, @RequestParam("pageSize")int pageSize, @RequestParam("goodName") String goodName){
        BasePageResult<Object> result = new BasePageResult<>();
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        publicService.searchSPUByName(result,goodName,pageable);
        return result;
    }

    //根据种类查询商品（分页）
    @RequestMapping(value = ConstUtils.URL_SEARCH_SPU_BY_TYPE, method = RequestMethod.GET)
    public BasePageResult<Object> searchSPUByType(@RequestParam("pageNo") int pageNo, @RequestParam("pageSize")int pageSize, @RequestParam("goodType") String goodType){
        BasePageResult<Object> result = new BasePageResult<>();
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        publicService.searchSPUByType(result,goodType,pageable);
        return result;
    }

    //获取商品种类（为了在导航栏中显示）
    @RequestMapping(value = ConstUtils.URL_SHOW_SPU_TYPE, method = RequestMethod.GET)
    public BaseResult<Object> showSPUType(){
        BaseResult<Object> result = new BaseResult<>();
        publicService.showSPUType(result);
        return result;
    }

    //浏览商品页面
    @RequestMapping(value = ConstUtils.URL_SHOW_SPU, method = RequestMethod.GET)
    public BaseResult<SPUResultForBuyer> showSPU(@RequestParam("spuId") Integer spuId) {
        BaseResult<SPUResultForBuyer> result = new BaseResult<>();
        publicService.showSPU(result,spuId);
        return result;
    }

    //获取商品评论
    @RequestMapping(value = ConstUtils.URL_SHOW_SPU_COMMENT, method = RequestMethod.GET)
    public BaseResult<Object> showSpuComment(@RequestParam("spuId") Integer spuId){
        BaseResult <Object> result= new BaseResult<>();
        publicService.showSpuComment(result,spuId);
        return result;
    }
}