package com.eunah.section02.javaconfig.model;

import com.eunah.dto.MenuDTO;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface MenuMapper {

    @Results(id = "menuResultMap", value = {
            @Result(id = true, property = "code", column = "MENU_CODE"),
            @Result(property = "name", column = "MENU_NAME"),
            @Result(property = "price", column = "MENU_PRICE"),
            @Result(property = "categoryCode", column = "CATEGORY_CODE"),
            @Result(property = "orderableStatus", column = "ORDERABLE_STATUS")
    })
    @Select("SELECT " +
            "MENU_CODE," +
            "MENU_NAME," +
            "MENU_PRICE," +
            "CATEGORY_CODE, " +
            "ORDERABLE_STATUS " +
            "FROM TBL_MENU " +
            "WHERE ORDERABLE_STATUS = 'Y'")
    List<MenuDTO> selectAllMenu();


    @ResultMap("menuResultMap")
    @Select("SELECT " +
            "MENU_CODE," +
            "MENU_NAME," +
            "MENU_PRICE," +
            "CATEGORY_CODE, " +
            "ORDERABLE_STATUS " +
            "FROM TBL_MENU " +
            "WHERE ORDERABLE_STATUS = 'Y'" +
            "AND MENU_CODE = #{ code }")
    MenuDTO selectMenuByCode(int code);


    @ResultMap("menuResultMap")
    @Insert("INSERT INTO TBL_MENU(" +
            "MENU_NAME," +
            "MENU_PRICE," +
            "CATEGORY_CODE," +
            "ORDERABLE_STATUS" +
            ") VALUES (" +
            "#{ name }," +
            "#{ price }," +
            "#{ categoryCode }," +
            "'Y')")
    int registMenu(MenuDTO menu);
}
