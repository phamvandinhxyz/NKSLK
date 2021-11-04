package com.example.demo.repository;

import com.example.demo.models.DanhMucCongViec;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DanhMucCongViecRepository extends JpaRepository<DanhMucCongViec,String> {

    @Query(value = "{CALL luongSanPhamCaoNhat()}", nativeQuery = true)
    Object luongSanPhamCaoNhat();

    @Query(value = "{CALL luongSanPhamThapNhat()}", nativeQuery = true)
    Object luongSanPhamThapNhat();
}
