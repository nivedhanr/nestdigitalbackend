package com.example.nestdigitalbackendspringboot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="employee")
public class Adminemployee {
    @Id
    @GeneratedValue
    private int id;
    private int empcode;
    private String empname;
    private String designation;
    private String salary;
    private String address;
    private String phnno;
    private String email;
    private String username;
    private String password;
    private String comfirmpass;

    public Adminemployee() {
    }

    public Adminemployee(int id, int empcode, String empname, String designation, String salary, String address, String phnno, String email, String username, String password, String comfirmpass) {
        this.id = id;
        this.empcode = empcode;
        this.empname = empname;
        this.designation = designation;
        this.salary = salary;
        this.address = address;
        this.phnno = phnno;
        this.email = email;
        this.username = username;
        this.password = password;
        this.comfirmpass = comfirmpass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmpcode() {
        return empcode;
    }

    public void setEmpcode(int empcode) {
        this.empcode = empcode;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhnno() {
        return phnno;
    }

    public void setPhnno(String phnno) {
        this.phnno = phnno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getComfirmpass() {
        return comfirmpass;
    }

    public void setComfirmpass(String comfirmpass) {
        this.comfirmpass = comfirmpass;
    }
}
