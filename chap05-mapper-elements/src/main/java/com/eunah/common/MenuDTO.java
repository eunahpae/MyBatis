package com.eunah.common;

public class MenuDTO {

    private int code;
    private String name;
    private int price;
    private int cateogryCode;
    private String orderableStatus;

    public MenuDTO() {
    }

    public MenuDTO(int code, String name, int price, int cateogryCode, String orderableStatus) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.cateogryCode = cateogryCode;
        this.orderableStatus = orderableStatus;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCateogryCode() {
        return cateogryCode;
    }

    public void setCateogryCode(int cateogryCode) {
        this.cateogryCode = cateogryCode;
    }

    public String getOrderableStatus() {
        return orderableStatus;
    }

    public void setOrderableStatus(String orderableStatus) {
        this.orderableStatus = orderableStatus;
    }

    @Override
    public String toString() {
        return "MenuDTO{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", cateogryCode=" + cateogryCode +
                ", orderableStatus='" + orderableStatus + '\'' +
                '}';
    }
}
