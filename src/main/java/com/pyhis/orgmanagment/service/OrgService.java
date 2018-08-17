package com.pyhis.orgmanagment.service;

import com.pyhis.orgmanagment.entity.Org;

//todo 这里是否要重新定义dto  来对应前端  entity对应表数据
public interface OrgService {

    Org create(Org org);

    Optional<Org> findOrgById(String id);
}
