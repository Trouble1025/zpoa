package org.java.zpoa.service.impl;

import org.java.zpoa.dao.SuperMapper;
import org.java.zpoa.service.SuperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SuperServiceImpl implements SuperService {

    @Autowired
    SuperMapper superMapper;

    @Override
    public List<Map<String, Object>> findAllRole() {
        return superMapper.findAllRole();
    }

    @Override
    public List<Map<String, Object>> findAllPower() {
        return superMapper.findAllPower();
    }

    @Override
    public void updRoleName(Map<String, Object> map) {
        superMapper.updRoleName(map);
    }

    @Override
    public void addRoleName(String roleName) {
        superMapper.addRoleName(roleName);
    }

    @Override
    public void updStaffState(Map<String, Object> map) {
        superMapper.updStaffState(map);
    }

    @Override
    public void addStaffStateName(String stateName) {
        superMapper.addStaffStateName(stateName);
    }

    @Override
    public void updPowerName(Map<String, Object> map) {
        superMapper.updPowerName(map);
    }

    @Override
    public void addNewPower(String powerName) {
        superMapper.addNewPower(powerName);
    }

    @Override
    public List<Map<String, Object>> findPowerByRoleId(String roleId) {
        return superMapper.findPowerByRoleId(roleId);
    }

    @Override
    public void addRolePower(Map<String, Object> map) {
        delPowerByRoleId(map.get("roleId").toString());
        String [] powerList = map.get("powerList").toString().split(",");
        Map m = new HashMap<String,Object>();
        m.put("roleId",map.get("roleId"));
        for(int i = 0 ; i < powerList.length ; i++){
            m.put("powerId",powerList[i]);
            superMapper.addRolePower(m);
        }
    }

    @Override
    public void delPowerByRoleId(String roleId) {
        superMapper.delPowerByRoleId(roleId);
    }

    @Override
    public String getRoleNameById(String roleId) {
        return superMapper.getRoleNameById(roleId);
    }
}
