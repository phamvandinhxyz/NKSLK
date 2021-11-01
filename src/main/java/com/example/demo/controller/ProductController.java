package com.example.demo.controller;


import com.example.demo.models.CongNhan;
import com.example.demo.models.ThongTinSanPham;
import com.example.demo.response.BaseResponse;
import com.example.demo.response.DataResponse;
import com.example.demo.response.MessageResponse;
import com.example.demo.response.ObjectResponse;
import com.example.demo.service.ThongTinSanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.example.demo.service.ThongTinSanPhamService.*;

@RestController
@RequestMapping("/admin/products")
public class ProductController {
    @Autowired
    private ThongTinSanPhamService thongTinSanPhamService;

    //http://localhost:8080/api/v1/admin/products?page=1&size=10
    @GetMapping
    public BaseResponse findAllProduct(@RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size){
        try{
            int currentPage = page.orElse(1);
            int pageSize = size.orElse(10);
            Pageable pageable = PageRequest.of(currentPage-1,pageSize);
            Page<ThongTinSanPham> thongTinSanPhamPage = thongTinSanPhamService.findAllPageable(pageable);
            List<ThongTinSanPham> thongTinSanPhams = thongTinSanPhamPage.getContent();
            return new DataResponse(true,thongTinSanPhams,thongTinSanPhamService.findAll().size());
        }catch (Exception e){
            return new MessageResponse(false,"false");
        }
    }
        //http://localhost:8080/api/v1/admin/products/{id}
    @GetMapping("/{id}")
    public BaseResponse findSanPhamByMaSanPham(@PathVariable(name = "id") String id){
        try{
            return new ObjectResponse(true,thongTinSanPhamService.findByMaSanPham(id));
        }catch (Exception e){
            return new MessageResponse(false,"false");
        }
    }

    //http://localhost:8080/api/v1/admin/products
    @PostMapping
    public BaseResponse insertProduct(@RequestBody ThongTinSanPham thongTinSanPham){
        try{
            return new MessageResponse(true,thongTinSanPhamService.insert(thongTinSanPham));
        }catch (Exception e){
            return new MessageResponse(false,"false");
        }
    }

    //http://localhost:8080/api/v1/admin/products
    @PutMapping
    public BaseResponse updateProduct(@RequestBody ThongTinSanPham thongTinSanPham){
        try{
            return new MessageResponse(true,thongTinSanPhamService.update(thongTinSanPham));
        }catch (Exception e){
            return new MessageResponse(false,"false");
        }
    }

    //http://localhost:8080/api/v1/admin/product/{id}/delete
    @DeleteMapping("/{id}/delete")
    public BaseResponse deleteProduct(@PathVariable(name = "id") String id){
        try{
            return new MessageResponse(true,thongTinSanPhamService.delete(id));
        }catch (Exception e){
            return new MessageResponse(false,"false");
        }
    }

    //http://localhost:8080/api/v1/admin/products/{s}/search
    @GetMapping("/{s}/search")
    public BaseResponse findAllContainByIdOrName(@PathVariable(name = "s") String s){
        try{
            return new DataResponse(true,thongTinSanPhamService.findAllContainByIdOrName(s),thongTinSanPhamService.findAllContainByIdOrName(s).size());
        }catch (Exception e){
            return new MessageResponse(false,"false");
        }
    }
}
