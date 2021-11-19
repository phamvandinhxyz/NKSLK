package com.example.demo.service;

import com.example.demo.models.CongNhan;
import com.example.demo.models.NKSLK;
import com.example.demo.models.customs.WorkDayResult;
import com.example.demo.repository.CongNhanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CongNhanService {
    @Autowired
    private CongNhanRepository congNhanRepository;

    private final String SUCCESS = "success";
    private final String FAIL = "fail";

    public Page<CongNhan> findAllPageable(Pageable pageable) {
        return congNhanRepository.findAll(pageable);
    }

    public List<CongNhan> findAllEmployeeEmptyDMCN() {
        return congNhanRepository.findAllEmployeeEmptyDMCN();
    }

    public List<CongNhan> findAll() {
        return congNhanRepository.findAll();
    }

    public Optional<CongNhan> findByMaCongNhan(String id){
        return congNhanRepository.findById(id);
    }

    public List<CongNhan> findCongNhanByMaDanhMucCongNhan(String id){
        return congNhanRepository.findCongNhanBymaDanhMucCongNhan(id);
    }

    public String insert(CongNhan congNhan) {
        congNhanRepository.save(congNhan);
        return SUCCESS;
    }

    public String update(CongNhan congNhan) {
        congNhanRepository.save(congNhan);
        return SUCCESS;
    }

    public String delete(String id) {
        congNhanRepository.deleteById(id);
        return SUCCESS;
    }

    public List<CongNhan> findAllContainByIdOrName(String s) {
        List<CongNhan> congNhanResult = new ArrayList<>();
        List<CongNhan> congNhans = congNhanRepository.findAll();
        congNhans.forEach(congNhan -> {
            if (congNhan.getMaCongNhan().contains(s) || congNhan.getHoTen().contains(s)) {
                congNhanResult.add(congNhan);
            }
        });
        return congNhanResult;
    }

    public List<WorkDayResult> getWorkDayEmployee(){
        List<WorkDayResult> workDayResults = new ArrayList<>();
        try {
            List<Object> objects = congNhanRepository.getWorkDayEmployee();
            objects.forEach(o -> {
                Object[] ox = (Object[]) o;
                BigDecimal tongNgayCong = (BigDecimal) ox[2];
                workDayResults.add(new WorkDayResult((String) ox[0],(String) ox[1], tongNgayCong.floatValue() ));
            });
            return workDayResults;
        }catch (Exception e){
            return workDayResults;
        }
    }
}
