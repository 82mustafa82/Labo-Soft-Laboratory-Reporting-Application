package com.jpathylab.controller;
import com.jpathylab.exception.UserNotFoundException;
import com.jpathylab.model.Laborant;
import com.jpathylab.model.User;
import com.jpathylab.service.LaborantService;
import com.jpathylab.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService service;
    @Autowired
    private LaborantService laborantSer;

    @GetMapping("/admin/users")
    public String showUserList(Model model){
        List<User> listUsers = service.listAll();
        model.addAttribute("listUsers", listUsers);
        return "admin/users";
    }

    @GetMapping("/admin/users/new")
    public String showNewForm(Model model){
        List<Laborant> listLaborants = laborantSer.listAll();
        model.addAttribute("User", new User());
        model.addAttribute("listLaborants", listLaborants);
        model.addAttribute("pageTitle", "Add New User");
        return "admin/user_form";
    }

    @PostMapping("/admin/users/save")
    public String saveUser(User user, RedirectAttributes ra){
        service.save(user);
        ra.addFlashAttribute("message", "The user has been saved successfully.");
        return "redirect:/admin/users";
    }

    @GetMapping("/admin/users/edit/{uid}")
    public String showEditForm(@PathVariable("uid") Integer uid, Model model, RedirectAttributes ra){
        try {
            User user = service.get(uid);
            List<Laborant> listLaborants = laborantSer.listAll();
            model.addAttribute("User", user);
            model.addAttribute("listLaborants", listLaborants);
            model.addAttribute("pageTitle", "Edit User (ID: " + uid + ")");
            return "admin/user_form";
        } catch (UserNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/admin/users";
        }
    }

    @GetMapping("/admin/users/delete/{uid}")
    public String deleteUser(@PathVariable("uid") Integer uid, RedirectAttributes ra){
        try {
            service.delete(uid);
            ra.addFlashAttribute("message", "The User ID " + uid + " has been deleted.");
        } catch (UserNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/admin/users";
    }
}
