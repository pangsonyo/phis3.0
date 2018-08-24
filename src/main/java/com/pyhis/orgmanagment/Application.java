package com.pyhis.orgmanagment;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;

//@EnableConfigurationProperties(RedisConfig.class)
@EnableRedisHttpSession
@SpringBootApplication
public class Application extends AbstractHttpSessionApplicationInitializer {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }
}
