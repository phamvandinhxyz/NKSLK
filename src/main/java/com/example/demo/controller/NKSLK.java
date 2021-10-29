package com.example.demo.controller;

import com.example.demo.models.customs.NkSLKEmployeeResult;
import com.example.demo.response.BaseResponse;
import com.example.demo.response.DataResponse;
import com.example.demo.response.MessageResponse;
import com.example.demo.service.NKSLKService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/admin/nkslk")
public class NKSLK {
    @Autowired
    private NKSLKService nkslkService;

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
