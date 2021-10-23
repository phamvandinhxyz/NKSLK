package com.example.demo.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class DanhMucCongNhan {
    @Id
    private String MaDanhMucCongNhan;
    private String TenDanhMuc;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "DanhMucNhanCong")
    private List<NKSLK> nkslks;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "MaDanhMucCongNhan")
    private List<CongNhan> congNhans;

    public DanhMucCongNhan() {
        super();
    }

    public DanhMucCongNhan(String maDanhMucCongNhan, String tenDanhMuc, List<NKSLK> nkslks, List<CongNhan> congNhans) {
        MaDanhMucCongNhan = maDanhMucCongNhan;
        TenDanhMuc = tenDanhMuc;
        this.nkslks = nkslks;
        this.congNhans = congNhans;
    }

    public String getMaDanhMucCongNhan() {
        return MaDanhMucCongNhan;
    }

    public void setMaDanhMucCongNhan(String maDanhMucCongNhan) {
        MaDanhMucCongNhan = maDanhMucCongNhan;
    }

    public String getTenDanhMuc() {
        return TenDanhMuc;
    }

    public void setTenDanhMuc(String tenDanhMuc) {
        TenDanhMuc = tenDanhMuc;
    }

    public List<NKSLK> getNkslks() {
        return nkslks;
    }

    public void setNkslks(List<NKSLK> nkslks) {
        this.nkslks = nkslks;
    }

    public List<CongNhan> getCongNhans() {
        return congNhans;
    }

    public void setCongNhans(List<CongNhan> congNhans) {
        this.congNhans = congNhans;
    }
}
