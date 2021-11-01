package com.example.demo.models.customs;

public class WorkDayResult {
    private String MaCongNhan;
    private String HoTen;
    private float TongNgayCong;

    public WorkDayResult() {
        super();
    }

    public WorkDayResult(String maCongNhan, String hoTen, float tongNgayCong) {
        MaCongNhan = maCongNhan;
        HoTen = hoTen;
        TongNgayCong = tongNgayCong;
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

    public float getTongNgayCong() {
        return TongNgayCong;
    }

    public void setTongNgayCong(float tongNgayCong) {
        TongNgayCong = tongNgayCong;
    }
}
