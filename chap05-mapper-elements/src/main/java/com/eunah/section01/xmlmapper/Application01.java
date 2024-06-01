package com.eunah.section01.xmlmapper;

import com.eunah.common.CategoryDTO;
import com.eunah.common.MenuAndCategoryDTO;
import com.eunah.common.MenuDTO;

import java.util.Scanner;

public class Application01 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ElementTestService elementTestService = new ElementTestService();

        do {
            System.out.println("==== 매퍼 element 테스트 메뉴 ====");
            System.out.println("1. <cache> 테스트");
            System.out.println("2. <resultMap> 서브 메뉴");
            System.out.println("3. <sql> 테스트");
            System.out.println("4. <insert> 서브 메뉴");
            System.out.println("번호를 입력해주세요. : ");
            int no = sc.nextInt();
            switch (no) {
                case 1:
                    elementTestService.selectCacheTest();
                    break;
                case 2:
                    resultMapSubMenu();
                    break;
                case 4:
                    insertSubMenu();
                    break;
            }


        } while (true);

    }

    private static void resultMapSubMenu() {
        Scanner sc = new Scanner(System.in);
        ElementTestService elementTestService = new ElementTestService();

        do {

            System.out.println("==== <resultMap> 서브 메뉴 ====");
            System.out.println("1. <resultMap> 테스트");
            System.out.println("2. <construction> 테스트");
            System.out.println("3. <association> 테스트");
            System.out.println("4. <collection> 테스트");
            System.out.println("메뉴 번호를 입력 해주세요 : ");
            int no = sc.nextInt();
            switch (no) {
                case 1:
                    elementTestService.selectResultMapTest();
                    break;
                case 2:
                    elementTestService.selectResultMapConstructorTest();
                    break;
                case 3:
                    elementTestService.selectResultMapAssociationTest();
                    break;
                case 4:
                    elementTestService.selectResultMapCollectionTest();
                    break;

            }

        } while (true);
    }

    private static void insertSubMenu() {
        Scanner sc = new Scanner(System.in);
        ElementTestService elementTestService = new ElementTestService();

        do {
            System.out.println("====== <insert> 서브 메뉴 ======");
            System.out.println("1. insert 테스트 (메뉴등록)");
            System.out.println("2. insert 테스트 (신규 카테고리의 메뉴 등록)");
            System.out.println("메뉴 번호를 입력 해주세요. : ");
            int no = sc.nextInt();
            switch (no) {
                case 1:
                    elementTestService.insertMenuTest(inputMenu());
                case 2:
                    elementTestService.insertCategoryAndMenuTest(inputMenuAndCategory());
                    break;

            }

        } while (true);
    }

    private static MenuDTO inputMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("등록할 메뉴 이름을 입력 해주세요 : ");
        String name = sc.nextLine();
        System.out.println("메뉴의 가격을 입력 해주세요 : ");
        int price = sc.nextInt();
        System.out.println("등록할 카테고리를 입력 해주세요 : ");
        int category = sc.nextInt();
        System.out.println("바로 판매 등록을 할까요? ( Y | N ) : ");
        sc.nextLine();
        String orderableStatus = sc.nextLine();

        MenuDTO menu = new MenuDTO();
        menu.setName(name);
        menu.setPrice(price);
        menu.setCategoryCode(category);
        menu.setOrderableStatus(orderableStatus);
        return menu;
    }

    private static MenuAndCategoryDTO inputMenuAndCategory() {

        Scanner scr = new Scanner(System.in);
        System.out.println("신규 카테고리 명을 입력 해주세요");
        String categoryName = scr.nextLine();
        System.out.println("등록할 메뉴 이름을 입력 해주세요 ");
        String menuName = scr.nextLine();
        System.out.println("메뉴의 가격을 입력 해주세요 ");
        int menuPrice = scr.nextInt();
        System.out.println("바로 판매 등록 할까요? ( Y , N )");
        scr.nextLine();
        String orderableStatus = scr.nextLine();


        MenuAndCategoryDTO menuAndCategoryDTO = new MenuAndCategoryDTO();
        CategoryDTO category = new CategoryDTO();

        menuAndCategoryDTO.setName(menuName);
        menuAndCategoryDTO.setPrice(menuPrice);
        menuAndCategoryDTO.setOrderableStatus(orderableStatus);
        category.setName(categoryName);

        menuAndCategoryDTO.setCategory(category);

        return menuAndCategoryDTO;

    }

}
