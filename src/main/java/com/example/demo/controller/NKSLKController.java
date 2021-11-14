package com.example.demo.controller;

import com.example.demo.models.CongNhan;
import com.example.demo.models.DanhMucCongViec;
import com.example.demo.models.NKSLK;
import com.example.demo.models.customs.NkSLKEmployeeResult;
import com.example.demo.models.customs.ThongTinNKSLK;
import com.example.demo.repository.DanhMucCongViecRepository;
import com.example.demo.response.BaseResponse;
import com.example.demo.response.DataResponse;
import com.example.demo.response.MessageResponse;
import com.example.demo.response.ObjectResponse;
import com.example.demo.service.CongNhanService;
import com.example.demo.service.DanhMucCongViecService;
import com.example.demo.service.NKSLKService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin/nkslk")
public class NKSLKController {
    @Autowired
    private NKSLKService nkslkService;
    @Autowired
    private CongNhanService congNhanService;
    @Autowired
    private DanhMucCongViecRepository danhMucCongViecRepository;

    //http://localhost:8080/api/v1/admin/nkslk?page=1&size=10
    @GetMapping
    public BaseResponse findAllNKSLK(@RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size){
        try{
            int currentPage = page.orElse(1);
            int pageSize = size.orElse(10);
            Pageable pageable = PageRequest.of(currentPage-1,pageSize);
            Page<NKSLK> nkslkPage = nkslkService.findAllPageable(pageable);
            List<NKSLK> nkslks = nkslkPage.getContent();
            List<ThongTinNKSLK> thongTinNKSLKS = new ArrayList<>();
            nkslks.forEach(nkslk -> {
                if(nkslk.getDanhMucCongViecDaLam() == null){
                    thongTinNKSLKS.add(new ThongTinNKSLK(nkslk,null,congNhanService.findCongNhanByMaDanhMucCongNhan(nkslk.getDanhMucNhanCong())));
                }else {
                    thongTinNKSLKS.add(new ThongTinNKSLK(nkslk,danhMucCongViecRepository.findById(nkslk.getDanhMucCongViecDaLam()).get(),congNhanService.findCongNhanByMaDanhMucCongNhan(nkslk.getDanhMucNhanCong())));
                }
            });

            return new DataResponse(true,thongTinNKSLKS,nkslkService.findAll().size());
        }catch (Exception e){
            return new MessageResponse(false,"false");
        }
    }


    //http://localhost:8080/api/v1/admin/nkslk
    @PostMapping
    public BaseResponse insertNKSLK(@RequestBody NKSLK nkslk){
        try{
            return new MessageResponse(true,nkslkService.insert(nkslk));
        }catch (Exception e){
            return new MessageResponse(false,"false");
        }
    }


    //http://localhost:8080/api/v1/admin/nkslk
    @PutMapping
    public BaseResponse updateNKSLK(@RequestBody NKSLK nkslk){
        try{
            return new MessageResponse(true,nkslkService.update(nkslk));
        }catch (Exception e){
            return new MessageResponse(false,"false");
        }
    }


    //http://localhost:8080/api/v1/admin/nkslk/{id}/delete
    @DeleteMapping("/{id}/delete")
    public BaseResponse deleteNKSLK(@PathVariable(name = "id") String id){
        try{
            return new MessageResponse(true,nkslkService.delete(id));
        }catch (Exception e){
            return new MessageResponse(false,"false");
        }
    }

    //http://localhost:8080/api/v1/admin/nkslk/{id}
    @GetMapping("/{id}")
    public BaseResponse findNKSLKByMaNKSLK(@PathVariable(name = "id") String id){
        try{
            return new ObjectResponse(true,nkslkService.findNKSLKByMaNKSLK(id));
        }catch (Exception e){
            return new MessageResponse(false,"false");
        }
    }


    //http://localhost:8080/api/v1/admin/nkslk/{id}/search
    @GetMapping("/{id}/search")
    public BaseResponse findNKSLKByMaNKSLKContains(@PathVariable(name = "id") String id,@RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size){
        try{
            List<NKSLK> nkslks = nkslkService.findNKSLKByMaNKSLK(id);
            List<ThongTinNKSLK> thongTinNKSLKS = new ArrayList<>();
            nkslks.forEach(nkslk -> {
                if(nkslk.getDanhMucCongViecDaLam() == null){
                    thongTinNKSLKS.add(new ThongTinNKSLK(nkslk,null,congNhanService.findCongNhanByMaDanhMucCongNhan(nkslk.getDanhMucNhanCong())));
                }else {
                    thongTinNKSLKS.add(new ThongTinNKSLK(nkslk,danhMucCongViecRepository.findById(nkslk.getDanhMucCongViecDaLam()).get(),congNhanService.findCongNhanByMaDanhMucCongNhan(nkslk.getDanhMucNhanCong())));
                }
            });
            int currentPage = page.orElse(0);
            int pageSize = size.orElse(5);
            if((currentPage*pageSize)+pageSize > thongTinNKSLKS.size()){
                return new DataResponse(true,thongTinNKSLKS.subList(currentPage*pageSize,thongTinNKSLKS.size()),nkslks.size());
            }else
            return new DataResponse(true,thongTinNKSLKS.subList(currentPage*pageSize,(currentPage*pageSize)+pageSize),nkslks.size());
        }catch (Exception e){
            return new MessageResponse(false,"false");
        }
    }

    //http://localhost:8080/api/v1/admin/nkslk/{month}/{id}/month
    @GetMapping("/{month}/{id}/month")
    public BaseResponse NKSLKInMonthEmployee(@PathVariable(name = "month") int month,@PathVariable(name = "id") String id){
        try{
            List<NkSLKEmployeeResult> nkSLKEmployeeResults = nkslkService.NKSLKInMonthEmployee(month,id);
            return new DataResponse(true,nkSLKEmployeeResults,nkSLKEmployeeResults.size());
        }catch (Exception e){
            return new MessageResponse(false,"false");
        }
    }

    //http://localhost:8080/api/v1/admin/nkslk/{week}/{id}/week
    @GetMapping("/{week}/{id}/week")
    public BaseResponse NKSLKInWeekEmployee(@PathVariable(name = "week") String week,@PathVariable(name = "id") String id){
        try{
            List<NkSLKEmployeeResult> nkSLKEmployeeResults = nkslkService.NKSLKInWeekEmployee(LocalDate.parse(week),id);
            return new DataResponse(true,nkSLKEmployeeResults,nkSLKEmployeeResults.size());
        }catch (Exception e){
            return new MessageResponse(false,"false");
        }
    }
}
