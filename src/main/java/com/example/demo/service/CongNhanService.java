package com.example.demo.service;

import com.example.demo.models.CongNhan;
import com.example.demo.repository.CongNhanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CongNhanService {
    @Autowired
    private CongNhanRepository congNhanRepository;

    public Page<CongNhan> findAll(Pageable pageable){
        return congNhanRepository.findAll(pageable);
    }
}
