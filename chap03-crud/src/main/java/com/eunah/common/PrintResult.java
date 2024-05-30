package com.eunah.common;

import com.eunah.dto.MenuDTO;

import java.util.List;

public class PrintResult {

    // 메뉴 목록을 출력하는 메소드
    public void printMenuList(List<MenuDTO> menuList) {
        // 주어진 메뉴 목록을 반복하여 각 메뉴를 출력

        for (MenuDTO menu : menuList) {
            System.out.println(menu);
            // 각 메뉴를 출력
        }
    }

    // 메뉴를 출력하는 메소드
    public void printMenu(MenuDTO menuDTO) {
        // 주어진 메뉴를 출력

        System.out.println(menuDTO);
        // 메뉴를 출력
    }
}
