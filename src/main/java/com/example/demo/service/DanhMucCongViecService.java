package com.example.demo.service;

import com.example.demo.repository.DanhMucCongViecRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DanhMucCongViecService {

    @Autowired
    private DanhMucCongViecRepository danhMucCongViecRepository;
}
