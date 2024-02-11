package com.example.adminbooking.Models;

public class IdDetails {
    int id;
    String num;
    String first;
    String second;
    String orderId;

    public IdDetails() {

    }

    public IdDetails(int id, String num, String first, String second, String orderId) {
        this.id = id;
        this.num = num;
        this.first = first;
        this.second = second;
        this.orderId = orderId;
    }

    public IdDetails(String num, String first, String second, String orderId) {
        this.num = num;
        this.first = first;
        this.second = second;
        this.orderId = orderId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getSecond() {
        return second;
    }

    public void setSecond(String second) {
        this.second = second;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
