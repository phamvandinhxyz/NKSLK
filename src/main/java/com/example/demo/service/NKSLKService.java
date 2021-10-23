package com.example.demo.service;

import com.example.demo.models.NKSLK;
import com.example.demo.repository.NKSLKRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public List<Object> NKSLKInMonthEmployee(int month,String maCongNhan){
        try {
            List<Object> objects = nkslkRepository.NKSLKInMonthEmployee(month,maCongNhan);
            return nkslkRepository.NKSLKInMonthEmployee(month,maCongNhan);
        }catch (Exception e){
            System.out.println("err");
            return null;
        }
    }
}
