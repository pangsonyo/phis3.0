package com.pyhis.orgmanagment.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.pyhis.orgmanagment.entity.User;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * 反序列化工具类
 */
@Log4j2
public class JsonUtil {

    private static ObjectMapper objectMapper = new ObjectMapper();

    static {
        //对象的所有字段 全部列入
        objectMapper.setSerializationInclusion(JsonInclude.Include.ALWAYS);

        //取消默认转换timestamps形式
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

        //忽略the error when empty bean tranfer to json
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

        //统一日期格式为 yyyy-MM-dd HH:mm:ss
        objectMapper.setDateFormat(new SimpleDateFormat(DateTimeUtil.STANDARD_FORMAT));


        //反序列化时  忽略 json字符串中 存在，但java对象中不存在对应属性的情况，防止错误
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    /**
     * 转换为json字符串
     * @param obj
     * @return
     */
    public static<T> String obj2String(T obj) {
        try {
            if (obj == null) {
                return null;

            }
            return obj instanceof String ? (String) obj : objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            log.warn("prase Obj to string error", e);
            return null;
        }

    }

    /**
     * 转换为格式化的json字符串 用于测试
     * @param obj
     * @return
     */
    public static<T> String obj2StringPretty(T obj) {
        try {
            if (obj == null) {
                return null;
            }
            return obj instanceof String ? (String) obj : objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
        } catch (Exception e) {
            log.warn("prase Obj to string error", e);
            return null;
        }

    }

    /**
     * json字符串转对象
     * @param str，clazz
     * @return
     */
    public static<T> T string2Obj(String str, Class<T> clazz) {
        try {
            if(StringUtils.isEmpty(str)||clazz==null){
              return null;
            }
            return clazz.equals(String.class)?(T)str:objectMapper.readValue(str, clazz);
        } catch (IOException e) {
            log.warn("prase String to Obj error", e);
        }
        return null;
    }

    public static<T> T string2Obj(String str, TypeReference<T> typeReference){
        if(StringUtils.isEmpty(str) || typeReference ==null){
            return  null;
        }
        try {
            return (T)(typeReference.getType().equals(String.class)? str : objectMapper.readValue(str,typeReference));
        }catch (Exception e){
            log.warn("Parse String to Object error",e);
            return null;
        }

    }


    public static<T> T string2Obj(String str,Class<?> collectionClass,Class<?>... elementClasses ) {
        JavaType javaType = objectMapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);

        try {
            return objectMapper.readValue(str, javaType);
        } catch (Exception e) {
            log.warn("Parse String to Object error", e);
            return null;
        }
    }

    public static void main(String[] args) {
        User u1 = new User();
        u1.setUserId("123");
        u1.setUserName("lixiaoxia");

        User u2 = new User();
        u2.setUserId("456");
        u2.setUserName("shengsiyan");

        List<User> userList = new ArrayList<>();
        userList.add(u1);
        userList.add(u2);

        String userListStr = JsonUtil.obj2StringPretty(userList);
        List<User> userListObj = JsonUtil.string2Obj(userListStr, new TypeReference<List<User>>() {});
        List<User> userListObj2 = JsonUtil.string2Obj(userListStr,List.class,User.class);

        System.out.println("end");
     }
}
