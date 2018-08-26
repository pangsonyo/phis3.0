package com.pyhis.orgmanagment.controller;

import com.pyhis.orgmanagment.VO.ResultVO;
import com.pyhis.orgmanagment.config.RedisService;
import com.pyhis.orgmanagment.entity.Org;
import com.pyhis.orgmanagment.entity.User;
import com.pyhis.orgmanagment.service.OrgService;
import com.pyhis.orgmanagment.utils.CookieUtil;
import com.pyhis.orgmanagment.utils.ResultVOUtil;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
@Log4j2
public class OrgController {

    @Autowired
    OrgService orgService;

    @Autowired
    RedisService redisService;


    @PostMapping("/createOrg")
    public ResultVO<Org> createOrg(Org org) {
        Org resultOrg = orgService.create(org);
        return ResultVOUtil.success(resultOrg);
    }

    //http://localhost:8080/getOrg?id=01
    @GetMapping("/getOrg")
    public ResultVO<Org> getOrg(@RequestParam String id) {
        Optional<Org> org = orgService.findOrgById(id);
        log.info(org);
        return ResultVOUtil.success(org);
    }

    @GetMapping("test")
    public ResultVO<Org> test(String id) {
        Optional<Org> org = orgService.findOrgById(id);

        return ResultVOUtil.success(org);

    }

}
