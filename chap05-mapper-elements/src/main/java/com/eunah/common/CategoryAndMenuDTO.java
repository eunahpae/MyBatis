package com.eunah.common;

import java.util.List;

public class CategoryAndMenuDTO {

    private int code;
    private String name;
    private int refCategoryCode;
    private List<MenuDTO> menuList;

    public CategoryAndMenuDTO() {
    }

    public CategoryAndMenuDTO(int code, String name, int refCategoryCode, List<MenuDTO> menuList) {
        this.code = code;
        this.name = name;
        this.refCategoryCode = refCategoryCode;
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

    public int getRefCategoryCode() {
        return refCategoryCode;
    }

    public void setRefCategoryCode(int refCategoryCode) {
        this.refCategoryCode = refCategoryCode;
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
                ", refCategoryCode=" + refCategoryCode +
                ", menuList=" + menuList +
                '}';
    }
}
