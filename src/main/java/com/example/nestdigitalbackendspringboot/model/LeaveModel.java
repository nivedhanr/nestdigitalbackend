package com.example.nestdigitalbackendspringboot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="leave1")
public class LeaveModel {
    @Id
    @GeneratedValue
    private int id;
    private int empcode;
    private String leavetype;
    private String discrip;
    private String applyDate;
    private String leaveDate;
    private int status;

    public LeaveModel() {
    }

    public LeaveModel(int id, int empcode, String leavetype, String discrip, String applyDate, String leaveDate, int status) {
        this.id = id;
        this.empcode = empcode;
        this.leavetype = leavetype;
        this.discrip = discrip;
        this.applyDate = applyDate;
        this.leaveDate = leaveDate;
        this.status = status;
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

    public String getLeavetype() {
        return leavetype;
    }

    public void setLeavetype(String leavetype) {
        this.leavetype = leavetype;
    }

    public String getDiscrip() {
        return discrip;
    }

    public void setDiscrip(String discrip) {
        this.discrip = discrip;
    }

    public String getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(String applyDate) {
        this.applyDate = applyDate;
    }

    public String getLeaveDate() {
        return leaveDate;
    }

    public void setLeaveDate(String leaveDate) {
        this.leaveDate = leaveDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
