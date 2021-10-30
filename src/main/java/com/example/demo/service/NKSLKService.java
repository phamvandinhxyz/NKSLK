package com.example.demo.service;

import com.example.demo.models.CongNhan;
import com.example.demo.models.NKSLK;
import com.example.demo.models.customs.NkSLKEmployeeResult;
import com.example.demo.repository.NKSLKRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NKSLKService {
    @Autowired
    private NKSLKRepository nkslkRepository;

    private final String SUCCESS = "success";
    private final String FAIL = "fail";

    public List<NKSLK> findAll() {
        return nkslkRepository.findAll();
    }

    public Page<NKSLK> findAllPageable(Pageable pageable) {
        return nkslkRepository.findAll(pageable);
    }

    public Optional<NKSLK> findNKSLKByMaNKSLK(String id){
        return nkslkRepository.findById(id);
    }

    public String insert(NKSLK nkslk) {
        nkslkRepository.save(nkslk);
        return SUCCESS;
    }

    public String update(NKSLK nkslk) {
        nkslkRepository.save(nkslk);
        return SUCCESS;
    }

    public String delete(String id) {
        nkslkRepository.deleteById(id);
        return SUCCESS;
    }

    public List<NKSLK> findAllContainByMaDMCNOrMaDMCVDL(String s) {
        List<NKSLK> nkslkResult = new ArrayList<>();
        List<NKSLK> nkslks = nkslkRepository.findAll();
        nkslks.forEach(nkslk -> {
            if( nkslk.getDanhMucNhanCong() != null){
                if(nkslk.getDanhMucNhanCong().contains(s)){
                    nkslkResult.add(nkslk);
                }
            }
            if( nkslk.getDanhMucCongViecDaLam() != null){
                if(nkslk.getDanhMucCongViecDaLam().contains(s)){
                    nkslkResult.add(nkslk);
                }
            }
        });
        return nkslkResult;
    }

    public List<NkSLKEmployeeResult> NKSLKInMonthEmployee(int month, String maCongNhan) {
        List<NkSLKEmployeeResult> nkSLKEmployeeResults = new ArrayList<>();
        try {
            List<Object> objects = nkslkRepository.NKSLKInMonthEmployee(month, maCongNhan);
            objects.forEach(o -> {
                Object[] ox = (Object[]) o;
                String ngaySinh = ox[3].toString();
                String ngayThucHien = ox[7].toString();
                String gioBatDau = ox[8].toString();
                String gioKetThuc = ox[9].toString();
                nkSLKEmployeeResults.add(new NkSLKEmployeeResult((String) ox[0], (String) ox[1]
                        , (String) ox[2], LocalDate.parse(ngaySinh)
                        , (String) ox[4], (String) ox[5]
                        , (String) ox[6], LocalDate.parse(ngayThucHien)
                        , LocalTime.parse(gioBatDau), LocalTime.parse(gioKetThuc)));
            });
            return nkSLKEmployeeResults;
        } catch (Exception e) {
            return nkSLKEmployeeResults;
        }
    }

    public List<NkSLKEmployeeResult> NKSLKInWeekEmployee(LocalDate week, String maCongNhan) {
        List<NkSLKEmployeeResult> nkSLKEmployeeResults = new ArrayList<>();
        try {
            List<Object> objects = nkslkRepository.NKSLKInWeekEmployee(week, maCongNhan);
            objects.forEach(o -> {
                Object[] ox = (Object[]) o;
                String ngaySinh = ox[3].toString();
                String ngayThucHien = ox[7].toString();
                String gioBatDau = ox[8].toString();
                String gioKetThuc = ox[9].toString();
                nkSLKEmployeeResults.add(new NkSLKEmployeeResult((String) ox[0], (String) ox[1]
                        , (String) ox[2], LocalDate.parse(ngaySinh)
                        , (String) ox[4], (String) ox[5]
                        , (String) ox[6], LocalDate.parse(ngayThucHien)
                        , LocalTime.parse(gioBatDau), LocalTime.parse(gioKetThuc)));
            });
            return nkSLKEmployeeResults;
        } catch (Exception e) {
            return nkSLKEmployeeResults;
        }
    }
}
