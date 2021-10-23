package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class DauMucCongViec {
    @Id
    private String MaCongViec;
    private String SanLuongThucTeDatDuoc;
    private String SoLoSanPham;

    public DauMucCongViec() {
        super();
    }

    public DauMucCongViec(String maCongViec, String sanLuongThucTeDatDuoc, String soLoSanPham) {
        MaCongViec = maCongViec;
        SanLuongThucTeDatDuoc = sanLuongThucTeDatDuoc;
        SoLoSanPham = soLoSanPham;
    }

    public String getMaCongViec() {
        return MaCongViec;
    }

    public void setMaCongViec(String maCongViec) {
        MaCongViec = maCongViec;
    }

    public String getSanLuongThucTeDatDuoc() {
        return SanLuongThucTeDatDuoc;
    }

    public void setSanLuongThucTeDatDuoc(String sanLuongThucTeDatDuoc) {
        SanLuongThucTeDatDuoc = sanLuongThucTeDatDuoc;
    }

    public String getSoLoSanPham() {
        return SoLoSanPham;
    }

    public void setSoLoSanPham(String soLoSanPham) {
        SoLoSanPham = soLoSanPham;
    }
}
