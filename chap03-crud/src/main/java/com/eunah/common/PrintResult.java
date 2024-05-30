package com.eunah.common;

import com.eunah.dto.MenuDTO;

import java.util.List;

public class PrintResult {

    // 전체 메뉴를 출력하는 메소드
    public void printMenuList(List<MenuDTO> menuList) {

        // 주어진 메뉴 목록을 반복하여 전체 메뉴를 출력
        for (MenuDTO menu : menuList) {
            System.out.println(menu);
        }
    }

    // 메뉴 출력 메소드
    public void printMenu(MenuDTO menuDTO) {

        // 특정 메뉴 출력
        System.out.println(menuDTO);
    }

    // 결과메시지 반환 메소드 - 성공
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

    // 결과메시지 반환 메소드 - 실패
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
