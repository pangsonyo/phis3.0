package com.pyhis.orgmanagment.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


@Data
@Entity
@Table(name="sys_roleInfo")
public class Role {

    @Id
    private String roleId;

    private String roleName;

    private Date createTime;

    private Date updateTime;


}
