package com.eunah.section03.remix;

import com.eunah.section03.remix.controller.MenuController;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
* 흐름 정리)
*
* 1. Application(Front) 에서 사용자의 입력을 받는다.
* 2. MenuController 에서 사용자의 요청을 받아, MenuService 에게 실행 요청을 한다.
* 3. MenuService 는 MenuMapper(DB) 를 통해 요청한 결과값을 전달받는다.
* 4. MenuService 에서의 결과값을 호출위치인 MenuController 로 다시 반환한다.
* 5. 반환받은 값으로 PrintResult 클래스의 메소드를 실행하여 사용자에게 결과값을 출력해준다.
*/

/*
* MyBatis 의 XML+Java 혼합 방법을 사용하면 SQL 과 Java 로직을 깔끔하게 분리할 수 있다.
* SQL 문은 XML 파일로 resources 디렉토리에 정의되어 관리 및 업데이트가 쉽다.
* Java 인터페이스 또는 클래스는 이러한 SQL 문을 메소드에 매핑하는 데 사용되어 데이터베이스와 상호 작용한다.
* 이 접근 방식은 특히 복잡한 애플리케이션에서 코드베이스의 가독성을 향상시켜 유지보수에 유리하다.
*/


public class Application01 {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

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
                default:
                    System.out.println("잘못된 번호를 선택 하셨습니다. "); break;
            }
        } while (true);
    }

    private static Map<String, String> inputMenuCode() {
        System.out.println("메뉴 코드를 입력해주세요. : ");
        String code = sc.nextLine();
        Map<String, String> parameter = new HashMap<>();
        parameter.put("code", code);

        return parameter;
    }

    private static Map<String, String> inputMenu() {
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
