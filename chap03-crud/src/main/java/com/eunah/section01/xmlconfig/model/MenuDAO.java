package com.eunah.section01.xmlconfig.model;

import com.eunah.dto.MenuDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

// 데이터베이스와 연결될 메소드를 가지고 있는 클래스
public class MenuDAO {

    // 모든 메뉴를 조회하는 메소드
    public List<MenuDTO> selectAllMenu(SqlSession sqlSession) {
        return sqlSession.selectList("MenuMapper.selectAllMenu");
        // MenuMapper.xml 파일에서 "selectAllMenu" 쿼리를 실행하여 모든 메뉴를 조회
    }

    // 특정 코드를 입력받아 해당 메뉴를 조회하는 메소드
    public MenuDTO selectMenuByCode(SqlSession sqlSession, int code) {
        return sqlSession.selectOne("MenuMapper.selectMenuByCode", code);
        // MenuMapper.xml 파일에서 "selectMenuByCode" 쿼리를 실행하여 특정 코드의 메뉴를 조회
    }

    // 메뉴를 추가하는 삽입 메소드
    public int insertMenu(SqlSession sqlSession, MenuDTO menu) {
        return sqlSession.insert("MenuMapper.insertMenu", menu);
        // MenuMapper.xml 파일에서 "insertMenu" 쿼리를 실행하여 모든 메뉴를 조회
    }

    // 특정 코드를 입력받아 해당 메뉴를 삭제하는 메소드
    public int deleteMenuByCode(SqlSession sqlSession, int code) {
        return sqlSession.delete("MenuMapper.deleteMenuByCode", code);
        // MenuMapper.xml 파일에서 "deleteMenuByCode" 쿼리를 실행하여 모든 메뉴를 조회
    }

    // 특정 코드를 입력받아 해당 메뉴의 값을 변경하는 메소드
    public int updateMenuByCode(SqlSession sqlSession, MenuDTO menu) {
        return sqlSession.update("MenuMapper.updateMenuByCode", menu);
        // MenuMapper.xml 파일에서 "updateMenuByCode" 쿼리를 실행하여 모든 메뉴를 조회
    }
}