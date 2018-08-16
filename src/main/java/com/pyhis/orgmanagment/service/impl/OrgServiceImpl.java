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
    public void create(Org org) {
        orgRepository.save(org);
    }

    @Override
    public Org getById(String id) {
        return orgRepository.getOne(id);
    }
}
