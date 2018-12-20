package org.java.zpoa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/overTime")
public class OverTimeController {
    @RequestMapping("openOverTime")
    public String openOverTime(){return "/staff/overTime";}
}
