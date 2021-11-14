package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table
public class NKSLK {
    @Id
    private String maNKSLK;
    private LocalDate NgayThucHien;
    private LocalTime GioBatDau;
    private LocalTime GioKetThuc;
    private String DanhMucNhanCong;
    private String DanhMucCongViecDaLam;

    public NKSLK() {
        super();
    }

    public NKSLK(String MaNKSLK, LocalDate ngayThucHien, LocalTime gioBatDau, LocalTime gioKetThuc, String danhMucNhanCong, String danhMucCongViecDaLam) {
        maNKSLK = MaNKSLK;
        NgayThucHien = ngayThucHien;
        GioBatDau = gioBatDau;
        GioKetThuc = gioKetThuc;
        DanhMucNhanCong = danhMucNhanCong;
        DanhMucCongViecDaLam = danhMucCongViecDaLam;
    }

    public String getMaNKSLK() {
        return maNKSLK;
    }

    public void setMaNKSLK(String MaNKSLK) {
        maNKSLK = MaNKSLK;
    }

    public LocalDate getNgayThucHien() {
        return NgayThucHien;
    }

    public void setNgayThucHien(LocalDate ngayThucHien) {
        NgayThucHien = ngayThucHien;
    }

    public LocalTime getGioBatDau() {
        return GioBatDau;
    }

    public void setGioBatDau(LocalTime gioBatDau) {
        GioBatDau = gioBatDau;
    }

    public LocalTime getGioKetThuc() {
        return GioKetThuc;
    }

    public void setGioKetThuc(LocalTime gioKetThuc) {
        GioKetThuc = gioKetThuc;
    }

    public String getDanhMucNhanCong() {
        return DanhMucNhanCong;
    }

    public void setDanhMucNhanCong(String danhMucNhanCong) {
        DanhMucNhanCong = danhMucNhanCong;
    }

    public String getDanhMucCongViecDaLam() {
        return DanhMucCongViecDaLam;
    }

    public void setDanhMucCongViecDaLam(String danhMucCongViecDaLam) {
        DanhMucCongViecDaLam = danhMucCongViecDaLam;
    }
}
