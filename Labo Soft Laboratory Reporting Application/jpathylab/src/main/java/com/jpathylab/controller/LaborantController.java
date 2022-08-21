package com.jpathylab.controller;
import com.jpathylab.exception.LaborantNotFoundException;
import com.jpathylab.model.Laborant;
import com.jpathylab.service.LaborantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;

@Controller
public class LaborantController {
    @Autowired private LaborantService service;

    @GetMapping("/admin/laborants")
    public String showUserList(Model model){
        List<Laborant> listLaborants = service.listAll();
        model.addAttribute("listLaborants", listLaborants);
        return "admin/laborants";
    }

    @GetMapping("/admin/laborants/new")
    public String showNewForm(Model model){
        model.addAttribute("laborant", new Laborant());
        model.addAttribute("pageTitle", "Add New Laborant");
        return "admin/laborant_form";
    }

    @PostMapping("/admin/laborants/save")
    public String saveLaborant(Laborant laborant, RedirectAttributes ra){
        service.save(laborant);
        ra.addFlashAttribute("message", "The laborant has been saved successfully.");
        return "redirect:/admin/laborants";
    }

    @GetMapping("/admin/laborants/edit/{lid}")
    public String showEditForm(@PathVariable("lid") Integer lid, Model model, RedirectAttributes ra){
        try {
            Laborant laborant = service.get(lid);
            model.addAttribute("laborant", laborant);
            model.addAttribute("pageTitle", "Edit Laborant (ID: " + lid + ")");
            return "admin/laborant_form";
        } catch (LaborantNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/admin/laborants";
        }
    }

    @GetMapping("/admin/laborants/delete/{lid}")
    public String deleteLaborant(@PathVariable("lid") Integer lid, RedirectAttributes ra){
        try {
            service.delete(lid);
            ra.addFlashAttribute("message", "The laborant ID " + lid + " has been deleted.");
        } catch (LaborantNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/admin/laborants";
    }
}
