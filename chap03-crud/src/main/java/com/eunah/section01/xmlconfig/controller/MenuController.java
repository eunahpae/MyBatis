package com.eunah.section01.xmlconfig.controller;

import com.eunah.common.PrintResult;
import com.eunah.dto.MenuDTO;
import com.eunah.section01.xmlconfig.service.MenuService;

import java.util.List;
import java.util.Map;

public class MenuController {

    private final PrintResult printResult; // 결과 출력을 위한 PrintResult 객체
    private final MenuService menuService; // 메뉴 관련 로직을 처리하는 MenuService 객체

    public MenuController() {
        // PrintResult 및 MenuService 객체를 생성하여 초기화
        this.printResult = new PrintResult();
        this.menuService = new MenuService();
    }

    // 모든 메뉴 조회 메소드
    public void selectAllMenu() {
        // 모든 메뉴를 조회하고 그 결과를 출력

        List<MenuDTO> menuList = menuService.selectAllMenu();
        // MenuService 를 통해 모든 메뉴를 조회

        printResult.printMenuList(menuList);
        // 조회된 메뉴 목록 출력
    }

    // 특정 코드로 조회하는 메소드
    public void selectMenuByCode(Map<String, String> parameter) {
        // 매개변수로 받은 코드를 기반으로 메뉴를 조회하고 그 결과를 출력

        int code = Integer.parseInt(parameter.get("code"));
        // 매개변수로 받은 코드를 정수형으로 변환

        MenuDTO menu = menuService.selectMenuByCode(code);
        // MenuService 를 통해 특정 코드의 메뉴를 조회

        printResult.printMenu(menu);
        // 조회된 메뉴 출력
    }

    public void registMenu(Map<String, String> parameter) {

        MenuDTO menu = new MenuDTO();
        menu.setName(parameter.get("name"));
        menu.setPrice(Integer.parseInt(parameter.get("price")));
        menu.setCategoryCode(Integer.parseInt(parameter.get("categoryCode")));

        if (menuService.registMenu(menu)) {
            // 메뉴등록이 성공했을 때
            printResult.printSuccessMessage("insert");
        } else {
            // 메뉴등록이 실패했을 때
            printResult.printErrorMessage("insert");
        }


    }

    public void updateMenuByCode(Map<String, String> parameter) {

        MenuDTO menu = new MenuDTO();
        menu.setCode(Integer.parseInt(parameter.get("code")));
        menu.setName(parameter.get("name"));
        menu.setPrice(Integer.parseInt(parameter.get("price")));
        menu.setCategoryCode(Integer.parseInt(parameter.get("categoryCode")));
        menu.setOrderableStatus(parameter.get("orderableStatus"));

        if (menuService.updateMenuByCode(menu)) {
            printResult.printSuccessMessage("update");
        } else {
            printResult.printErrorMessage("update");
        }
    }

    // 특정 메뉴 코드를 입력받아 삭제하는 메소드
    public void deleteMenuByCode(Map<String, String> parameter) {
        // 매개변수로 받은 코드를 기반으로 메뉴를 삭제

        int code = Integer.parseInt(parameter.get("code"));
        // 매개변수로 받은 코드를 정수형으로 변환

        // MenuService 를 통해 특정 코드의 메뉴를 삭제
        if (menuService.deleteMenuByCode(code)) {
            printResult.printSuccessMessage("delete");
        } else {
            printResult.printErrorMessage("delete");
        }
    }
}