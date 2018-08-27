package com.pyhis.orgmanagment.config;

import com.pyhis.orgmanagment.exception.UserNotLoginExcetption;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Map;

@Log4j2
public class SystemInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)  {
        log.info("preHandle");
//       if(1==1) {
//           throw new UserNotLoginExcetption();
//       }
        //the method name of the controller method in the request url  JUST FOR TEST
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        String methonName = handlerMethod.getMethod().getName();
        String className = handlerMethod.getBean().getClass().getSimpleName();

        StringBuffer requestParamBuffer = new StringBuffer();
        //Map paramMap = 
         request.getParameterMap().forEach((K,V)->{
               String mapKey = K;
               String mapValue = "";
               Object object = V;
               if(object instanceof String[]){
                   String[] strs = (String[]) object;
                   mapValue = Arrays.toString(strs);
               }
             requestParamBuffer.append(mapKey).append("=").append(mapValue);
         });


        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)  {
       log.info("postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
       log.info("afterCompletion");
    }
}
