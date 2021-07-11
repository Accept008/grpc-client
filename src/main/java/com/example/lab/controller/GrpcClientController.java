package com.example.lab.controller;

import com.example.lab.service.OptCasbinService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class GrpcClientController {

    @Resource
    private OptCasbinService optCasbinService;

    @RequestMapping("/getAllSubjects")
    public Object getAllSubjects() {
        System.out.println("--**--client response--**--");
        return optCasbinService.getAllSubjects();
    }

    @RequestMapping("/getPolicy")
    public Object getPolicy() {
        System.out.println("--**--client response--**--");
        return optCasbinService.getPolicy();
    }

    /**
     * 是否存在命名授权规则
     * hasNamedPolicy := e.HasNamedPolicy("p", "data2_admin", "data2", "read")
     */

    public Object hasNamedPolicy(){
        System.out.println("--**--client response--**--");
        return optCasbinService.hasNamedPolicy();
    }

    @RequestMapping("/enforce")
    public Object enforce(){
        System.out.println("--**--client response enforce--**--");
        return optCasbinService.enforce();
    }
}
