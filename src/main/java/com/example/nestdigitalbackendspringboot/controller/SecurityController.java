package com.example.nestdigitalbackendspringboot.controller;

import com.example.nestdigitalbackendspringboot.dao.AdminDao;
import com.example.nestdigitalbackendspringboot.dao.SecurityDao;
import com.example.nestdigitalbackendspringboot.model.Adminemployee;
import com.example.nestdigitalbackendspringboot.model.Security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

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
    @CrossOrigin(origins = "*")
    @GetMapping("/viewsecurity")
    public List<Security> ViewSecurity(){
        return (List<Security>) dao1.findAll();
    }
    @CrossOrigin(origins = "*")
    @PostMapping(path ="/searchsecurity",consumes = "application/json",produces = "application/json")
    public List<Security> SearchSecurity(@RequestBody Security ss){
        return (List<Security>) dao1.Searchsecurity(ss.getSecuritycode());
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/deletesecurity",consumes = "application/json",produces = "application/json")
    public HashMap<String,String> DeleteSecurity(@RequestBody Security sd)
    {
        String id=String.valueOf(sd.getId());
        System.out.println(id);
        dao1.deletesecurity(sd.getId());
        HashMap<String,String> map=new HashMap<>();
        map.put("status","success");
        return map;
    }

}
