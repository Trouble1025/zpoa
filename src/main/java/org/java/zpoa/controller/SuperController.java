package org.java.zpoa.controller;

import org.java.zpoa.service.DeptService;
import org.java.zpoa.service.StaffService;
import org.java.zpoa.service.SuperService;
import org.java.zpoa.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/super")
public class SuperController {

    @Autowired
    DeptService deptService;

    @Autowired
    SuperService superService;

    @Autowired
    StaffService staffService;

    //打开字段管理页面
    @RequestMapping("openFieldManage")
    public String openFieldManage(Map m) {
        m.put("deptList", deptService.allDepartment());
        m.put("roleList", superService.findAllRole());
        m.put("powerList", superService.findAllPower());
        m.put("staffStateList", staffService.findAllStaffState());
        return "/super/fieldManage";
    }

    //打开权限分配页面
    @RequestMapping("openPowerManage")
    public String openPowerManage(Map m) {
        m.put("roleList", superService.findAllRole());
        m.put("powerList", superService.findAllPower());
        return "/super/powerManage";
    }

    //更新角色名称
    @RequestMapping("updRoleName")
    @ResponseBody
    public Object updRoleName(@RequestParam Map<String, Object> map) {
        superService.updRoleName(map);
        return JsonUtils.objectToJson(superService.findAllRole());
    }

    //新增角色名称
    @RequestMapping("addRoleName")
    @ResponseBody
    public Object addRoleName(@RequestParam String roleName) {
        superService.addRoleName(roleName);
        return JsonUtils.objectToJson(superService.findAllRole());
    }

    //更新状态名称
    @RequestMapping("updStaffStateName")
    @ResponseBody
    public Object updStaffState(@RequestParam Map map) {
        superService.updStaffState(map);
        return JsonUtils.objectToJson(staffService.findAllStaffState());
    }

    //新增状态
    @RequestMapping("addStaffStateName")
    @ResponseBody
    public Object addStaffStateName(@RequestParam String stateName) {
        superService.addStaffStateName(stateName);
        return JsonUtils.objectToJson(staffService.findAllStaffState());
    }

    //修改操作权限
    @RequestMapping("updPowerName")
    @ResponseBody
    public Object updPowerName(@RequestParam Map<String, Object> map) {
        superService.updPowerName(map);
        return JsonUtils.objectToJson(superService.findAllPower());
    }

    //新增操作权限
    @RequestMapping("addPowerName")
    @ResponseBody
    public Object addNewPower(@RequestParam String powerName) {
        superService.addNewPower(powerName);
        return JsonUtils.objectToJson(superService.findAllPower());
    }

    //根据角色Id查操作权限
    @RequestMapping("findPowerByRoleId")
    @ResponseBody
    public Object findPowerByRoleId(@RequestParam String roleId){
        return JsonUtils.objectToJson(superService.findPowerByRoleId(roleId));
    }

    //为角色添加操作权限
    @RequestMapping("addPowerForRole")
    @ResponseBody
    public Object addPowerForRole(@RequestParam Map m){
        superService.addRolePower(m);
        return "";
    }
}
