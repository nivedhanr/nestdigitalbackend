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
        map.put("id",String.valueOf(a.getId()));
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
        String id=String.valueOf(d.getId());
        System.out.println(id);
        dao.delete(d.getId());
        HashMap<String,String> map=new HashMap<>();
        map.put("status","success");
        return map;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/userlogin", consumes = "application/json", produces = "application/json")
    public HashMap<String, String> userLogin(@RequestBody Adminemployee r){
        System.out.println(r.getEmail());
        List<Adminemployee> result=(List<Adminemployee>) dao.userLogin(r.getEmail(),r.getPassword());
        HashMap<String,String> st=new HashMap<>();
        if (result.size()==0){
            st.put("status","failed");
            st.put("message","user doesn't exist");

        }
        else{
            int id =result.get(0).getId();
            st.put("userid",String.valueOf(id));
            st.put("message","user login success");
        }
        return st;
    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/viewprofile",consumes = "application/json",produces = "application/json")
    public List<Adminemployee> ViewProfile(@RequestBody Adminemployee v){
        return (List<Adminemployee>) dao.viewProfile(v.getId());
    }

}
