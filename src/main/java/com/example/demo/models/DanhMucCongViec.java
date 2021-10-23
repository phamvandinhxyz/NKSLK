package com.example.demo.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class DanhMucCongViec {
    @Id
    private String MaCongViec;
    private String TenCongViec;
    private long DinhMucKhoan;
    private String DonViKhoan;
    private long HeSoKhoan;
    private long DinhMucLaoDong;
    private long DonGia;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "DanhMucCongViecDaLam")
    private List<NKSLK> nkslks;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "DanhMucCongViec")
    private List<DauMucCongViec> dauMucCongViecs;

    public DanhMucCongViec() {
        super();
    }

    public DanhMucCongViec(String maCongViec, String tenCongViec, long dinhMucKhoan, String donViKhoan, long heSoKhoan, long dinhMucLaoDong, long donGia, List<NKSLK> nkslks, List<DauMucCongViec> dauMucCongViecs) {
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

    public long getDinhMucKhoan() {
        return DinhMucKhoan;
    }

    public void setDinhMucKhoan(long dinhMucKhoan) {
        DinhMucKhoan = dinhMucKhoan;
    }

    public String getDonViKhoan() {
        return DonViKhoan;
    }

    public void setDonViKhoan(String donViKhoan) {
        DonViKhoan = donViKhoan;
    }

    public long getHeSoKhoan() {
        return HeSoKhoan;
    }

    public void setHeSoKhoan(long heSoKhoan) {
        HeSoKhoan = heSoKhoan;
    }

    public long getDinhMucLaoDong() {
        return DinhMucLaoDong;
    }

    public void setDinhMucLaoDong(long dinhMucLaoDong) {
        DinhMucLaoDong = dinhMucLaoDong;
    }

    public long getDonGia() {
        return DonGia;
    }

    public void setDonGia(long donGia) {
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
