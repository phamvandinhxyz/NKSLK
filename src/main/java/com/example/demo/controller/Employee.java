package com.example.demo.controller;

import com.example.demo.models.CongNhan;
import com.example.demo.repository.CongNhanRepository;
import com.example.demo.response.BaseResponse;
import com.example.demo.response.DataResponse;
import com.example.demo.response.MessageResponse;
import com.example.demo.service.CongNhanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin/employees")
public class Employee {
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

    @GetMapping
    public BaseResponse findAllEmployee(@RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size){
        try{
            int currentPage = page.orElse(1);
            int pageSize = size.orElse(10);
            Pageable pageable = PageRequest.of(currentPage-1,pageSize);
            Page<CongNhan> congNhanPage = congNhanService.findAll(pageable);
            List<CongNhan> congNhans = congNhanPage.getContent();
            return new DataResponse(true,congNhans);
        }catch (Exception e){
            return new MessageResponse(false,"false");
        }
    }
}
