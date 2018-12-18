package org.java.zpoa.service;

import java.util.List;
import java.util.Map;

public interface StaffService {

    //员工登录
    Map<String,Object> staffLogin(Map<String,Object> m);

    //查询所有员工信息
    String findAllStaff();

    //添加员工
    void addStaff(Map<String,Object> m);

    //修改员工信息
    void updStaff(Map<String,Object> m);

    //删除员工信息
    void delStaff(String id);

}
