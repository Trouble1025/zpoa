package org.java.zpoa.service;

import java.util.List;
import java.util.Map;

public interface StaffService {

    //员工登录
    Map<String,Object> staffLogin(Map<String,Object> m);

    //查询所有员工信息
    String findAllStaff(Map m);

    //查询所有员工数量
    Integer allStaffCount(Map m);

    //添加员工
    void addStaff(Map<String,Object> m);

    //修改员工信息
    void updStaff(Map<String,Object> m);

    //删除员工信息
    void delStaff(String id);

    //所有员工状态
    List<Map<String,Object>> findAllStaffState();

    //新增员工-角色
    void addStaffRole(Map<String,Object> m);

}
