package com.example.demo.models.customs;

import com.example.demo.models.CongNhan;
import com.example.demo.models.DanhMucCongNhan;
import com.example.demo.models.DanhMucCongViec;
import com.example.demo.models.NKSLK;

import java.util.List;

public class ThongTinNKSLK {
    private NKSLK nkslk;
    private DanhMucCongViec danhMucCongViec;
    private List<CongNhan> congNhans;

    public ThongTinNKSLK() {
        super();
    }

    public ThongTinNKSLK(NKSLK nkslk, DanhMucCongViec danhMucCongViec, List<CongNhan> congNhans) {
        this.nkslk = nkslk;
        this.danhMucCongViec = danhMucCongViec;
        this.congNhans = congNhans;
    }

    public NKSLK getNkslk() {
        return nkslk;
    }

    public void setNkslk(NKSLK nkslk) {
        this.nkslk = nkslk;
    }

    public DanhMucCongViec getDanhMucCongViec() {
        return danhMucCongViec;
    }

    public void setDanhMucCongViec(DanhMucCongViec danhMucCongViec) {
        this.danhMucCongViec = danhMucCongViec;
    }

    public List<CongNhan> getCongNhans() {
        return congNhans;
    }

    public void setCongNhans(List<CongNhan> congNhans) {
        this.congNhans = congNhans;
    }
}
