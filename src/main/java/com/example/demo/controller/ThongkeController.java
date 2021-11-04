package com.example.demo.controller;

import com.example.demo.models.customs.NkSLKEmployeeResult;
import com.example.demo.response.BaseResponse;
import com.example.demo.response.DataResponse;
import com.example.demo.response.MessageResponse;
import com.example.demo.response.ObjectResponse;
import com.example.demo.service.ThongKeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/admin/thongke")
public class ThongkeController {
    @Autowired
    private ThongKeService thongKeService;

    //http://localhost:8080/api/v1/admin/thongke/tongquan
    @GetMapping("/tongquan")
    public BaseResponse thongKeTongQuan(){
        try{
            return new ObjectResponse(true,thongKeService.thongKeTongQuan());
        }catch (Exception e){
            return new MessageResponse(false,"false");
        }
    }
}
