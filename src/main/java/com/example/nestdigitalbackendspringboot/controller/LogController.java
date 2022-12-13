package com.example.nestdigitalbackendspringboot.controller;

import com.example.nestdigitalbackendspringboot.dao.LogDao;
import com.example.nestdigitalbackendspringboot.model.Log;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@RestController
public class LogController {
    @Autowired
    private LogDao dao3;
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addlog",consumes = "application/json",produces = "application/json")
    public String addLog(@RequestBody Log l){
        DateTimeFormatter dt=DateTimeFormatter.ofPattern("dd:MM:yyyy HH:mm:ss");
        LocalDateTime now=LocalDateTime.now();
        String currentdate=String.valueOf(dt.format(now));
        l.setInDate(currentdate);
//      l.setCheckOut(String.valueOf(0));
        dao3.save(l);
        return "{status:'success'}";
    }
    @CrossOrigin(origins = "*")
    @Transactional
    @PostMapping(path = "/loglogout",consumes = "application/json",produces = "application/json")
    public String logOutStatus(@RequestBody Log l){
        DateTimeFormatter dt=DateTimeFormatter.ofPattern("dd:MM:yyyy HH:mm:ss");
        LocalDateTime now=LocalDateTime.now();
        String currentdate=String.valueOf(dt.format(now));
        l.setOutDate(currentdate);
        dao3.logOutStatus(l.getCheckOut(),l.getOutDate(),l.getEmpcode());
        return "{status:success}";
    }
    @CrossOrigin(origins = "*")
    @GetMapping(path = "/viewalllogs",consumes = "application/json",produces = "application/json")
    public List<Map<String,String>> viewAllLog(){
        return (List<Map<String, String>>) dao3.viewAllLogBy();
    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/viewlogbyid",consumes = "application/json",produces = "application/json")
    public List<Map<String,String>> viewLogByEmp(@RequestBody Log l){
        return (List<Map<String, String>>) dao3.viewlogByEmpid(l.getEmpcode());
    }


}
