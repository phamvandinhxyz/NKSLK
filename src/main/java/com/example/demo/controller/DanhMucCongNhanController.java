package com.example.demo.controller;

import com.example.demo.response.BaseResponse;
import com.example.demo.response.DataResponse;
import com.example.demo.response.MessageResponse;
import com.example.demo.response.ObjectResponse;
import com.example.demo.service.DanhMucCongNhanService;
import com.example.demo.service.DanhMucCongViecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("/admin/dmcn")
public class DanhMucCongNhanController {

    @Autowired
    private DanhMucCongNhanService danhMucCongNhanService;

    //http://localhost:8080/api/v1/admin/dmcn
    @GetMapping
    public BaseResponse findAll(){
        try{
            return new DataResponse(true,danhMucCongNhanService.findAll(),danhMucCongNhanService.findAll().size());
        }catch (Exception e){
            return new MessageResponse(false,"false");
        }
    }


    //http://localhost:8080/api/v1/admin/dmcn/{id}
    @GetMapping("/{id}")
    public BaseResponse findDMCNById(@PathVariable(name = "id") String id){
        try{
            return new DataResponse(true, Collections.singletonList(danhMucCongNhanService.findDMCNById(id)),danhMucCongNhanService.soLuongCongNhan(id));
        }catch (Exception e){
            return new MessageResponse(false,"false");
        }
    }
}
