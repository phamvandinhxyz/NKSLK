package com.example.demo.service;

import com.example.demo.repository.CongNhanRepository;
import com.example.demo.repository.DanhMucCongViecRepository;
import com.example.demo.repository.ThongTinSanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class ThongKeService {
    @Autowired
    private CongNhanRepository congNhanRepository;
    @Autowired
    private ThongTinSanPhamRepository thongTinSanPhamRepository;
    @Autowired
    private DanhMucCongViecRepository danhMucCongViecRepository;

    public HashMap<String,Object> thongKeTongQuan(){
        HashMap<String,Object> SLCongNhan = new HashMap<String,Object>();
        SLCongNhan.put("soLuongCongNhan",congNhanRepository.findAll().size());
        SLCongNhan.put("soLuongSanPham",thongTinSanPhamRepository.findAll().size());
        Object[] caoNhat = (Object[]) danhMucCongViecRepository.luongSanPhamCaoNhat();
        Double luongSanPhamCaoNhat = (Double) caoNhat[15];
        SLCongNhan.put("luongSanPhamCaoNhat",luongSanPhamCaoNhat);
        Object[] thapNhat = (Object[]) danhMucCongViecRepository.luongSanPhamThapNhat();
        Double luongSanPhamThapNhat = (Double) thapNhat[15];
        SLCongNhan.put("luongSanPhamThapNhat",luongSanPhamThapNhat);
        return SLCongNhan;
    }
}
