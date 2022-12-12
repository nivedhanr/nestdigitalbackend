package com.example.nestdigitalbackendspringboot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="security")
public class Security {
    @Id
    @GeneratedValue
    private int id;
    private int securitycode;
    private String name;
    private String salary;
    private String address;
    private String phnno;
    private String email;
    private String username;
    private String password;
    private String comfirmpass;

    public Security() {
    }

    public Security(int id, int securitycode, String name, String salary, String address, String phnno, String email, String username, String password, String comfirmpass) {
        this.id = id;
        this.securitycode = securitycode;
        this.name = name;
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

    public int getSecuritycode() {
        return securitycode;
    }

    public void setSecuritycode(int securitycode) {
        this.securitycode = securitycode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
