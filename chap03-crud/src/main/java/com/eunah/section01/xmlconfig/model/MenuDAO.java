package com.eunah.section01.xmlconfig.model;

import com.eunah.dto.MenuDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

    /*
    * DAO (Data Access Object)
    *
    * 데이터베이스의 data 에 접근하기 위한 객체이며, 데이터베이스 접근을 하기 위한
    * 로직과 비즈니스 로직을 분리하기 위해 사용한다.
    * 사용자는 자신이 필요한 interface 를 DAO 에게 던지고
    * DAO는 이 interface를 구현한 객체를 사용자에게 편리하게 사용할 수 있도록 반환한다.
    */

// 데이터베이스와 연결될 메소드를 가지고 있는 클래스
public class MenuDAO {

    // MenuMapper.xml 파일에서 해당 이름의 쿼리를 실행
    // 모든 메뉴 조회 쿼리 실행 후 결과 반환
    public List<MenuDTO> selectAllMenu(SqlSession sqlSession) {
        return sqlSession.selectList("MenuMapper.selectAllMenu");
    }

    // 특정 코드를 입력받아 해당 메뉴 조회 쿼리 실행 후 결과 반환
    public MenuDTO selectMenuByCode(SqlSession sqlSession, int code) {
        return sqlSession.selectOne("MenuMapper.selectMenuByCode", code);
    }

    // 메뉴 추가 삽입 쿼리 실행 후 결과 반환
    public int insertMenu(SqlSession sqlSession, MenuDTO menu) {
        return sqlSession.insert("MenuMapper.insertMenu", menu);
    }

    // 특정 코드를 입력받아 해당 메뉴 삭제 쿼리 실행 후 결과 반환
    public int deleteMenuByCode(SqlSession sqlSession, int code) {
        return sqlSession.delete("MenuMapper.deleteMenuByCode", code);
    }

    // 특정 코드를 입력받아 해당 메뉴의 값 변경 쿼리 실행 후 결과 반환
    public int updateMenuByCode(SqlSession sqlSession, MenuDTO menu) {
        return sqlSession.update("MenuMapper.updateMenuByCode", menu);
    }
}