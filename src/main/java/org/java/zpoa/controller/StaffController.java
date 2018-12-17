package org.java.zpoa.controller;

import org.java.zpoa.service.DeptService;
import org.java.zpoa.service.StaffService;
import org.java.zpoa.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
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
        Map<String,Object> json = new HashMap<String,Object>();
        List<Map<String, Object>> data = staffService.findAllStaff();
        json.put("code",0);
        json.put("msg","");
        json.put("count",data.size());
        json.put("data",data);
        return JsonUtils.objectToJson(json);
    }

    @RequestMapping("addStaff")
    public String addStaff(@RequestParam Map staff){
        System.out.println(staff);
        staffService.addStaff(staff);
        return "staffTable";
    }

}
