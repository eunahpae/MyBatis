package com.eunah.common;

import java.util.List;

public class CategoryAndMenuDTO {

    private int code;
    private String name;
    private int refCategory;
    private List<MenuDTO> menuList;

    public CategoryAndMenuDTO() {
    }

    public CategoryAndMenuDTO(int code, String name, int refCategory, List<MenuDTO> menuList) {
        this.code = code;
        this.name = name;
        this.refCategory = refCategory;
        this.menuList = menuList;
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

    public int getRefCategory() {
        return refCategory;
    }

    public void setRefCategory(int refCategory) {
        this.refCategory = refCategory;
    }

    public List<MenuDTO> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<MenuDTO> menuList) {
        this.menuList = menuList;
    }

    @Override
    public String toString() {
        return "CategoryAndMenuDTO{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", refCategory=" + refCategory +
                ", menuList=" + menuList +
                '}';
    }
}
