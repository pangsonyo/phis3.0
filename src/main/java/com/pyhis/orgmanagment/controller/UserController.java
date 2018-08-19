package com.pyhis.orgmanagment.controller;

import com.pyhis.orgmanagment.VO.ResultVO;
import com.pyhis.orgmanagment.common.Const;
import com.pyhis.orgmanagment.config.RedisService;
import com.pyhis.orgmanagment.entity.User;
import com.pyhis.orgmanagment.service.UserService;
import com.pyhis.orgmanagment.utils.JsonUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("user")
@Log4j2
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    RedisService redisService;

    @GetMapping("login")
    public ResultVO<User> login(String userName, String password, HttpSession session) {
        ResultVO<User> user = userService.login(userName, password);
        if (user.isSuccess()) {
            redisService.setEx(session.getId(), JsonUtil.obj2String(user.getData()), Const.RedisCacheExtime.REDIS_SESSION_EXTIME);
            log.info("write Redis Success key:{}",session.getId());
        }

        return user;
    }
}
