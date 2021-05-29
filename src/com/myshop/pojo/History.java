package com.myshop.pojo;

public class History{
    private Integer userId;
    private Integer goodId;
    private String name;
    private Integer type;
    private String time;

    public History() {
    }

    public History(Integer userId, Integer goodId, String name, Integer type, String time) {
        this.userId = userId;
        this.goodId = goodId;
        this.name = name;
        this.type = type;
        this.time = time;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "History{" +
                "userId=" + userId +
                ", goodId=" + goodId +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", time='" + time + '\'' +
                '}';
    }
}
