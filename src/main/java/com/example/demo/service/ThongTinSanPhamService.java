package com.example.demo.service;

import com.example.demo.repository.ThongTinSanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ThongTinSanPhamService {
    @Autowired
    private ThongTinSanPhamRepository thongTinSanPhamRepository;
}
