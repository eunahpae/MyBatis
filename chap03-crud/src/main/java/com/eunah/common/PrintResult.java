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

    public void printSuccessMessage(String code) {
        String message = null;
        switch (code) {
            case "insert":
                message = "메뉴 등록 성공";
                break;
            case "update":
                message = "메뉴 수정 성공";
                break;
            case "delete":
                message = "메뉴 삭제 성공";
                break;
            default:
                message = "잘못된 처리";
                break;
        }
        System.out.println(message);
    }

    public void printErrorMessage(String code) {
        String message = null;
        switch (code) {
            case "insert":
                message = "메뉴 등록 실패";
                break;
            case "update":
                message = "메뉴 수정 실패";
                break;
            case "delete":
                message = "메뉴 삭제 실패";
                break;
            default:
                message = "잘못된 처리";
                break;
        }
        System.out.println(message);
    }
}
