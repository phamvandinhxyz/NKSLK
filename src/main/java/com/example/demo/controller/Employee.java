package com.example.demo.controller;

import com.example.demo.models.CongNhan;
import com.example.demo.models.NKSLK;
import com.example.demo.models.ThongTinSanPham;
import com.example.demo.repository.CongNhanRepository;
import com.example.demo.service.CongNhanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class Employee {
    @Autowired
    private CongNhanService congNhanService;
    @Autowired
    private CongNhanRepository congNhanRepository;

    @RequestMapping("/admin/employees")
    public String hello(Model model, @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size){
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(10);
        Pageable pageable = PageRequest.of(currentPage-1,pageSize);
        Page<CongNhan> congNhanPage = congNhanRepository.findAll(pageable);
        List<CongNhan> congNhans = congNhanPage.getContent();
        int totalPages = congNhanPage.getTotalPages();
        model.addAttribute("bookPage", congNhanPage);
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        model.addAttribute("congNhans",congNhans);
        return "admin/employees";
    }


    @RequestMapping("/admin")
    public String hello(Model model){
        return "admin/index";
    }
}
