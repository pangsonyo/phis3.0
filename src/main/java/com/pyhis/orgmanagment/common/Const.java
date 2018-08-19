package com.pyhis.orgmanagment.common;

import java.util.Set;

public class Const {

    public static final String CURRENT_USER = "currentUser";

    public static final String EMAIL = "email";
    public static final String USERNAME = "username";
    public static final String TOKEN_PREFIX = "token_";


    public interface RedisCacheExtime{
        int REDIS_SESSION_EXTIME = 60 * 30;//30min
    }

    public interface Role{
        int ROLE_CUSTOMER = 0; //普通用户
        int ROLE_ADMIN = 1;//管理员
    }

}
