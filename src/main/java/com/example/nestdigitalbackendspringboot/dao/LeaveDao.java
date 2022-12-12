package com.example.nestdigitalbackendspringboot.dao;

import com.example.nestdigitalbackendspringboot.model.LeaveModel;
import org.springframework.data.repository.CrudRepository;

public interface LeaveDao extends CrudRepository<LeaveModel,Integer>{

}
