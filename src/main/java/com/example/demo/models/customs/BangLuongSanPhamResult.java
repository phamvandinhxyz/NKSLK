package com.example.demo.models.customs;

import java.time.LocalDate;

public class BangLuongSanPhamResult {
    private String maCongNhan;
    private LocalDate NgayThucHien;
    private String maCongViec;
    private String hoTen;
    private LocalDate ngayNamSinh;
    private String phongBan;
    private String chucVu;
    private String maDanhMucCongNhan;
    private int soLuongCongNhan;
    private Double bangLuong;

    public BangLuongSanPhamResult() {
        super();
    }

    public BangLuongSanPhamResult(String maCongNhan, LocalDate ngayThucHien, String maCongViec, String hoTen, LocalDate ngayNamSinh, String phongBan, String chucVu, String maDanhMucCongNhan, int soLuongCongNhan, Double bangLuong) {
        this.maCongNhan = maCongNhan;
        NgayThucHien = ngayThucHien;
        this.maCongViec = maCongViec;
        this.hoTen = hoTen;
        this.ngayNamSinh = ngayNamSinh;
        this.phongBan = phongBan;
        this.chucVu = chucVu;
        this.maDanhMucCongNhan = maDanhMucCongNhan;
        this.soLuongCongNhan = soLuongCongNhan;
        this.bangLuong = bangLuong;
    }

    public String getMaCongNhan() {
        return maCongNhan;
    }

    public void setMaCongNhan(String maCongNhan) {
        this.maCongNhan = maCongNhan;
    }

    public LocalDate getNgayThucHien() {
        return NgayThucHien;
    }

    public void setNgayThucHien(LocalDate ngayThucHien) {
        NgayThucHien = ngayThucHien;
    }

    public String getMaCongViec() {
        return maCongViec;
    }

    public void setMaCongViec(String maCongViec) {
        this.maCongViec = maCongViec;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public LocalDate getNgayNamSinh() {
        return ngayNamSinh;
    }

    public void setNgayNamSinh(LocalDate ngayNamSinh) {
        this.ngayNamSinh = ngayNamSinh;
    }

    public String getPhongBan() {
        return phongBan;
    }

    public void setPhongBan(String phongBan) {
        this.phongBan = phongBan;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public String getMaDanhMucCongNhan() {
        return maDanhMucCongNhan;
    }

    public void setMaDanhMucCongNhan(String maDanhMucCongNhan) {
        this.maDanhMucCongNhan = maDanhMucCongNhan;
    }

    public int getSoLuongCongNhan() {
        return soLuongCongNhan;
    }

    public void setSoLuongCongNhan(int soLuongCongNhan) {
        this.soLuongCongNhan = soLuongCongNhan;
    }

    public Double getBangLuong() {
        return bangLuong;
    }

    public void setBangLuong(Double bangLuong) {
        this.bangLuong = bangLuong;
    }
}
