package com.virinchi.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmployeeController {

    @GetMapping("/addEmp")
    public String addEmp() {
        return "emp";
    }


    @PostMapping("/addEmp")
    public String postAdd(HttpServletRequest request)
    {
        String empName = request.getParameter("empName");
        String empAddress= request.getParameter("empAddress");
        String empPhone1= request.getParameter("empPhone1");
        String empPhone2= request.getParameter("empPhone2");
        String empDept1= request.getParameter("empDept1");
        String empDept2= request.getParameter("empDept2");

        System.out.println(empName+empAddress+empPhone1+empPhone2+empDept1+empDept2);

        return "emp";
    }
}
