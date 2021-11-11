package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table
public class CongNhan {
    @Id
    private String MaCongNhan;
    private String HoTen;
    private LocalDate NgayNamSinh;
    private String PhongBan;
    private String ChucVu;
    private String QueQuan;
    private String GioiTinh;
    private long LuongHopDong;
    private long LuongBaoHiem;
    private LocalTime GioBatDau;
    private LocalTime GioKetThuc;
    private String maDanhMucCongNhan;

    public CongNhan() {
        super();
    }

    public CongNhan(String maCongNhan, String hoTen, LocalDate ngayNamSinh, String phongBan, String chucVu, String queQuan, String gioiTinh, long luongHopDong, long luongBaoHiem, LocalTime gioBatDau, LocalTime gioKetThuc, String maDanhMucCongNhan) {
        MaCongNhan = maCongNhan;
        HoTen = hoTen;
        NgayNamSinh = ngayNamSinh;
        PhongBan = phongBan;
        ChucVu = chucVu;
        QueQuan = queQuan;
        GioiTinh = gioiTinh;
        LuongHopDong = luongHopDong;
        LuongBaoHiem = luongBaoHiem;
        GioBatDau = gioBatDau;
        GioKetThuc = gioKetThuc;
        maDanhMucCongNhan = maDanhMucCongNhan;
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

    public LocalDate getNgayNamSinh() {
        return NgayNamSinh;
    }

    public void setNgayNamSinh(LocalDate ngayNamSinh) {
        NgayNamSinh = ngayNamSinh;
    }

    public String getPhongBan() {
        return PhongBan;
    }

    public void setPhongBan(String phongBan) {
        PhongBan = phongBan;
    }

    public String getChucVu() {
        return ChucVu;
    }

    public void setChucVu(String chucVu) {
        ChucVu = chucVu;
    }

    public String getQueQuan() {
        return QueQuan;
    }

    public void setQueQuan(String queQuan) {
        QueQuan = queQuan;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        GioiTinh = gioiTinh;
    }

    public long getLuongHopDong() {
        return LuongHopDong;
    }

    public void setLuongHopDong(long luongHopDong) {
        LuongHopDong = luongHopDong;
    }

    public long getLuongBaoHiem() {
        return LuongBaoHiem;
    }

    public void setLuongBaoHiem(long luongBaoHiem) {
        LuongBaoHiem = luongBaoHiem;
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

    public String getMaDanhMucCongNhan() {
        return maDanhMucCongNhan;
    }

    public void setMaDanhMucCongNhan(String maDanhMucCongNhan) {
        maDanhMucCongNhan = maDanhMucCongNhan;
    }
}
