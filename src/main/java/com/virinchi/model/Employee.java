package com.virinchi.model;

import jakarta.persistence.*;
import com.virinchi.model.Address;

import java.util.List;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

//We have to instantiate an object of Address Class
    //then, map its foreign key accordingly by
    //creating a new column inside Employee Class 'table'
@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name="addressId")
    private Address address;

@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
private List<Phone> phoneList;

@ManyToMany(cascade = CascadeType.ALL)
@JoinTable(name="empJoinsDept",joinColumns = @JoinColumn(name="emp_id"),inverseJoinColumns =@JoinColumn(name="dept_id") )
private List<Department> deptList;

    public List<Department> getDeptList() {
        return deptList;
    }

    public void setDeptList(List<Department> deptList) {
        this.deptList = deptList;
    }

    public List<Phone> getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(List<Phone> phoneList) {
        this.phoneList = phoneList;
    }



    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
