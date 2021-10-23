package com.example.demo.repository;

import com.example.demo.models.NKSLK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NKSLKRepository extends JpaRepository<NKSLK,String> {
    @Query(value = "{CALL NKSLK_In_Month_Employee(:month,:maCongNhan)}", nativeQuery = true)
    List<Object> NKSLKInMonthEmployee(@Param("month") Integer month,@Param("maCongNhan") String maCongNhan);

}
