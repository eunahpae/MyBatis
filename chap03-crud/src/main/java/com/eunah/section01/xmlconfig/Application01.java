package com.eunah.section01.xmlconfig;

import com.eunah.section01.xmlconfig.controller.MenuController;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Application01 {

    // 전역에서 사용할 수 있도록 정적필드(static)로 초기화
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        /*
         * CRUD 3가지 방식 연습
         *
         * 1. xml 방식
         * 2. java 방식
         * 3. 혼합 방식
         */

        MenuController menuController = new MenuController();

        do {
            System.out.println("============ 메뉴 관리 시스템");
            System.out.println("1. 메뉴 전체 조회");
            System.out.println("2. 메뉴 코드로 메뉴 조회");
            System.out.println("3. 신규 메뉴 추가");
            System.out.println("4. 메뉴 수정");
            System.out.println("5. 메뉴 삭제");
            System.out.println("메뉴 번호를 입력 해주세요. : ");
            int no = sc.nextInt();
            sc.nextLine();

            switch (no) {
                case 1:
                    menuController.selectAllMenu();
                    break;
                case 2:
                    menuController.selectMenuByCode(inputMenuCode());
                    break;
                case 3:
                    menuController.registMenu(inputMenu());
                    break;
                case 4:
                    menuController.updateMenuByCode(inputMenuCodeForUpdate());
                    break;
                case 5:
                    menuController.deleteMenuByCode(inputMenuCode());
                    break;
            }
        } while (true);
    }

    // 입력받은 특정 메뉴 코드를 Map<>으로 초기화 반환 (메뉴 조회, 삭제 시 사용)
    private static Map<String, String> inputMenuCode() {

        System.out.println("메뉴 코드를 입력하세요. : ");
        String code = sc.nextLine();

        // HashMap 은 키-값 쌍으로 데이터를 저장하는 자료구조.
        // "code" 키에는 입력받은 코드가 저장된다.
        // 이렇게 하면 각 데이터를 고유한 키를 통해 쉽게 접근할 수 있다.
        Map<String, String> parameter = new HashMap<>();
        parameter.put("code", code);

        return parameter;
    }

    // 입력받은 내용을 Map<>으로 초기화 반환 (메뉴 삽입 시 사용)
    public static Map<String, String> inputMenu() {

        System.out.println("메뉴 이름을 입력해주세요. : ");
        String name = sc.nextLine();
        System.out.println("메뉴 가격을 입력해주세요. : ");
        String price = sc.nextLine();
        System.out.println("카테고리 코드를 입력해주세요. : ");
        String categoryCode = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("name", name);
        parameter.put("price", price);
        parameter.put("categoryCode", categoryCode);

        return parameter;
    }

    // 입력받은 코드에 해당하는 열의 변경하고자 하는 값을 입력받아 Map<>으로 초기화 반환 (메뉴 업데이트 시 사용)
    private static Map<String, String> inputMenuCodeForUpdate() {
        System.out.println("변경할 메뉴 코드를 입력하세요: ");
        String code = sc.nextLine();

        System.out.println("변경할 이름을 입력하세요: ");
        String name = sc.nextLine();

        System.out.println("변경할 가격을 입력하세요: ");
        String price = sc.nextLine();

        System.out.println("변경할 카테고리 코드를 입력하세요: ");
        String categoryCode = sc.nextLine();

        System.out.println("변경할 주문 가능 상태를 입력하세요 (Y/N): ");
        String orderableStatus = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("code", code);
        parameter.put("name", name);
        parameter.put("price", price);
        parameter.put("categoryCode", categoryCode);
        parameter.put("orderableStatus", orderableStatus);

        return parameter;
    }
}
