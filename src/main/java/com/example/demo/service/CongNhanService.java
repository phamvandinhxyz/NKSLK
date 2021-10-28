package com.example.demo.service;

import com.example.demo.models.CongNhan;
import com.example.demo.repository.CongNhanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CongNhanService {
    @Autowired
    private CongNhanRepository congNhanRepository;

    private final String SUCCESS = "success";
    private final String FAIL = "fail";

    public Page<CongNhan> findAllPageable(Pageable pageable){
        return congNhanRepository.findAll(pageable);
    }
    public List<CongNhan> findAll(){
        return congNhanRepository.findAll();
    }
    public String insert(CongNhan congNhan){
        try{
            congNhanRepository.save(congNhan);
            return SUCCESS;
        }catch (Exception e){
            return FAIL;
        }
    }
    public String update(CongNhan congNhan){
        try{
            congNhanRepository.save(congNhan);
            return SUCCESS;
        }catch (Exception e){
            return FAIL;
        }
    }
    public String delete(String id){
        try{
            congNhanRepository.deleteById(id);
            return SUCCESS;
        }catch (Exception e){
            return FAIL;
        }
    }
    public List<CongNhan> findAllContainByIdOrName(String s){
        List<CongNhan> congNhanResult=new ArrayList<>();
        List<CongNhan> congNhans=congNhanRepository.findAll();
        congNhans.forEach(congNhan -> {
            if(congNhan.getMaCongNhan().contains(s) || congNhan.getHoTen().contains(s)){
                congNhanResult.add(congNhan);
            }
        });
        return  congNhanResult;
    }
}
