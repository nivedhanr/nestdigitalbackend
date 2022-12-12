package com.example.nestdigitalbackendspringboot.controller;

import com.example.nestdigitalbackendspringboot.dao.AdminDao;
import com.example.nestdigitalbackendspringboot.model.Adminemployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
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

}
