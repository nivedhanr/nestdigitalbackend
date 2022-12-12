package com.example.nestdigitalbackendspringboot.controller;

import com.example.nestdigitalbackendspringboot.dao.AdminDao;
import com.example.nestdigitalbackendspringboot.dao.SecurityDao;
import com.example.nestdigitalbackendspringboot.model.Adminemployee;
import com.example.nestdigitalbackendspringboot.model.Security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class SecurityController {
    @Autowired
    private SecurityDao dao1;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addsecurity",consumes = "application/json",produces = "application/json")
    public HashMap<String,String> Addsecurity(@RequestBody Security s){

        dao1.save(s);
        HashMap<String,String> map=new HashMap<>();
        map.put("id",String.valueOf(s.getId()));
        map.put("status","success");
        return map;
    }

}
