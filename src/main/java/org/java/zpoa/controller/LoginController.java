package org.java.zpoa.controller;

import org.java.zpoa.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    StaffService staffService;

    @RequestMapping("logincheck")
    public String login(@RequestParam Map<String,Object> m, HttpServletRequest req){
        Map<String, Object> staff = staffService.staffLogin(m);
        if(staff == null)
            return "err";
        req.getSession().setAttribute("account",staff);
        return "true";
    }

}
