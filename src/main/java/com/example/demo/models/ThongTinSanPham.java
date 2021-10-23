package com.example.demo.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table
public class ThongTinSanPham {
    @Id
    private String MaSanPham;
    private String TenSanPham;
    private String SoDangKy;
    private LocalDateTime HanSuDung;
    private String QuyCach;
    private LocalDate NgayDangKy;
    private LocalDate NgaySanXuat;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "SanPhamApDung")
    private List<DauMucCongViec> dauMucCongViecs;


    public ThongTinSanPham() {
        super();
    }

    public ThongTinSanPham(String maSanPham, String tenSanPham, String soDangKy, LocalDateTime hanSuDung, String quyCach, LocalDate ngayDangKy, LocalDate ngaySanXuat, List<DauMucCongViec> dauMucCongViecs) {
        MaSanPham = maSanPham;
        TenSanPham = tenSanPham;
        SoDangKy = soDangKy;
        HanSuDung = hanSuDung;
        QuyCach = quyCach;
        NgayDangKy = ngayDangKy;
        NgaySanXuat = ngaySanXuat;
        this.dauMucCongViecs = dauMucCongViecs;
    }

    public String getMaSanPham() {
        return MaSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        MaSanPham = maSanPham;
    }

    public String getTenSanPham() {
        return TenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        TenSanPham = tenSanPham;
    }

    public String getSoDangKy() {
        return SoDangKy;
    }

    public void setSoDangKy(String soDangKy) {
        SoDangKy = soDangKy;
    }

    public LocalDateTime getHanSuDung() {
        return HanSuDung;
    }

    public void setHanSuDung(LocalDateTime hanSuDung) {
        HanSuDung = hanSuDung;
    }

    public String getQuyCach() {
        return QuyCach;
    }

    public void setQuyCach(String quyCach) {
        QuyCach = quyCach;
    }

    public LocalDate getNgayDangKy() {
        return NgayDangKy;
    }

    public void setNgayDangKy(LocalDate ngayDangKy) {
        NgayDangKy = ngayDangKy;
    }

    public LocalDate getNgaySanXuat() {
        return NgaySanXuat;
    }

    public void setNgaySanXuat(LocalDate ngaySanXuat) {
        NgaySanXuat = ngaySanXuat;
    }

    public List<DauMucCongViec> getDauMucCongViecs() {
        return dauMucCongViecs;
    }

    public void setDauMucCongViecs(List<DauMucCongViec> dauMucCongViecs) {
        this.dauMucCongViecs = dauMucCongViecs;
    }
}
