package org.java.zpoa.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface DeptMapper {
    //获取所有部门信息
    List<Map<String,Object>> allDepartment();

    //根据部门Id获取所有职位
    List<Map<String,Object>> allPostByDeptId(String id);

    //根据部门Id修改部门名称
    void updDeptNameById(Map<String,Object> map);

    //新增一个部门
    void addNewDept(Map<String,Object> map);

    //根据岗位ID修改岗位名称
    void updPostNameById(Map<String,Object> map);

    //新增一个工作岗位
    void addNewPost(Map<String,Object> map);

}
