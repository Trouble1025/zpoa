package org.java.zpoa.service;

import java.util.List;
import java.util.Map;

public interface OverTimeService {
    //添加加班记录
    Object addOverTime(Map m);
    //找有权限的的角色
    Object findHasPowerRole(Map m);
    //通过用户ID找加班记录
    Object findOverTimeByStaffId(Map m);
    //通过员工ID找需要审批的流程
    Object findNeedApprovalById(Map m);
    //判断是否是最终审核
    Boolean isLastPower(Map m);
}
