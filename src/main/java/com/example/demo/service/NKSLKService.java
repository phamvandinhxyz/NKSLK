package com.example.demo.service;

import com.example.demo.models.NKSLK;
import com.example.demo.models.customs.NkSLKEmployeeResult;
import com.example.demo.repository.NKSLKRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class NKSLKService {
    @Autowired
    private NKSLKRepository nkslkRepository;

    public List<NKSLK> getAllNKSLK(){
        return nkslkRepository.findAll();
    }

    public void saveNKSLK(NKSLK nkslk){
        try {
            nkslkRepository.save(nkslk);
        }catch (Exception e){
            System.out.println("err");
        }
    }

    public List<NkSLKEmployeeResult> NKSLKInMonthEmployee(int month, String maCongNhan){
        List<NkSLKEmployeeResult> nkSLKEmployeeResults = new ArrayList<>();
        try {
            List<Object> objects =nkslkRepository.NKSLKInMonthEmployee(month,maCongNhan);
            objects.forEach(o -> {
                Object[] ox = (Object[]) o;
                String ngaySinh = ox[3].toString();
                String ngayThucHien = ox[7].toString();
                String gioBatDau = ox[8].toString();
                String gioKetThuc = ox[9].toString();
                nkSLKEmployeeResults.add(new NkSLKEmployeeResult((String) ox[0],(String) ox[1]
                        ,(String) ox[2], LocalDate.parse(ngaySinh)
                        ,(String) ox[4],(String) ox[5]
                        ,(String) ox[6],LocalDate.parse(ngayThucHien)
                        ,LocalTime.parse(gioBatDau),LocalTime.parse(gioKetThuc)));
            });
            return nkSLKEmployeeResults;
        }catch (Exception e){
            return nkSLKEmployeeResults;
        }
    }

    public List<NkSLKEmployeeResult> NKSLKInWeekEmployee(LocalDate week, String maCongNhan){
        List<NkSLKEmployeeResult> nkSLKEmployeeResults = new ArrayList<>();
        try {
            List<Object> objects =nkslkRepository.NKSLKInWeekEmployee(week,maCongNhan);
            objects.forEach(o -> {
                Object[] ox = (Object[]) o;
                String ngaySinh = ox[3].toString();
                String ngayThucHien = ox[7].toString();
                String gioBatDau = ox[8].toString();
                String gioKetThuc = ox[9].toString();
                nkSLKEmployeeResults.add(new NkSLKEmployeeResult((String) ox[0],(String) ox[1]
                        ,(String) ox[2], LocalDate.parse(ngaySinh)
                        ,(String) ox[4],(String) ox[5]
                        ,(String) ox[6],LocalDate.parse(ngayThucHien)
                        ,LocalTime.parse(gioBatDau),LocalTime.parse(gioKetThuc)));
            });
            return nkSLKEmployeeResults;
        }catch (Exception e){
            return nkSLKEmployeeResults;
        }
    }
}
