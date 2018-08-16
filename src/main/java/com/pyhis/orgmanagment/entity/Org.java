package com.pyhis.orgmanagment.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "sys_org")
public class Org {

    @Id
    private String orgId;

    private String orgCode;

    private String orgName;

    private String orgOwner;

    private String orgAddr;

    @Column(name="org_createtime")
    private Date orgCreateTime;

    @Column(name="org_updatetime")
    private Date orgUpdateTime;

    @Column(name="org_isuse")
    private Integer orgIsUse;

    @Override
    public String toString() {
        return "Org{" +
                "orgId='" + orgId + '\'' +
                ", orgCode='" + orgCode + '\'' +
                ", orgName='" + orgName + '\'' +
                ", orgOwner='" + orgOwner + '\'' +
                ", orgAddr='" + orgAddr + '\'' +
                ", orgCreateTime=" + orgCreateTime +
                ", orgUpdateTime=" + orgUpdateTime +
                ", orgIsUse=" + orgIsUse +
                '}';
    }
}
