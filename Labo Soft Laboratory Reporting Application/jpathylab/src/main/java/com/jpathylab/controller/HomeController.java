package com.jpathylab.controller;
import com.jpathylab.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private UserRepository userRepo;

    @GetMapping("/admin/home")
    public String getAdminHome(){
        return "admin/admin_home";
    }

    @GetMapping("/user/home")
    public String getUserHome(){
        return "user/user_home";
    }
}
