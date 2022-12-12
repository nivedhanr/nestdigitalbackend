package com.example.nestdigitalbackendspringboot.controller;

import com.example.nestdigitalbackendspringboot.dao.AdminDao;
import com.example.nestdigitalbackendspringboot.model.Adminemployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AdminController {
    @Autowired
    private AdminDao dao;
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addemployee",consumes = "application/json",produces = "application/json")
    public HashMap<String,String> Addemployee(@RequestBody Adminemployee a){

        dao.save(a);
        HashMap<String,String> map=new HashMap<>();
        map.put("status","success");
        return map;
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/viewemp")
    public List<Adminemployee> ViewEmployee(){
        return (List<Adminemployee>) dao.findAll();
    }
    @CrossOrigin(origins = "*")
    @PostMapping(path ="/search",consumes = "application/json",produces = "application/json")
    public List<Adminemployee> SearchEmp(@RequestBody Adminemployee p){
        return (List<Adminemployee>) dao.SearchEmployee(p.getEmpcode());
    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/delete",consumes = "application/json",produces = "application/json")
    public HashMap<String,String> Delete(@RequestBody Adminemployee d)
    {
        String id=String.valueOf(d.getEmpcode());
        System.out.println(id);
        dao.delete(d.getEmpcode());
        HashMap<String,String> map=new HashMap<>();
        map.put("status","success");
        return map;
    }
}
