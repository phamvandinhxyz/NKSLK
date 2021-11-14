package com.example.demo.controller;

import com.example.demo.response.BaseResponse;
import com.example.demo.response.DataResponse;
import com.example.demo.response.MessageResponse;
import com.example.demo.response.ObjectResponse;
import com.example.demo.service.DanhMucCongViecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/admin/dmcv")
public class DanhMucCongViecController {

    @Autowired
    private DanhMucCongViecService danhMucCongViecService;

    //http://localhost:8080/api/v1/admin/dmcv
    @GetMapping
    public BaseResponse findAll(){
        try{
            return new DataResponse(true,danhMucCongViecService.findAll(),danhMucCongViecService.findAll().size());
        }catch (Exception e){
            return new MessageResponse(false,"false");
        }
    }


    //http://localhost:8080/api/v1/admin/dmcv/{id}
    @GetMapping("/{id}")
    public BaseResponse findDMCVById(@PathVariable(name = "id") String id){
        try{
            return new ObjectResponse(true,danhMucCongViecService.findDMCVById(id));
        }catch (Exception e){
            return new MessageResponse(false,"false");
        }
    }
}
