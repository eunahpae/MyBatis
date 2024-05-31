package com.eunah.section03.remix.model;

import com.eunah.dto.MenuDTO;

import java.util.List;

public interface MenuMapper {

    List<MenuDTO> selectAllMenu();

    MenuDTO selectMenuByCode(int code);

    int registMenu(MenuDTO menu);

    int updateMenuByCode(MenuDTO menu);

    int deleteMenuByCode(int code);
}
