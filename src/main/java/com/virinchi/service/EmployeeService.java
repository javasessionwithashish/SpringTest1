package com.virinchi.service;

import com.virinchi.model.Address;
import com.virinchi.model.Department;
import com.virinchi.model.Employee;
import com.virinchi.model.Phone;
import com.virinchi.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class EmployeeService {

@Autowired
private EmployeeRepo employeeRepo;

    public void empAdd(String empName,String empAddress,String empPhone1,String empPhone2,String empDept1,String empDept2)
    {
        Employee emp= new Employee();
        emp.setName(empName);

        Address adr= new Address();
        adr.setState(empAddress);
        emp.setAddress(adr);

        Phone p1= new Phone();
        p1.setNumber(empPhone1);
p1.setEmployee(emp);

        Phone p2= new Phone();
        p2.setNumber(empPhone2);
p2.setEmployee(emp);

        emp.setPhoneList(Arrays.asList(p1,p2));

        Department dept1= new Department();
        dept1.setDeptName(empDept1);

        Department dept2= new Department();
        dept2.setDeptName(empDept2);
        emp.setDeptList(Arrays.asList(dept1,dept2));

employeeRepo.save(emp);


    }
}
