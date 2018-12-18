package org.java.zpoa.controller;

import org.java.zpoa.service.DeptService;
import org.java.zpoa.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    StaffService staffService;

    @Autowired
    DeptService deptService;

    //打开员工信息列表
    @RequestMapping("staffTable")
    public String staffTable(){ return "staffTable"; }

    //打开主页面
    @RequestMapping("main")
    public String index(){ return "/main"; }

    @RequestMapping("openAddStaff")
    public String openAddStaff(Map<String,Object> m){
        m.put("deptList",deptService.allDepartment());
        return "addStaff";}

    @RequestMapping("showAllStaff")
    @ResponseBody
    public Object showAllStaff(){
        return staffService.findAllStaff();
    }

    @RequestMapping("addStaff")
    public String addStaff(@RequestParam Map staff){
        staffService.addStaff(staff);
        return "staffTable";
    }

}
