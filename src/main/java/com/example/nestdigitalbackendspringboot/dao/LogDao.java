package com.example.nestdigitalbackendspringboot.dao;

import com.example.nestdigitalbackendspringboot.model.Log;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface LogDao extends CrudRepository<Log,Integer> {

    @Query(value = "SELECT `id`, `date`, `emp_id`, `enter_date_time`, `exit_date_time` FROM `emp_log` WHERE `date` =:date",nativeQuery = true)
    List<Log> viewDailyEmployeeLog(@Param("date")String date);


//    @Modifying
//    @Query(value = "UPDATE `log` SET `check_out`=:check_out,`out_date`=:out_date WHERE `empcode`=:empcode",nativeQuery = true)
//    void logOutStatus(@Param("check_out") String check_out,@Param("out_date") String out_date,@Param("empcode") Integer empcode);
//
//    @Query(value = "SELECT l.`id`, l.`check_in`, l.`check_out`, l.`empcode`, l.`in_date`, l.`out_date`,e.empname,e.designation FROM `log` l JOIN employee e ON l.empcode=e.empcode",nativeQuery = true)
//    List<Map<String,String>> viewAllLogBy();
//
//    @Query(value = "SELECT l.`id`, l.`check_in`, l.`check_out`, l.`empcode`, l.`in_date`, l.`out_date`,e.empname FROM `log` l JOIN employee e ON l.empcode=e.empcode WHERE l.empcode=e.empcode",nativeQuery = true)
//    List<Map<String,String>> viewlogByEmpid(@Param("empcode") Integer empcode);
}
