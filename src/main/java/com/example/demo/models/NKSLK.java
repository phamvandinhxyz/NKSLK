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
    private String MaNKSLK;
    private LocalDate NgayThucHien;
    private LocalTime GioBatDau;
    private LocalTime GioKetThuc;
    private String DanhMucNhanCong;
    private String DanhMucCongViecDaLam;

    public NKSLK() {
        super();
    }

    public NKSLK(String maNKSLK, LocalDate ngayThucHien, LocalTime gioBatDau, LocalTime gioKetThuc, String danhMucNhanCong, String danhMucCongViecDaLam) {
        MaNKSLK = maNKSLK;
        NgayThucHien = ngayThucHien;
        GioBatDau = gioBatDau;
        GioKetThuc = gioKetThuc;
        DanhMucNhanCong = danhMucNhanCong;
        DanhMucCongViecDaLam = danhMucCongViecDaLam;
    }

    public String getMaNKSLK() {
        return MaNKSLK;
    }

    public void setMaNKSLK(String maNKSLK) {
        MaNKSLK = maNKSLK;
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
