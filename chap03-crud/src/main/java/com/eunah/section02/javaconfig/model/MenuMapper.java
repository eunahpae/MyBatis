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

    @Update("UPDATE TBL_MENU " +
            "SET " +
            "MENU_NAME = #{name}, " +
            "MENU_PRICE = #{price}, " +
            "CATEGORY_CODE = #{categoryCode}, " +
            "ORDERABLE_STATUS = #{orderableStatus} " +
            "WHERE MENU_CODE = #{code}")
    int updateMenuByCode(MenuDTO menu);


    @Delete("DELETE FROM TBL_MENU " +
            "WHERE MENU_CODE = #{ code }")
    int deleteMenuByCode(int code);
}
