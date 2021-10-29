package com.example.demo.models.customs;

import java.time.LocalDate;
import java.time.LocalTime;

public class NkSLKEmployeeResult {
    private String MaNKSLK;
    private String MaCongNhan;
    private String HoTen;
    private LocalDate NgaySinh;
    private String QueQuan;
    private String MaDanhMucCongNhan;
    private String DanhMucCongViecDaLam;
    private LocalDate NgayThucHien;
    private LocalTime GioBatDau;
    private LocalTime GioKetThuc;

    public NkSLKEmployeeResult() {
        super();
    }

    public NkSLKEmployeeResult(String maNKSLK, String maCongNhan, String hoTen, LocalDate ngaySinh, String queQuan, String maDanhMucCongNhan, String danhMucCongViecDaLam, LocalDate ngayThucHien, LocalTime gioBatDau, LocalTime gioKetThuc) {
        MaNKSLK = maNKSLK;
        MaCongNhan = maCongNhan;
        HoTen = hoTen;
        NgaySinh = ngaySinh;
        QueQuan = queQuan;
        MaDanhMucCongNhan = maDanhMucCongNhan;
        DanhMucCongViecDaLam = danhMucCongViecDaLam;
        NgayThucHien = ngayThucHien;
        GioBatDau = gioBatDau;
        GioKetThuc = gioKetThuc;
    }

    public String getMaNKSLK() {
        return MaNKSLK;
    }

    public void setMaNKSLK(String maNKSLK) {
        MaNKSLK = maNKSLK;
    }

    public String getMaCongNhan() {
        return MaCongNhan;
    }

    public void setMaCongNhan(String maCongNhan) {
        MaCongNhan = maCongNhan;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String hoTen) {
        HoTen = hoTen;
    }

    public LocalDate getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(LocalDate ngaySinh) {
        NgaySinh = ngaySinh;
    }

    public String getQueQuan() {
        return QueQuan;
    }

    public void setQueQuan(String queQuan) {
        QueQuan = queQuan;
    }

    public String getMaDanhMucCongNhan() {
        return MaDanhMucCongNhan;
    }

    public void setMaDanhMucCongNhan(String maDanhMucCongNhan) {
        MaDanhMucCongNhan = maDanhMucCongNhan;
    }

    public String getDanhMucCongViecDaLam() {
        return DanhMucCongViecDaLam;
    }

    public void setDanhMucCongViecDaLam(String danhMucCongViecDaLam) {
        DanhMucCongViecDaLam = danhMucCongViecDaLam;
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
}
