package com.example.demo.service;

import com.example.demo.models.CongNhan;
import com.example.demo.models.ThongTinSanPham;
import com.example.demo.repository.ThongTinSanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ThongTinSanPhamService {
    @Autowired
    private ThongTinSanPhamRepository thongTinSanPhamRepository;

    private final String SUCCESS = "success";
    private final String FAIL = "fail";

    public Page<ThongTinSanPham> findAllPageable(Pageable pageable) {
        return thongTinSanPhamRepository.findAll(pageable);
    }

    public List<ThongTinSanPham> findAll() {
        return thongTinSanPhamRepository.findAll();
    }

    public Optional<ThongTinSanPham> findByMaSanPham(String id)
    {
        return thongTinSanPhamRepository.findById(id);
    }

    public String insert(ThongTinSanPham thongTinSanPham) {
        thongTinSanPhamRepository.save(thongTinSanPham);
        return SUCCESS;
    }

    public String update(ThongTinSanPham thongTinSanPham) {
        thongTinSanPhamRepository.save(thongTinSanPham);
        return SUCCESS;
    }

    public String delete(String id) {
        thongTinSanPhamRepository.deleteById(id);
        return SUCCESS;
    }

    public List<ThongTinSanPham> findAllContainByIdOrName(String s) {
        List<ThongTinSanPham> thongTinSanPhamResult = new ArrayList<>();
        List<ThongTinSanPham> thongTinSanPhams = thongTinSanPhamRepository.findAll();
        thongTinSanPhams.forEach(thongTinSanPham -> {
            if (thongTinSanPham.getMaSanPham().contains(s) || thongTinSanPham.getTenSanPham().contains(s)) {
                thongTinSanPhamResult.add(thongTinSanPham);
            }
        });
        return thongTinSanPhamResult;
    }
}
