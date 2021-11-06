package com.example.demo.controller;

import com.example.demo.models.customs.NkSLKEmployeeResult;
import com.example.demo.response.BaseResponse;
import com.example.demo.response.DataResponse;
import com.example.demo.response.MessageResponse;
import com.example.demo.response.ObjectResponse;
import com.example.demo.service.ThongKeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    //http://localhost:8080/api/v1/admin/thongke/{year}/luongtrongnam
    @GetMapping("/{year}/luongtrongnam")
    public BaseResponse luongCongNhanTrongNam(@PathVariable(name = "year") String year){
        try{
            return new ObjectResponse(true,thongKeService.luongCongNhanTrongNam(Integer.parseInt(year)));
        }catch (Exception e){
            return new MessageResponse(false,"false");
        }
    }

    //http://localhost:8080/api/v1/admin/thongke/soLuongCongNhanChungRieng
    @GetMapping("/soLuongCongNhanChungRieng")
    public BaseResponse soLuongCongNhanChungRieng(){
        try{
            return new ObjectResponse(true,thongKeService.soLuongCongNhanChungRieng());
        }catch (Exception e){
            return new MessageResponse(false,"false");
        }
    }
}
