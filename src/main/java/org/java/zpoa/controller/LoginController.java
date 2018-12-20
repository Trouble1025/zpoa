package org.java.zpoa.controller;

import org.java.zpoa.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    StaffService staffService;

    //登录验证
    @RequestMapping("logincheck")
    public String login(@RequestParam Map<String,Object> m, HttpServletRequest req){
        Map<String, Object> staff = staffService.staffLogin(m);
        if(staff == null)
            return "err";
        req.getSession().setAttribute("account",staff);
        return "/main";
    }

    //退出登录
    @RequestMapping("logout")
    public String logout(HttpServletRequest req){
        req.getSession().setAttribute("account",null);
        return "/index";
    }

}
