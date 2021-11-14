package com.example.demo.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class DanhMucCongViec {
    @Id
    private String MaCongViec;
    private String TenCongViec;
    private float DinhMucKhoan;
    private String DonViKhoan;
    private float HeSoKhoan;
    private float DinhMucLaoDong;
    private float DonGia;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "DanhMucCongViecDaLam")
    private List<NKSLK> nkslks;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "DanhMucCongViec")
    private List<DauMucCongViec> dauMucCongViecs;

    public DanhMucCongViec() {
        super();
    }

    public DanhMucCongViec(String maCongViec, String tenCongViec, float dinhMucKhoan, String donViKhoan, float heSoKhoan, float dinhMucLaoDong, float donGia, List<NKSLK> nkslks, List<DauMucCongViec> dauMucCongViecs) {
        MaCongViec = maCongViec;
        TenCongViec = tenCongViec;
        DinhMucKhoan = dinhMucKhoan;
        DonViKhoan = donViKhoan;
        HeSoKhoan = heSoKhoan;
        DinhMucLaoDong = dinhMucLaoDong;
        DonGia = donGia;
        this.nkslks = nkslks;
        this.dauMucCongViecs = dauMucCongViecs;
    }

    public String getMaCongViec() {
        return MaCongViec;
    }

    public void setMaCongViec(String maCongViec) {
        MaCongViec = maCongViec;
    }

    public String getTenCongViec() {
        return TenCongViec;
    }

    public void setTenCongViec(String tenCongViec) {
        TenCongViec = tenCongViec;
    }

    public float getDinhMucKhoan() {
        return DinhMucKhoan;
    }

    public void setDinhMucKhoan(float dinhMucKhoan) {
        DinhMucKhoan = dinhMucKhoan;
    }

    public String getDonViKhoan() {
        return DonViKhoan;
    }

    public void setDonViKhoan(String donViKhoan) {
        DonViKhoan = donViKhoan;
    }

    public float getHeSoKhoan() {
        return HeSoKhoan;
    }

    public void setHeSoKhoan(float heSoKhoan) {
        HeSoKhoan = heSoKhoan;
    }

    public float getDinhMucLaoDong() {
        return DinhMucLaoDong;
    }

    public void setDinhMucLaoDong(float dinhMucLaoDong) {
        DinhMucLaoDong = dinhMucLaoDong;
    }

    public float getDonGia() {
        return DonGia;
    }

    public void setDonGia(float donGia) {
        DonGia = donGia;
    }

    public List<NKSLK> getNkslks() {
        return nkslks;
    }

    public void setNkslks(List<NKSLK> nkslks) {
        this.nkslks = nkslks;
    }

    public List<DauMucCongViec> getDauMucCongViecs() {
        return dauMucCongViecs;
    }

    public void setDauMucCongViecs(List<DauMucCongViec> dauMucCongViecs) {
        this.dauMucCongViecs = dauMucCongViecs;
    }
}
