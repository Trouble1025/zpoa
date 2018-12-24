package org.java.zpoa.service.impl;

import org.java.zpoa.dao.SuperMapper;
import org.java.zpoa.service.SuperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
