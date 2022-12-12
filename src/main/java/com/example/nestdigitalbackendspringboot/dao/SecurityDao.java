package com.example.nestdigitalbackendspringboot.dao;

import com.example.nestdigitalbackendspringboot.model.Adminemployee;
import com.example.nestdigitalbackendspringboot.model.Security;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SecurityDao extends CrudRepository<Security,Integer> {
    @Modifying
    @Transactional
    @Query(value = "SELECT `id`, `address`, `comfirmpass`, `email`, `name`, `password`, `phnno`, `salary`, `securitycode`, `username` FROM `security` WHERE `securitycode`=:securitycode",nativeQuery = true)
    List<Security> Searchsecurity(@Param("securitycode")Integer securitycode);
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM `security` WHERE `id`=:id",nativeQuery = true)
    void deletesecurity(@Param("id") Integer id);
}
