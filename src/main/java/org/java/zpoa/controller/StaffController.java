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
    public String staffTable() {
        return "/staff/staffTable";
    }

    //打开主页面
    @RequestMapping("main")
    public String index() {
        return "/main";
    }

    //打开员工信息录入页面
    @RequestMapping("openAddStaff")
    public String openAddStaff(Map<String, Object> m) {
        m.put("deptList", deptService.allDepartment());
        return "/staff/addStaff";
    }

    //查询所有员工信息
    @RequestMapping("showAllStaff")
    @ResponseBody
    public Object showAllStaff() {
        return staffService.findAllStaff();
    }

    //新增一个员工
    @RequestMapping("addStaff")
    public String addStaff(@RequestParam Map staff) {
        staffService.addStaff(staff);
        return "/staff/staffTable";
    }

    //打开个人信息页面
    @RequestMapping("staffDetail")
    public String staffDetail() {
        return "/staff/staffDetail";
    }
}
