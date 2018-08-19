package com.pyhis.orgmanagment.VO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pyhis.orgmanagment.utils.ResponseCode;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data

public class ResultVO<T> {

    private int code;
    private String msg;
    private T data;

    public ResultVO(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultVO(int code) {
        this.code = code;
    }

    public ResultVO(int code, T data) {
        this.code = code;
        this.data = data;
    }

    public ResultVO(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    @JsonIgnore
    public boolean isSuccess(){
        return this.code == ResponseCode.SUCCESS.getCode();
    }

    public static <T> ResultVO<T> createBySuccess(){
        return new ResultVO<T>(ResponseCode.SUCCESS.getCode());
    }

    public ResultVO() {
    }


    public static <T> ResultVO<T> createBySuccessMessage(String msg){
        return new ResultVO<T>(ResponseCode.SUCCESS.getCode(),msg);
    }

    public static <T> ResultVO<T> createBySuccess(T data){
        return new ResultVO<T>(ResponseCode.SUCCESS.getCode(),data);
    }

    public static <T> ResultVO<T> createBySuccess(String msg,T data){
        return new ResultVO<T>(ResponseCode.SUCCESS.getCode(),msg,data);
    }


    public static <T> ResultVO<T> createByError(){
        return new ResultVO<T>(ResponseCode.ERROR.getCode(),ResponseCode.ERROR.getDesc());
    }


    public static <T> ResultVO<T> createByErrorMessage(String errorMessage){
        return new ResultVO<T>(ResponseCode.ERROR.getCode(),errorMessage);
    }

    public static <T> ResultVO<T> createByErrorCodeMessage(int errorCode,String errorMessage){
        return new ResultVO<T>(errorCode,errorMessage);
    }
}
