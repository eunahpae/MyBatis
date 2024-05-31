package com.eunah.section01.xml;

import com.eunah.common.SearchCriteria;

import java.util.Scanner;

public class Application01 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("====== 마이바티스 동적 SQL ======");
            System.out.println("1. if 확인하기");
            System.out.println("2. choose(when,otherwise) 확인하기");
            System.out.println("3. foreach 확인하기");
            System.out.println("4. trim(where,set) 확인하기");
            System.out.println("9. 종료 하기");
            System.out.println("메뉴를 선택해주세요 : ");
            int no = sc.nextInt();

            switch (no) {
                case 1:
                    ifSubMenu();
                    break;
                case 2:
                    chooseSubMenu();
                    break;
                case 9:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못된 번호입니다.");
                    break;
            }
        } while (true);
    }

    private static void ifSubMenu() {

        Scanner sc = new Scanner(System.in);
        MenuService menuService = new MenuService();

        do {
            System.out.println("======== if 메뉴 ========");
            System.out.println("1. 원하는 금액대의 적합한 추천 메뉴 목록 보여주기");
            System.out.println("2. 메뉴이름 혹은 카테고리 명으로 검색하여 메뉴 목록 보여주기");
            System.out.println("9. 이전 메뉴로");
            System.out.println("메뉴 번호를 입력 해주세요 : ");
            int no = sc.nextInt();
            switch (no) {
                case 1:
                    menuService.selectMenuByPrice(inputPrice());
                    break;
                case 2:
                    menuService.searchMenu(inputSearchChriteria());
                    break;
                case 9:
                    return;
                default:
                    System.out.println("잘못된 번호입니다.");
                    break;
            }

        } while (true);
    }

    private static void chooseSubMenu() {

    }

    private static int inputPrice() {
        Scanner sc = new Scanner(System.in);
        System.out.println("검색하실 가격의 최대 금액을 입력해주세요. : ");
        int price = sc.nextInt();
        return price;
    }

    private static SearchCriteria inputSearchChriteria() {
        Scanner sc = new Scanner(System.in);
        System.out.println("검색 기준을 입력해주세요. (name or category) : ");
        String condition = sc.nextLine();
        System.out.println("검색어를 입력 해주세요. : ");
        String value = sc.nextLine();

        return new SearchCriteria(condition, value);
    }
}
