package org.java.zpoa.service;

import java.util.List;
import java.util.Map;

public interface SuperService {

    //找出所有角色
    List<Map<String,Object>> findAllRole();

    //找出所有权限
    List<Map<String,Object>> findAllPower();

    //根据ID修改角色名称
    void updRoleName(Map<String,Object> map);

    //新增角色
    void addRoleName(String roleName);

    //更新员工状态名称
    void updStaffState(Map<String,Object> map);

    //新增员工状态
    void addStaffStateName(String stateName);
}
