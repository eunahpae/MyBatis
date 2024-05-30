package com.eunah.dto;

public class MenuDTO {

    private int code;
    private String name;
    private int price;
    private int categoryCOde;
    private String orderableStatus;

    public MenuDTO() {
    }

    public MenuDTO(int code, String name, int price, int categoryCOde, String orderableStatus) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.categoryCOde = categoryCOde;
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

    public int getCategoryCOde() {
        return categoryCOde;
    }

    public void setCategoryCOde(int categoryCOde) {
        this.categoryCOde = categoryCOde;
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
                ", categoryCOde=" + categoryCOde +
                ", orderableStatus='" + orderableStatus + '\'' +
                '}';
    }
}
