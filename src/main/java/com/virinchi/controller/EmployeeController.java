package com.virinchi.controller;

import com.virinchi.model.Employee;
import com.virinchi.repository.EmployeeRepo;
import com.virinchi.service.EmployeeService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
private EmployeeRepo employeeRepo;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/addEmp")
    public String addEmp(Model m) {
        List<Employee> empList= employeeRepo.findAll();

m.addAttribute("empList", empList);
        return "emp";
    }


    @PostMapping("/addEmp")
    public String postAdd(HttpServletRequest request, Model m )
    {
        String empName = request.getParameter("empName");
        String empAddress= request.getParameter("empAddress");
        String empPhone1= request.getParameter("empPhone1");
        String empPhone2= request.getParameter("empPhone2");
        String empDept1= request.getParameter("empDept1");
        String empDept2= request.getParameter("empDept2");

        System.out.println(empName+empAddress+empPhone1+empPhone2+empDept1+empDept2);

       employeeService.empAdd(empName,empAddress,empPhone1,empPhone2,empDept1,empDept2);

        List<Employee> empList= employeeRepo.findAll();

        m.addAttribute("empList", empList);

        return "emp";
    }
}
