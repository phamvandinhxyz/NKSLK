package com.example.demo.repository;

import com.example.demo.models.DanhMucCongViec;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DanhMucCongViecRepository extends JpaRepository<DanhMucCongViec,String> {

    @Query(value = "{CALL luongSanPhamCaoNhat()}", nativeQuery = true)
    Object luongSanPhamCaoNhat();

    @Query(value = "{CALL luongSanPhamThapNhat()}", nativeQuery = true)
    Object luongSanPhamThapNhat();

    @Query(value = "{CALL Luong_Cong_Nhan_Trong_Nam(:year)}", nativeQuery = true)
    List<Object> luongCongNhanTrongNam(@Param("year") Integer year);
}
