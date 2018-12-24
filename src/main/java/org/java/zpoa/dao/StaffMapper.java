package org.java.zpoa.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;
import java.util.List;
@Mapper
public interface StaffMapper {

    //检查登录且返回员工信息
    Map<String,Object> staffLogin(Map<String,Object> m);

    //查询所有员工信息
    List<Map<String,Object>> findAllStaff();

    //添加员工
    void addStaff(Map<String,Object> m);

    //修改员工信息
    void updStaff(Map<String,Object> m);

    //删除员工信息
    void delStaff(String id);

    //所有员工状态
    List<Map<String,Object>> findAllStaffState();
}
