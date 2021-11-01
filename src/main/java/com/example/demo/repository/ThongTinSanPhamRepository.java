package com.example.demo.repository;

import com.example.demo.models.CongNhan;
import com.example.demo.models.ThongTinSanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThongTinSanPhamRepository extends JpaRepository<ThongTinSanPham,String> {
    Page<ThongTinSanPham> findAll(Pageable pageable);
}
