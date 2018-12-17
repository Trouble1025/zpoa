package org.java.zpoa.service.impl;

import org.java.zpoa.dao.StaffMapper;
import org.java.zpoa.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StaffServiceImpl implements StaffService {

    @Autowired
    StaffMapper staffMapper;

    @Override
    public Map<String,Object> staffLogin(Map<String, Object> m) {
        return staffMapper.staffLogin(m);
    }

    @Override
    public List<Map<String, Object>> findAllStaff() {
        return staffMapper.findAllStaff();
    }

    @Override
    public void addStaff(Map<String, Object> m) {
        staffMapper.addStaff(m);
    }

    @Override
    public void updStaff(Map<String, Object> m) {

    }

    @Override
    public void delStaff(String id) {

    }

}
