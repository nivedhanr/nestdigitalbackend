package com.example.nestdigitalbackendspringboot.dao;

import com.example.nestdigitalbackendspringboot.model.LeaveModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface LeaveDao extends CrudRepository<LeaveModel,Integer>{
    @Modifying
    @Transactional
    @Query(value = "UPDATE `leaves` SET `status`=:status WHERE `emp_id`=:emp_id",nativeQuery = true)
    void updateById(@Param("status") Integer status,@Param("emp_id") Integer emp_id);
//
    @Query(value = "SELECT e.`empcode`, e.`empname`,l.type,l.apply_date,l.from_date,l.to_date,l.status,l.remarks,l.emp_id FROM `employee` e JOIN leaves l ON e.id=l.emp_id",nativeQuery = true)
    List<Map<String,String>> viewAllLeaveBy();

//    @Query(value = "SELECT l.`id`, l.`apply_date`, l.`discrip`, l.`empcode`, l.`leave_date`, l.`leavetype`, l.`status`,e.`empname`,e.`designation` FROM `leave1` l JOIN employee e ON l.empcode=e.empcode WHERE l.empcode=e.empcode",nativeQuery = true)
//    List<Map<String,String>>viewLeaveByCode(Integer empcode);
}
