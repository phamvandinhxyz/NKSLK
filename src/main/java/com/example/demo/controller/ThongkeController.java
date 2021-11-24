package com.example.demo.controller;

import com.example.demo.models.NKSLK;
import com.example.demo.models.customs.BangLuongSanPhamResult;
import com.example.demo.models.customs.NkSLKEmployeeResult;
import com.example.demo.models.customs.ThongTinNKSLK;
import com.example.demo.response.BaseResponse;
import com.example.demo.response.DataResponse;
import com.example.demo.response.MessageResponse;
import com.example.demo.response.ObjectResponse;
import com.example.demo.service.ThongKeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    //http://localhost:8080/api/v1/admin/thongke/{type}/{s}/bangLuongSanPham
    //1: Tuan, 2: Thang, 3: Nam
    @GetMapping("/{type}/{s}/bangLuongSanPham")
    public BaseResponse NKSLKNam(@PathVariable(name = "type")int type, @PathVariable(name = "s")String s) {
        try {
            List<BangLuongSanPhamResult> blsp = new ArrayList<>();
            switch (type) {
                case 1: {
                    blsp = thongKeService.bangLuongSanPhamTuan(LocalDate.parse(s));
                    break;
                }
                case 2: {
                    blsp = thongKeService.bangLuongSanPhamthang(LocalDate.parse(s));
                    break;
                }
                case 3: {
                    blsp = thongKeService.bangLuongSanPhamNam(LocalDate.parse(s));
                    break;
                }
                default:
                    break;
            }
            return new DataResponse(true,blsp,blsp.size());
        } catch (Exception e) {
            return new MessageResponse(false, "false");
        }
    }
    //http://localhost:8080/api/v1/admin/thongke/bangLuongSanPham
    @GetMapping("/bangLuongSanPham")
    public BaseResponse bangLuongSanPham(){
        try{
            return new DataResponse(true,thongKeService.bangLuongSanPham(),thongKeService.bangLuongSanPham().size());
        }catch (Exception e){
            return new MessageResponse(false,"false");
        }
    }
}
