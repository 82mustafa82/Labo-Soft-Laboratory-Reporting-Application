package com.jpathylab.controller;
import com.jpathylab.exception.ReportNotFoundException;
import com.jpathylab.model.Laborant;
import com.jpathylab.model.Report;
import com.jpathylab.service.LaborantService;
import com.jpathylab.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;

@Controller
public class ReportController {
    @Autowired
    private ReportService service;
    @Autowired
    private LaborantService laborantSer;

    @GetMapping("/admin/admin_reports")
    public String showUserListOnAdmin(Model model){
        List<Report> listReports = service.listAll();
        model.addAttribute("listReports", listReports);
        return "admin/admin_reports";
    }

    @GetMapping("/user/user_reports")
    public String showUserListOnUser(Model model){
        List<Report> listReports = service.listAll();
        model.addAttribute("listReports", listReports);
        return "user/user_reports";
    }

    @GetMapping("/admin/admin_reports/new")
    public String showNewFormOnAdmin(Model model){
        List<Laborant> listLaborants = laborantSer.listAll();
        model.addAttribute("listLaborants", listLaborants);
        model.addAttribute("Report", new Report());
        model.addAttribute("pageTitle", "Add New Report");
        return "admin/admin_report_form";
    }

    @GetMapping("/user/user_reports/new")
    public String showNewFormOnUser(Model model){
        List<Laborant> listLaborants = laborantSer.listAll();
        model.addAttribute("listLaborants", listLaborants);
        model.addAttribute("Report", new Report());
        model.addAttribute("pageTitle", "Add New Report");
        return "user/user_report_form";
    }

    @PostMapping("/admin/admin_reports/save")
    public String saveReportOnAdmin(Report report, RedirectAttributes ra){
        service.save(report);
        ra.addFlashAttribute("message", "The report has been saved successfully.");
        return "redirect:/admin/admin_reports";
    }

    @PostMapping("/user/user_reports/save")
    public String saveReportOnUser(Report report, RedirectAttributes ra){
        service.save(report);
        ra.addFlashAttribute("message", "The report has been saved successfully.");
        return "redirect:/user/user_reports";
    }

    @GetMapping("/admin/admin_reports/edit/{rid}")
    public String showEditFormOnAdmin(@PathVariable("rid") Integer rid, Model model, RedirectAttributes ra){
        try {
            Report report = service.get(rid);
            List<Laborant> listLaborants = laborantSer.listAll();
            model.addAttribute("listLaborants", listLaborants);
            model.addAttribute("Report", report);
            model.addAttribute("pageTitle", "Edit Report (ID: " + rid + ")");
            return "admin/admin_report_form";
        } catch (ReportNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/admin/admin_reports";
        }
    }

    @GetMapping("/user/user_reports/edit/{rid}")
    public String showEditFormOnUser(@PathVariable("rid") Integer rid, Model model, RedirectAttributes ra){
        try {
            Report report = service.get(rid);
            List<Laborant> listLaborants = laborantSer.listAll();
            model.addAttribute("listLaborants", listLaborants);
            model.addAttribute("Report", report);
            model.addAttribute("pageTitle", "Edit Report (ID: " + rid + ")");
            return "user/user_report_form";
        } catch (ReportNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/user/user_reports";
        }
    }

    @GetMapping("/admin/reports/delete/{rid}")
    public String deleteReport(@PathVariable("rid") Integer rid, RedirectAttributes ra){
        try {
            service.delete(rid);
            ra.addFlashAttribute("message", "The report ID " + rid + " has been deleted.");
        } catch (ReportNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/admin/admin_reports";
    }
}
