package com.eunah.section01.xmlconfig.controller;

import com.eunah.common.PrintResult;
import com.eunah.dto.MenuDTO;
import com.eunah.section01.xmlconfig.service.MenuService;

import java.util.List;
import java.util.Map;

public class MenuController {

    private final PrintResult printResult; // 결과 출력을 위한 PrintResult 객체
    private final MenuService menuService; // 메뉴 관련 비즈니스 로직을 처리하는 MenuService 객체

    public MenuController() {
        // PrintResult 및 MenuService 객체를 생성하여 초기화
        this.printResult = new PrintResult();
        this.menuService = new MenuService();
    }

    // 모든 메뉴를 조회하는 메소드
    public void selectAllMenu() {
        // 모든 메뉴를 조회하고 그 결과를 출력

        List<MenuDTO> menuList = menuService.selectAllMenu();
        // MenuService를 통해 모든 메뉴를 조회

        printResult.printMenuList(menuList);
        // 조회된 메뉴 목록 출력
    }

    // 특정 코드로 메뉴를 조회하는 메소드
    public void selectMenuByCode(Map<String, String> parameter) {
        // 매개변수로 받은 코드를 기반으로 메뉴를 조회하고 그 결과를 출력

        int code = Integer.parseInt(parameter.get("code"));
        // 매개변수로 받은 코드를 정수형으로 변환

        MenuDTO menu = menuService.selectMenuByCode(code);
        // MenuService를 통해 특정 코드의 메뉴를 조회

        printResult.printMenu(menu);
        // 조회된 메뉴 출력
    }
}