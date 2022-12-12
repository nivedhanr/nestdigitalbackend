package com.example.nestdigitalbackendspringboot.dao;

import com.example.nestdigitalbackendspringboot.model.Adminemployee;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AdminDao extends CrudRepository<Adminemployee,Integer> {
    @Query(value = "SELECT `id`, `address`, `comfirmpass`, `designation`, `email`, `empcode`, `empname`, `password`, `phnno`, `salary`, `username` FROM `employee` WHERE `empcode`=:empcode",nativeQuery = true)
    List<Adminemployee> SearchEmployee(@Param("empcode")Integer empcode);
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM `employee` WHERE `empcode`=:empcode",nativeQuery = true)
    void delete(@Param("empcode") Integer empcode);
}
