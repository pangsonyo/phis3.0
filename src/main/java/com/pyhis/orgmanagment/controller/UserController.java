package com.pyhis.orgmanagment.controller;

import com.pyhis.orgmanagment.VO.ResultVO;
import com.pyhis.orgmanagment.common.Const;
import com.pyhis.orgmanagment.config.RedisService;
import com.pyhis.orgmanagment.entity.User;
import com.pyhis.orgmanagment.service.UserService;
import com.pyhis.orgmanagment.utils.CookieUtil;
import com.pyhis.orgmanagment.utils.JsonUtil;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("user")
@Log4j2
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    RedisService redisService;

//    @Autowired
//    RedisService redisService;

    @GetMapping("login")
    public ResultVO<User> login(String userName, String password, HttpSession session, HttpServletResponse response) {
        ResultVO<User> user = userService.login(userName, password);
        if (user.isSuccess()) {
            CookieUtil.writeLoginToken(response, session.getId());
            //  CookieUtil.readLoginToken(request);
            //  CookieUtil.delLoginToken(request,response);
          //  redisService.setEx(session.getId(), JsonUtil.obj2String(user.getData()), Const.RedisCacheExtime.REDIS_SESSION_EXTIME);
            log.info("write Redis Success key:{}", session.getId());
        }
        return user;
    }

    @PostMapping("getUserInfo")
    public ResultVO<User> getUserInfo(HttpServletRequest request) {
        String loginToken = CookieUtil.readLoginToken(request);
        if (StringUtils.isEmpty(loginToken)) {
            return ResultVO.createByErrorMessage("用户未登陆，无法获取当前用户的信息");
        }
      //  String userJsonStr = redisService.get(loginToken);
      //  User user = JsonUtil.string2Obj(userJsonStr, User.class);
//        if (user != null) {
//            return ResultVO.createBySuccess(user);
//        }
        return ResultVO.createByErrorMessage("用户未登陆，无法获取当前用户的信息");

    }

    @PostMapping("logout")
    public ResultVO<String> logout(HttpServletRequest request, HttpServletResponse response,HttpSession session){
        String loginToken = CookieUtil.readLoginToken(request);
        CookieUtil.delLoginToken(request,response);
        redisService.del(loginToken);

        session.removeAttribute(Const.CURRENT_USER);
        return  ResultVO.createBySuccess();
    }

    @GetMapping("test")
    public void test(){

    }



}
