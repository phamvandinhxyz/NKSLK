package com.example.demo.response;

import java.util.List;

public class DataResponse<T> extends BaseResponse{

    private List<T> data;

    public DataResponse() {
        super();
    }

    public DataResponse(List<T> data) {
        this.data = data;
    }

    public DataResponse(boolean status, List<T> data) {
        super(status);
        this.data = data;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
