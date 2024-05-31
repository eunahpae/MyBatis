package com.eunah.section01.xmlconfig.service;

import com.eunah.dto.MenuDTO;
import com.eunah.section01.xmlconfig.model.MenuDAO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.eunah.common.Template.getSqlSession;

public class MenuService {

    private final MenuDAO menuDAO; // MenuDAO 객체를 저장하는 멤버 변수

    public MenuService() {
        // 데이터베이스에 접근하기 위한 객체 MenuDAO 를 생성
        this.menuDAO = new MenuDAO();
    }

    // 모든 메뉴를 조회하는 메소드
    public List<MenuDTO> selectAllMenu() {
        // MenuDAO 를 통해 모든 메뉴를 조회하고 그 결과를 List<MenuDTO> 로 반환

        SqlSession sqlSession = getSqlSession();
        /* SQL 세션 획득
         * SQL 세션을 획득하는 이유는 MyBatis 를 사용하여 데이터베이스와 상호 작용하기 위해서이다.
         * MyBatis 는 데이터베이스와의 통신을 관리하고 SQL 쿼리를 실행하기 위해 SQL 세션을 사용 */

        List<MenuDTO> menuList = menuDAO.selectAllMenu(sqlSession);
        // MenuDAO 를 통해 모든 메뉴를 조회

        sqlSession.close();
        // SQL 세션 종료

        return menuList;
        // 조회된 메뉴 목록을 반환 (호출위치는 MenuController)
    }

    // 특정 코드로 조회하는 메소드
    public MenuDTO selectMenuByCode(int code) {
        // 매개변수로 받은 코드를 기반으로 메뉴를 조회하고 그 결과를 반환

        SqlSession sqlSession = getSqlSession();
        MenuDTO menu = menuDAO.selectMenuByCode(sqlSession, code);
        sqlSession.close();

        return menu;
        // 조회된 메뉴를 반환
    }

    // 메뉴 추가 삽입하는 메소드
    public boolean registMenu(MenuDTO menu) {

        SqlSession sqlSession = getSqlSession();

        int result = menuDAO.insertMenu(sqlSession, menu);
        // menuDAO 의 insertMenu 메소드를 호출하여 메뉴를 삽입하고, 그 결과를 result 에 저장

        if (result > 0) {
            // 삽입 결과가 성공적이면(즉, result 가 0보다 크면) 트랜잭션을 커밋
            sqlSession.commit();
        } else {
            // 삽입 결과가 실패하면(즉, result 가 0 이하이면) 트랜잭션을 롤백
            sqlSession.rollback();
        }

        sqlSession.close();

        // 실행 결과가 성공적이면 true 를, 실패하면 false 를 반환 (호출위치는 MenuController 의 insert 메소드의 if 조건문)
        return result > 0 ? true : false;
    }

    // 위 registMenu() 와 동일 방식으로 updateMenuByCode(), deleteMenuByCode() 작성

    // 특정 코드를 입력받아 해당 메뉴의 값을 수정하는 메소드
    public boolean updateMenuByCode(MenuDTO menu) {

        SqlSession sqlSession = getSqlSession();
        int result = menuDAO.updateMenuByCode(sqlSession, menu);

        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();

        return result > 0 ? true : false;
    }

    // 특정 코드를 입력받아 해당 메뉴를 삭제하는 메소드
    public boolean deleteMenuByCode(int code) {

        SqlSession sqlSession = getSqlSession();

        int result = menuDAO.deleteMenuByCode(sqlSession, code);

        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();
        return result > 0 ? true : false;
    }
}