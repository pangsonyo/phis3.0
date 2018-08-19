package com.pyhis.orgmanagment.service.impl;

import com.pyhis.orgmanagment.VO.ResultVO;
import com.pyhis.orgmanagment.config.RedisService;
import com.pyhis.orgmanagment.entity.User;
import com.pyhis.orgmanagment.repository.UserRepository;
import com.pyhis.orgmanagment.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepo;

    @Autowired
    RedisService redisService;

    @Override
    public ResultVO<User> login(String username, String password) {
//        int resultCount = userRepo.getCountByUserName(username);
//        if(resultCount == 0 ){
//            return ResultVO.createByErrorMessage("用户名不存在");
//        }
//
//// todo 密码校验 例如md5等
//        User user  = userRepo.findUserByNameAndPassword(username,password);
//        if(user == null){
//            return ResultVO.createByErrorMessage("密码错误");
//        }
//
//        user.setPassword(StringUtils.EMPTY);
        User user = new User();
        user.setUserName(username);
        user.setPassword(password);
        return ResultVO.createBySuccess("登录成功",user);
    }
}
