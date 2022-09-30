package com.project.desafio_sportheca.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ResponseClient {

    @SerializedName("Object")
    private List<Object> objects = new ArrayList<>();
    @SerializedName("Status")
    private Integer status;

    public List<Object> getObjects() {
        return objects;
    }

    public void setObjects(List<Object> objects) {
        this.objects = objects;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Response{" +
                "objects=" + objects +
                ", status=" + status +
                '}';
    }
}
