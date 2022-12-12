package com.example.nestdigitalbackendspringboot.dao;

import com.example.nestdigitalbackendspringboot.model.Adminemployee;
import org.springframework.data.repository.CrudRepository;

public interface AdminDao extends CrudRepository<Adminemployee,Integer> {
}
