package com.jpathylab.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    @RequestMapping(value = "/admin/login", method = RequestMethod.GET)
    public String getUserOnAdminLogin(){
        return "admin/admin_login";
    }

    @RequestMapping(value = "/user/login", method = RequestMethod.GET)
    public String getUserOnUserLogin(){
        return "user/user_login";
    }
}
