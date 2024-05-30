package com.eunah.section01.xmlconfig.service;

import com.eunah.dto.MenuDTO;
import com.eunah.section01.xmlconfig.model.MenuDAO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.eunah.common.Template.getSqlSession;

public class MenuService {

    private final MenuDAO menuDAO; // MenuDAO 객체를 저장하는 멤버 변수

    public MenuService() {
        // MenuDAO 객체를 생성하여 초기화
        this.menuDAO = new MenuDAO();
    }

    // 모든 메뉴를 조회하는 메소드
    public List<MenuDTO> selectAllMenu() {
        // MenuDAO 를 통해 모든 메뉴를 조회하고 그 결과를 반환

        SqlSession sqlSession = getSqlSession();
        // SQL 세션 획득

        List<MenuDTO> menuList = menuDAO.selectAllMenu(sqlSession);
        // MenuDAO 를 통해 모든 메뉴를 조회

        sqlSession.close();
        // SQL 세션 종료

        return menuList;
        // 조회된 메뉴 목록을 반환
    }

    // 특정 코드로 조회하는 메소드
    public MenuDTO selectMenuByCode(int code) {
        // 매개변수로 받은 코드를 기반으로 메뉴를 조회하고 그 결과를 반환

        SqlSession sqlSession = getSqlSession();
        // SQL 세션을 획득

        MenuDTO menu = menuDAO.selectMenuByCode(sqlSession, code);
        // MenuDAO 를 통해 특정 코드의 메뉴를 조회

        sqlSession.close();
        // SQL 세션 종료

        return menu;
        // 조회된 메뉴를 반환
    }

    public boolean registMenu(MenuDTO menu) {

        SqlSession sqlSession = getSqlSession();

        int result = menuDAO.insertMenu(sqlSession, menu);

        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();
        return result > 0 ? true : false;
    }
}