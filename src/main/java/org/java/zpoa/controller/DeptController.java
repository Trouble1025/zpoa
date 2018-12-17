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
}
