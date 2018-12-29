package org.java.zpoa.controller;

import org.java.zpoa.service.OverTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/overTime")
public class OverTimeController {

    @Autowired
    OverTimeService overTimeService;

    @RequestMapping("openOverTime")
    public String openOverTime() {
        return "/staff/overTime";
    }

    @RequestMapping("addOverTime")
    @ResponseBody
    public Object addOverTime(@RequestParam Map m, HttpSession session) {
        HashMap<String, Object> account = (HashMap<String, Object>) session.getAttribute("account");
        m.put("staffId", account.get("oa_staff_id"));
        return overTimeService.addOverTime(m);
    }


    @RequestMapping("findHasPowerRole")
    @ResponseBody
    public Object findHasPowerRole(HttpSession session) {
        HashMap<String, Object> account = (HashMap<String, Object>) session.getAttribute("account");
        return overTimeService.findHasPowerRole(account);
    }

    @RequestMapping("findOverTimeByStaffId")
    @ResponseBody
    public Object findOverTimeByStaffId(@RequestParam Map m, HttpSession session) {
        HashMap<String, Object> account = (HashMap<String, Object>) session.getAttribute("account");
        m.put("staffId", account.get("oa_staff_id").toString());
        return overTimeService.findOverTimeByStaffId(m);
    }

    //    >>>>>>>>>>>>>>>>>>>>>>>>>>加班审批>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    //打开加班审批的页面
    @RequestMapping("openApprovalOverTime")
    public String openApprovalOverTime() {
        return "/approval/ApprovalOverTime";
    }

    @RequestMapping("findNeedApprovalById")
    @ResponseBody
    public Object findNeedApprovalById(@RequestParam Map m, HttpSession session) {
        Map account = (Map) session.getAttribute("account");
        m.put("staffId", account.get("oa_staff_id").toString());
        m.put("roleId",account.get("oa_role_id").toString());
        Object data = overTimeService.findNeedApprovalById(m);
        System.out.println(data);
        return data;
    }

    @RequestMapping("isLastPower")
    @ResponseBody
    public Object isLastPower(HttpSession session,@RequestParam Map m){
        Map account = (Map) session.getAttribute("account");
        m.put("roleId",account.get("oa_role_id"));
        return overTimeService.isLastPower(m);
    }
}
