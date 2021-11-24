package com.example.demo.repository;

import com.example.demo.models.DanhMucCongViec;
import com.example.demo.models.NKSLK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface DanhMucCongViecRepository extends JpaRepository<DanhMucCongViec,String> {

    @Query(value = "{CALL luongSanPhamCaoNhat()}", nativeQuery = true)
    Object luongSanPhamCaoNhat();

    @Query(value = "{CALL luongSanPhamThapNhat()}", nativeQuery = true)
    Object luongSanPhamThapNhat();

    @Query(value = "{CALL Luong_Cong_Nhan_Trong_Nam(:year)}", nativeQuery = true)
    List<Object> luongCongNhanTrongNam(@Param("year") Integer year);

    @Query(value = "{CALL bang_luong_san_pham_nam(:nam)}", nativeQuery = true)
    List<Object> bangLuongSanPhamNam(@Param("nam") LocalDate nam);

    @Query(value = "{CALL bang_luong_san_pham_thang(:thang)}", nativeQuery = true)
    List<Object> bangLuongSanPhamThang(@Param("thang") LocalDate thang);

    @Query(value = "{CALL bang_luong_san_pham_tuan(:tuan)}", nativeQuery = true)
    List<Object> bangLuongSanPhamTuan(@Param("tuan") LocalDate tuan);

    @Query(value = "{CALL bang_luong_san_pham()}", nativeQuery = true)
    List<Object> bangLuongSanPham();
}
