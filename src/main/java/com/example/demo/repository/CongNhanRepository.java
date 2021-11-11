package com.example.demo.repository;

import com.example.demo.models.CongNhan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CongNhanRepository extends JpaRepository<CongNhan, String> {
    Page<CongNhan> findAll(Pageable pageable);

    @Query(value = "{CALL Get_Work_Day_Employee()}", nativeQuery = true)
    List<Object> getWorkDayEmployee();

    @Query(value = "{CALL So_Luong_Cong_Nhan_Lam_Rieng()}", nativeQuery = true)
    Object soLuongCongNhanLamRieng();

    @Query(value = "{CALL So_Luong_Cong_Nhan_Lam_Chung()}", nativeQuery = true)
    Object soLuongCongNhanLamChung();

    List<CongNhan> findCongNhanBymaDanhMucCongNhan(String maDanhMucCongNhan);
}
