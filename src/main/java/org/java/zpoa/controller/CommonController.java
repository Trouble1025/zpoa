package org.java.zpoa.controller;

import org.java.zpoa.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("common")
public class CommonController {

    @Autowired
    DeptService deptService;

    //打开字段管理页面
    @RequestMapping("openFieldManage")
    public String openFieldManage(Map m) {
        m.put("deptList",deptService.allDepartment());
        return "/fieldManage";
    }
}
