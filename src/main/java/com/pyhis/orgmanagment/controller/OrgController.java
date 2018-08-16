package com.pyhis.orgmanagment.controller;

import com.pyhis.orgmanagment.entity.Org;
import com.pyhis.orgmanagment.service.OrgService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Log4j2
public class OrgController {

    @Autowired
    private OrgService orgService;


    //todo 这里后期要封成一个Data<T>格式的
    @PostMapping("/createOrg")
    public void createOrg(Org org) {
        orgService.create(org);

    }


    //http://localhost:8080/getOrg?id=01
    @GetMapping("/getOrg")
    public void createOrg(@RequestParam String id) {
        Org org = orgService.getById(id);
        log.info(org);
    }


}
