package com.pyhis.orgmanagment.controller;

import com.pyhis.orgmanagment.VO.ResultVO;
import com.pyhis.orgmanagment.common.Const;
import com.pyhis.orgmanagment.entity.User;
import com.pyhis.orgmanagment.service.UserService;
import com.pyhis.orgmanagment.utils.JsonUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
SpringSesion 测试类
 */

@RestController
@RequestMapping("user/springSession/")
@Log4j2
public class UserSessionController {

    @Autowired
    UserService userService;

//    http://localhost:8080/user/springSession/login?userName =peng&password=123
    @GetMapping("login")
    public ResultVO<User> login(String userName, String password, HttpSession session) {
        ResultVO<User> user = userService.login(userName, password);
        if (user.isSuccess()) {
            session.setAttribute(Const.CURRENT_USER, JsonUtil.obj2String(user.getData()));
            log.info("write Redis Success key:{}", session.getId());
        }
        return user;
    }

    @GetMapping("getUserInfo")
    public ResultVO<User> getUserInfo(HttpSession session) {
        User user = JsonUtil.string2Obj((String) session.getAttribute(Const.CURRENT_USER),User.class) ;
        if (user != null) {
            return ResultVO.createBySuccess(user);
        }
        log.info("get Redis Success key:{}", session.getId());
        return ResultVO.createByErrorMessage("用户未登陆，无法获取当前用户的信息");

    }

    @GetMapping("logout")
    public ResultVO<String> logout(HttpSession session){
        session.removeAttribute(Const.CURRENT_USER);
        return  ResultVO.createBySuccess();
    }

}
