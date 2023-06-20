package com.example.buituananh.controller;

import com.example.buituananh.entities.Employee;
import com.example.buituananh.entities.dtos.EmployeeDto;
import com.example.buituananh.services.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("")
@Slf4j
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping("")
    public String getList() {
        return "/index";
    }

    @GetMapping("list")
    public String getList(Model model) {
        List<Employee> employeeDtos = employeeService.findAll();
        model.addAttribute("employeeDtos", employeeDtos);
        return "/list";
    }

    @GetMapping("create")
    public String createProcess(Model model) {
        EmployeeDto employeeDto = new EmployeeDto();
        model.addAttribute("employeeDto", employeeDto);
        return "/create";
    }

    @PostMapping("create/employee")
    public String create(@Valid @ModelAttribute EmployeeDto employeeDto,
                         Model model) {
        employeeService.create(employeeDto);
        model.addAttribute("success", "Create success!");
        return "redirect:/list";
    }
}
