package com.pyhis.orgmanagment.exception;

import com.pyhis.orgmanagment.VO.ResultVO;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常 可部抓controller,service,dao层异常
 */
@ControllerAdvice
@Log4j2
public class ExceptionAdviceConfig {

    /**
     * 全局异常捕捉处理
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ResultVO<String> errorHandler(Exception ex, HttpServletRequest request) {
        log.error("{} coming exception",request.getRequestURI(),ex);
        return  ResultVO.createByErrorMessage("未知错误，请联系管理员");
    }

}
