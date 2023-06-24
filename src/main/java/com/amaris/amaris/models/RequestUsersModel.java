package com.amaris.amaris.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class RequestUsersModel {

    @JsonProperty("status")
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<UserModel> getData() {
        return data;
    }

    public void setData(List<UserModel> data) {
        this.data = data;
    }

    @JsonProperty("message")
    private String message;

    @JsonProperty("data")
    private List<UserModel> data;
}
