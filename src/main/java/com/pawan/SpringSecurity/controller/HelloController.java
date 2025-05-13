package com.pawan.SpringSecurity.controller;

import com.pawan.SpringSecurity.model.Employees;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloController {

    private List<Employees> employees = new ArrayList<>(List.of(
       new Employees(1, "Pawan", 50000),
       new Employees(2, "Pulkit", 700000)
    ));

    @GetMapping("/")
    public String greet(HttpServletRequest request) {
        return "Welcome to my website." + request.getSession().getId();
    }

    @GetMapping("/csrf")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @GetMapping("/employees")
    public List<Employees> getEmployees() {
        return employees;
    }

    @PostMapping("/employees")
    public Employees addEmployee(@RequestBody Employees employee) {
        employees.add(employee);
        return employee;
    }
}
