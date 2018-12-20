package org.java.zpoa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/leave")
public class LeaveController {
    @RequestMapping("openLeave")
    public String openLeave(){return "/staff/leave";}
}
