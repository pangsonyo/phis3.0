package com.pyhis.orgmanagment.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="sys_user_role")
public class UserRole {

    @Id
    private String UserId;

    private String roleId;
}
