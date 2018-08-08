package com.pyhis.orgmanagment.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name="sys_userinfo")
public class User {
    @Id
    private String userId;

    private String userName;

    private String password;

    //医疗等级
    private String medicalLevel;

    private Date createTime;

    private Date updateTime;

}
