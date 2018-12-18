package org.java.zpoa.service;

import java.util.List;
import java.util.Map;

public interface DeptService {
    //获取所有部门信息
    List<Map<String,Object>> allDepartment();

    //根据部门Id获取所有职位
    List<Map<String,Object>> allPostByDeptId(String id);

    //根据部门Id修改部门名称
    void updDeptNameById(Map<String,Object> map);

    //新增一个部门
    void addNewDept(Map<String,Object> map);
}
