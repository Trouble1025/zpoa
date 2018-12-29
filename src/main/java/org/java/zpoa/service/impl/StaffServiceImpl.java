package org.java.zpoa.service.impl;

import org.java.zpoa.dao.StaffMapper;
import org.java.zpoa.service.StaffService;
import org.java.zpoa.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StaffServiceImpl implements StaffService {

    @Autowired
    StaffMapper staffMapper;

    @Override
    public Map<String, Object> staffLogin(Map<String, Object> m) {
        return staffMapper.staffLogin(m);
    }

    @Override
    public String findAllStaff(Map m) {
        if (m.get("page") != null)
            m.put("page", (Integer.parseInt(m.get("page").toString()) - 1) * Integer.parseInt(m.get("limit").toString()));
        Map<String, Object> json = new HashMap();
        List<Map<String, Object>> data = staffMapper.findAllStaff(m);
        json.put("code", 0);
        json.put("msg", "");
        json.put("count", allStaffCount(m));
        json.put("data", data);
        return JsonUtils.objectToJson(json);
    }

    @Override
    public Integer allStaffCount(Map m) {
        return staffMapper.allStaffCount(m);
    }

    @Override
    public void addStaff(Map<String, Object> m) {
        staffMapper.addStaff(m);
        staffMapper.addStaffRole(m);
    }

    @Override
    public void updStaff(Map<String, Object> m) {

    }

    @Override
    public void delStaff(String id) {

    }

    @Override
    public List<Map<String, Object>> findAllStaffState() {
        return staffMapper.findAllStaffState();
    }

    @Override
    public void addStaffRole(Map<String, Object> m) {
        staffMapper.addStaffRole(m);
    }

}
