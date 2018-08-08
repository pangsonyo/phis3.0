package com.pyhis.orgmanagment.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name="sys_personinfo")
public class Person {
    @Id
    private String personId;

    private String idcardNo;

    private String personName;

    private String phoneNum;

    private String orgCode;

    private int gender;

    //是否注销
    private int isLogoff;

    private Date createTime;

    private Date updateTime;



}
