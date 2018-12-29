package org.java.zpoa.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface OverTimeMapper {

    void addOverTime(Map m);

    List<Map<String,Object>> findHasPowerRole(Map m);

    List<Map<String,Object>> findOverTimeByStaffId(Map m);

    Integer overTimeCount(Map m);

    List<Map<String,Object>> findNeedApprovalById(Map m);

    Integer needApprovalCount(Map m);

    Integer isLastPower(Map m);
}
