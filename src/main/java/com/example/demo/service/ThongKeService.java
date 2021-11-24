package com.example.demo.service;

import com.example.demo.models.customs.BangLuongSanPhamResult;
import com.example.demo.repository.CongNhanRepository;
import com.example.demo.repository.DanhMucCongViecRepository;
import com.example.demo.repository.ThongTinSanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class ThongKeService {
    @Autowired
    private CongNhanRepository congNhanRepository;
    @Autowired
    private ThongTinSanPhamRepository thongTinSanPhamRepository;
    @Autowired
    private DanhMucCongViecRepository danhMucCongViecRepository;

    public HashMap<String,Object> thongKeTongQuan(){
        HashMap<String,Object> SLCongNhan = new HashMap<String,Object>();
        SLCongNhan.put("soLuongCongNhan",congNhanRepository.findAll().size());
        SLCongNhan.put("soLuongSanPham",thongTinSanPhamRepository.findAll().size());
        Object[] caoNhat = (Object[]) danhMucCongViecRepository.luongSanPhamCaoNhat();
        Double luongSanPhamCaoNhat = (Double) caoNhat[15];
        SLCongNhan.put("luongSanPhamCaoNhat",luongSanPhamCaoNhat);
        Object[] thapNhat = (Object[]) danhMucCongViecRepository.luongSanPhamThapNhat();
        Double luongSanPhamThapNhat = (Double) thapNhat[15];
        SLCongNhan.put("luongSanPhamThapNhat",luongSanPhamThapNhat);
        return SLCongNhan;
    }

    public HashMap<Object,Object> luongCongNhanTrongNam(int year){
        HashMap<Object,Object> luongCongNhan = initLuongTrongNam();
        List<Object> luongCongNhanResult=danhMucCongViecRepository.luongCongNhanTrongNam(year);
        luongCongNhanResult.forEach(o -> {
            Object[] objects= (Object[]) o;
            luongCongNhan.put((int)objects[0],(Double)objects[1]);
        });
        return luongCongNhan;
    }

    public HashMap<Object,Object> soLuongCongNhanChungRieng(){
        HashMap<Object,Object> hashMapSLCNCR = new HashMap<>();
        hashMapSLCNCR.put("soLuongCongNhanLamRieng",congNhanRepository.soLuongCongNhanLamRieng());
        hashMapSLCNCR.put("soLuongCongNhanLamChung",congNhanRepository.soLuongCongNhanLamChung());
        return hashMapSLCNCR;
    }

    public HashMap<Object,Object> initLuongTrongNam(){
        HashMap<Object,Object> luong = new HashMap<Object, Object>();
        luong.put(1,0);
        luong.put(2,0);
        luong.put(3,0);
        luong.put(4,0);
        luong.put(5,0);
        luong.put(6,0);
        luong.put(7,0);
        luong.put(8,0);
        luong.put(9,0);
        luong.put(10,0);
        luong.put(11,0);
        luong.put(12,0);
        return  luong;
    }

     public List<BangLuongSanPhamResult> bangLuongSanPhamNam(LocalDate nam){
        List<BangLuongSanPhamResult> blsp = new ArrayList<>();
        try{
            danhMucCongViecRepository.bangLuongSanPhamNam(nam).forEach(o -> {
                Object[] ox = (Object []) o;
                String ngaySinh = ox[4].toString();
                String ngayThucHien = ox[1].toString();
                blsp.add(new BangLuongSanPhamResult((String) ox[0],LocalDate.parse(ngayThucHien),
                        (String) ox[2],(String) ox[3],LocalDate.parse(ngaySinh),
                        (String) ox[5],(String) ox[6],
                        (String) ox[13], (Integer) ox[14],(Double) ox[15]));
            });
            return blsp;
        }catch (Exception e){
            return blsp;
        }
    }

    public List<BangLuongSanPhamResult> bangLuongSanPhamthang(LocalDate nam){
        List<BangLuongSanPhamResult> blsp = new ArrayList<>();
        try{
            danhMucCongViecRepository.bangLuongSanPhamThang(nam).forEach(o -> {
                Object[] ox = (Object []) o;
                String ngaySinh = ox[4].toString();
                String ngayThucHien = ox[1].toString();
                blsp.add(new BangLuongSanPhamResult((String) ox[0],LocalDate.parse(ngayThucHien),
                        (String) ox[2],(String) ox[3],LocalDate.parse(ngaySinh),
                        (String) ox[5],(String) ox[6],
                        (String) ox[13], (Integer) ox[14],(Double) ox[15]));
            });
            return blsp;
        }catch (Exception e){
            return blsp;
        }
    }

    public List<BangLuongSanPhamResult> bangLuongSanPhamTuan(LocalDate nam){
        List<BangLuongSanPhamResult> blsp = new ArrayList<>();
        try{
            danhMucCongViecRepository.bangLuongSanPhamTuan(nam).forEach(o -> {
                Object[] ox = (Object []) o;
                String ngaySinh = ox[4].toString();
                String ngayThucHien = ox[1].toString();
                blsp.add(new BangLuongSanPhamResult((String) ox[0],LocalDate.parse(ngayThucHien),
                        (String) ox[2],(String) ox[3],LocalDate.parse(ngaySinh),
                        (String) ox[5],(String) ox[6],
                        (String) ox[13], (Integer) ox[14],(Double) ox[15]));
            });
            return blsp;
        }catch (Exception e){
            return blsp;
        }
    }

    public List<BangLuongSanPhamResult> bangLuongSanPham(){
        List<BangLuongSanPhamResult> blsp = new ArrayList<>();
        try{
            danhMucCongViecRepository.bangLuongSanPham().forEach(o -> {
                Object[] ox = (Object []) o;
                String ngaySinh = ox[4].toString();
                String ngayThucHien = ox[1].toString();
                blsp.add(new BangLuongSanPhamResult((String) ox[0],LocalDate.parse(ngayThucHien),
                        (String) ox[2],(String) ox[3],LocalDate.parse(ngaySinh),
                        (String) ox[5],(String) ox[6],
                        (String) ox[13], (Integer) ox[14],(Double) ox[15]));
            });
            return blsp;
        }catch (Exception e){
            return blsp;
        }
    }
}
