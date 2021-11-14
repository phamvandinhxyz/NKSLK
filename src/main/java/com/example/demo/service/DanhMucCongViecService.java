package com.example.demo.service;

import com.example.demo.models.DanhMucCongViec;
import com.example.demo.repository.DanhMucCongViecRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DanhMucCongViecService {

    @Autowired
    private DanhMucCongViecRepository danhMucCongViecRepository;

    public List<DanhMucCongViec> findAll(){
        return danhMucCongViecRepository.findAll();
    }

    public Optional<DanhMucCongViec> findDMCVById(String id){
        return danhMucCongViecRepository.findById(id);
    }
}
