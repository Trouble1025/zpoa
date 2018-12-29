package org.java.zpoa.service.impl;

import org.java.zpoa.dao.OverTimeMapper;
import org.java.zpoa.dao.SuperMapper;
import org.java.zpoa.service.OverTimeService;
import org.java.zpoa.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OverTimeServiceImpl implements OverTimeService {

    @Autowired
    OverTimeMapper overTimeMapper;

    @Autowired
    SuperMapper superMapper;

    @Override
    public Object addOverTime(Map m) {
        String overTimeState = "审核中"; //提交申请的状态
        String overTimeNeedPower = superMapper.getPowerIdByName("二级审核");  //需要的最终操作权限
        m.put("overTimeState", overTimeState);
        m.put("overTimeNeedPower", overTimeNeedPower);
        overTimeMapper.addOverTime(m);
        return JsonUtils.objectToJson(findOverTimeByStaffId(m));
    }

    @Override
    public Object findHasPowerRole(Map m) {
        //通过提交角色名称和部门id确定有本次审批权限的人
        String roleName = m.get("oa_role_name").toString();
        String deptId = m.get("oa_department_id").toString();
        String needPower = "";
        switch (roleName) {
            case "员工":
                needPower = "一级审核";
                break;
            case "组长/主管":
                needPower = "二级审核";
                break;
            case "部门经理":
                needPower = "三级审核";
                break;
            case "部门副总":
                break;
            default:
                break;
        }
        Map map = new HashMap<String, Object>();
        map.put("deptId", deptId);
        map.put("needPower", superMapper.getPowerIdByName(needPower));
        return JsonUtils.objectToJson(overTimeMapper.findHasPowerRole(map));
    }

    @Override
    public Object findOverTimeByStaffId(Map m) {
        if (m.get("page") != null && m.get("limit") != null)
            m.put("page", (Integer.parseInt(m.get("page").toString()) - 1) * Integer.parseInt(m.get("limit").toString()));
        List<Map<String, Object>> data = overTimeMapper.findOverTimeByStaffId(m);
        Map<String, Object> json = new HashMap();
        json.put("code", 0);
        json.put("msg", "");
        json.put("count", overTimeMapper.overTimeCount(m));
        json.put("data", data);
        return JsonUtils.objectToJson(json);
    }

    @Override
    public Object findNeedApprovalById(Map m) {
        if (m.get("page") != null && m.get("limit") != null)
            m.put("page", (Integer.parseInt(m.get("page").toString()) - 1) * Integer.parseInt(m.get("limit").toString()));
        List<Map<String, Object>> data = overTimeMapper.findNeedApprovalById(m);
        Map<String, Object> json = new HashMap();
        json.put("code", 0);
        json.put("msg","");
        json.put("count", overTimeMapper.needApprovalCount(m));
        json.put("data", data);
        return JsonUtils.objectToJson(json);
    }

    @Override
    public Boolean isLastPower(Map m) {
        return overTimeMapper.isLastPower(m) == 1;
    }

}
