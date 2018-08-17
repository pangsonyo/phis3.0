package com.pyhis.orgmanagment.service.impl;

import com.pyhis.orgmanagment.service.OrgService;
import com.pyhis.orgmanagment.entity.Org;
import com.pyhis.orgmanagment.repository.OrgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrgServiceImpl implements OrgService {

    @Autowired
    private OrgRepository orgRepository;


    @Override
    public Org create(Org org) {
        Org result = orgRepository.save(org);
        return result;

    }

    /**
     * Jpa 有两个根据id的查询方法,直接调用repository的getOne 会延迟加载,返回代理对象,使用findById 返回Optional ,真实对象.
     * @param id
     * @return
     */
    @Override
    public Optional<Org> findOrgById(String id) {
        return orgRepository.findById(id);
    }

}
