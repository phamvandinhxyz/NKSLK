package com.example.demo.controller;

import com.example.demo.models.CongNhan;
import com.example.demo.models.customs.WorkDayResult;
import com.example.demo.repository.CongNhanRepository;
import com.example.demo.response.BaseResponse;
import com.example.demo.response.DataResponse;
import com.example.demo.response.MessageResponse;
import com.example.demo.response.ObjectResponse;
import com.example.demo.service.CongNhanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin/employees")
public class EmployeeController {
    @Autowired
    private CongNhanService congNhanService;

//    @GetMapping()
//    public String findAllEmployee(Model model, @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size){
//        int currentPage = page.orElse(1);
//        int pageSize = size.orElse(10);
//        Pageable pageable = PageRequest.of(currentPage-1,pageSize);
//        Page<CongNhan> congNhanPage = congNhanRepository.findAll(pageable);
//        List<CongNhan> congNhans = congNhanPage.getContent();
//        int totalPages = congNhanPage.getTotalPages();
//        model.addAttribute("bookPage", congNhanPage);
//        if (totalPages > 0) {
//            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
//                    .boxed()
//                    .collect(Collectors.toList());
//            model.addAttribute("pageNumbers", pageNumbers);
//        }
//        model.addAttribute("congNhans",congNhans);
//        return "admin/employees";
//    }

//
//    @RequestMapping("/admin")
//    public String hello(Model model){
//        return "admin/index";
//    }

    //http://localhost:8080/api/v1/admin/employees?page=1&size=10
    @GetMapping
    public BaseResponse findAllEmployee(@RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size){
        try{
            int currentPage = page.orElse(1);
            int pageSize = size.orElse(10);
            Pageable pageable = PageRequest.of(currentPage-1,pageSize);
            Page<CongNhan> congNhanPage = congNhanService.findAllPageable(pageable);
            List<CongNhan> congNhans = congNhanPage.getContent();
            return new DataResponse(true,congNhans,congNhanService.findAll().size());
        }catch (Exception e){
            return new MessageResponse(false,"false");
        }
    }

    //http://localhost:8080/api/v1/admin/employees/{id}
    @GetMapping("/{id}")
    public BaseResponse findNKSLKByMaNKSLK(@PathVariable(name = "id") String id){
        try{
            return new ObjectResponse(true,congNhanService.findByMaCongNhan(id));
        }catch (Exception e){
            return new MessageResponse(false,"false");
        }
    }

    //http://localhost:8080/api/v1/admin/employees
    @PostMapping
    public BaseResponse insertEmployee(@RequestBody CongNhan congNhan){
        try{
            return new MessageResponse(true,congNhanService.insert(congNhan));
        }catch (Exception e){
            return new MessageResponse(false,"false");
        }
    }

    //http://localhost:8080/api/v1/admin/employees
    @PutMapping
    public BaseResponse updateEmployee(@RequestBody CongNhan congNhan){
        try{
            return new MessageResponse(true,congNhanService.update(congNhan));
        }catch (Exception e){
            return new MessageResponse(false,"false");
        }
    }

    //http://localhost:8080/api/v1/admin/employees/{id}/delete
    @DeleteMapping("/{id}/delete")
    public BaseResponse deleteEmployee(@PathVariable(name = "id") String id){
        try{
            return new MessageResponse(true,congNhanService.delete(id));
        }catch (Exception e){
            return new MessageResponse(false,"false");
        }
    }
    //http://localhost:8080/api/v1/admin/employees/{s}/search
    @GetMapping("/{s}/search")
    public BaseResponse findAllContainByIdOrName(@PathVariable(name = "s") String s){
        try{
            return new DataResponse(true,congNhanService.findAllContainByIdOrName(s),congNhanService.findAllContainByIdOrName(s).size());
        }catch (Exception e){
            return new MessageResponse(false,"false");
        }
    }

    //http://localhost:8080/api/v1/admin/employees/workday
    @GetMapping("/workday")
    public BaseResponse getWorkDayEmployee(){
        try{
            List<WorkDayResult> workDayResults = congNhanService.getWorkDayEmployee();
            return new DataResponse(true,workDayResults,workDayResults.size());
        }catch (Exception e){
            return new MessageResponse(false,"false");
        }
    }
}
