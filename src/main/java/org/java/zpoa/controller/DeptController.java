package org.java.zpoa.controller;

import org.java.zpoa.service.DeptService;
import org.java.zpoa.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    DeptService deptService;

    @RequestMapping("allPostByDeptId")
    public Object allPostByDeptId(@RequestParam String id){
        return JsonUtils.objectToJson(deptService.allPostByDeptId(id));
    }

    @RequestMapping("updDeptName")
    public Object updDeptName(@RequestParam Map map){
        deptService.updDeptNameById(map);
        return JsonUtils.objectToJson(deptService.allDepartment());
    }

    @RequestMapping("addNewDept")
    public Object addDeptName(@RequestParam Map map){
        deptService.addNewDept(map);
        return JsonUtils.objectToJson(deptService.allDepartment());
    }

    @RequestMapping("updPostName")
    public Object updPostName(@RequestParam Map map){
        deptService.updPostNameById(map);
        return JsonUtils.objectToJson(deptService.allPostByDeptId(map.get("deptId").toString()));
    }

    @RequestMapping("addNewPost")
    public Object addNewPost(@RequestParam Map map){
        deptService.addNewPost(map);
        return JsonUtils.objectToJson(deptService.allPostByDeptId(map.get("deptId").toString()));
    }
}
