package com.example.demo.repository;

import com.example.demo.models.CongNhan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CongNhanRepository extends JpaRepository<CongNhan, String> {
    Page<CongNhan> findAll(Pageable pageable);

    @Query(value = "{CALL Get_Work_Day_Employee()}", nativeQuery = true)
    List<Object> getWorkDayEmployee();
}
