package com.example.demo;

import com.example.demo.models.NKSLK;
import com.example.demo.models.ThongTinSanPham;
import com.example.demo.repository.ThongTinSanPhamRepository;
import com.example.demo.service.NKSLKService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@SpringBootApplication
@Controller
public class DemoApplication {

    @Autowired
    private NKSLKService nkslkService;
    @Autowired
    private ThongTinSanPhamRepository thongTinSanPhamRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @RequestMapping("/hello")
    public String hello(Model model){
        List<NKSLK> nkslks = nkslkService.getAllNKSLK();
        List<ThongTinSanPham> thongTinSanPhams = thongTinSanPhamRepository.findAll();
//        List<Object> objects = nkslkService.NKSLKInMonthEmployee(8,"CN001");
        model.addAttribute("nkslk",nkslks);
        return "admin/index";
    }
}
