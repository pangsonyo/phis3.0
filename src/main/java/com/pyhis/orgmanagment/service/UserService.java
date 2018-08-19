package com.pyhis.orgmanagment.service;

import com.pyhis.orgmanagment.VO.ResultVO;
import com.pyhis.orgmanagment.entity.User;

public interface UserService {

    ResultVO<User> login(String username, String password);

}
