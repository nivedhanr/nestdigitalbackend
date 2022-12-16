package com.example.nestdigitalbackendspringboot.controller;

import com.example.nestdigitalbackendspringboot.dao.LeaveDao;
import com.example.nestdigitalbackendspringboot.model.LeaveModel;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class LeaveController {
    @Autowired
    private LeaveDao dao2;
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addleave",consumes = "application/json",produces = "application/json")
    public  Map<String,String> addLeave(@RequestBody LeaveModel lm){
        DateTimeFormatter dt=DateTimeFormatter.ofPattern("dd:MM:yyyy HH:mm:ss");
        LocalDateTime now=LocalDateTime.now();
        String currentdate=String.valueOf((dt.format(now)));
        lm.setApplyDate(currentdate);
        dao2.save(lm);
        HashMap<String,String> map=new HashMap<>();
        map.put("status","success");
        return map;
    }

    @Transactional
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/updatestatus",consumes = "application/json",produces = "application/json")
    public Map<String,String> updateStatus(@RequestBody LeaveModel lm){
        dao2.updateById(lm.getStatus(),lm.getEmpId());
        HashMap<String,String> map=new HashMap<>();
        map.put("status","success");
        return map;
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/viewallleaves")
    public List<LeaveModel> viewallleaves(){
        return (List<LeaveModel>) dao2.findAll();

    }

//    @CrossOrigin(origins = "*")
//    @GetMapping("/viewallleaves")
//    public List<Map<String,String>> viewallleaves(){
//        return (List<Map<String,String>>) dao2.viewAllLeaveBy();
//
//    }
//    @CrossOrigin(origins = "*")
//    @PostMapping(path = "/viewleavesbyempcode",consumes = "application/json",produces = "application/json")
//    public  List<Map<String,String>> viewLeavesByCode(@RequestBody LeaveModel lm){
//        return (List<Map<String, String>>) dao2.viewLeaveByCode(lm.getEmpcode());
//    }
}
