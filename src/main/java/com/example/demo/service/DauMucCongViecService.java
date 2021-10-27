package com.example.demo.service;

import com.example.demo.repository.DauMucCongViecRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DauMucCongViecService {
    @Autowired
    private DauMucCongViecRepository dauMucCongViecRepository;
}
