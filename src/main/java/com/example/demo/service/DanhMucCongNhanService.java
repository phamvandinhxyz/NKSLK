package com.example.demo.service;

import com.example.demo.models.DanhMucCongNhan;
import com.example.demo.models.DanhMucCongViec;
import com.example.demo.repository.CongNhanRepository;
import com.example.demo.repository.DanhMucCongNhanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DanhMucCongNhanService {
    @Autowired
    private DanhMucCongNhanRepository danhMucCongNhanRepository;
    @Autowired
    private CongNhanRepository congNhanRepository;

    public List<DanhMucCongNhan> findAll(){
        return danhMucCongNhanRepository.findAll();
    }

    public Optional<DanhMucCongNhan> findDMCNById(String id){
        return danhMucCongNhanRepository.findById(id);
    }

    public int soLuongCongNhan(String id){
        return congNhanRepository.findCongNhanBymaDanhMucCongNhan(id).size();
    }
}
