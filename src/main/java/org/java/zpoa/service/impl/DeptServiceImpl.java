package org.java.zpoa.service.impl;

import org.java.zpoa.dao.DeptMapper;
import org.java.zpoa.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    DeptMapper deptMapper;

    @Override
    public List<Map<String, Object>> allDepartment() {
        return deptMapper.allDepartment();
    }

    @Override
    public List<Map<String, Object>> allPostByDeptId(String id) {
        return deptMapper.allPostByDeptId(id);
    }

    @Override
    public void updDeptNameById(Map<String, Object> map) {
        deptMapper.updDeptNameById(map);
    }

    @Override
    public void addNewDept(Map<String, Object> map) {
        deptMapper.addNewDept(map);
    }

    @Override
    public void updPostNameById(Map<String, Object> map) {
        deptMapper.updPostNameById(map);
    }

    @Override
    public void addNewPost(Map<String, Object> map) {
        deptMapper.addNewPost(map);
    }


}
