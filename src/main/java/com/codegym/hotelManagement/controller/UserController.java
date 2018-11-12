package com.codegym.hotelManagement.controller;

import com.codegym.hotelManagement.Service.EmployeeService;
import com.codegym.hotelManagement.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/")
public class UserController {
    @Autowired
    EmployeeService employeeService;
    @GetMapping("/")
    public String index(Model model) {
        Iterable<Employee> employees = employeeService.findAll();
        model.addAttribute("employees", employees);
        return "index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("employee", new Employee());
        return "create";
    }

    @PostMapping("/create")
    public String save(Employee employee, RedirectAttributes redirect) {
        employeeService.save(employee);
        redirect.addAttribute("success", "New product added successfully!");
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("employee", employeeService.findById(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute Employee employee) {
        employeeService.save(employee);
        return "redirect:/";
    }

    
}
