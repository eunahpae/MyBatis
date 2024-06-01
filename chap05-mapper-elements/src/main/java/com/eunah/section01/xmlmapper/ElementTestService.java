package com.eunah.section01.xmlmapper;

import com.eunah.common.CategoryAndMenuDTO;
import com.eunah.common.MenuAndCategoryDTO;
import com.eunah.common.MenuDTO;
import com.eunah.common.Template;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ElementTestService {

    private ElementTestMapper mapper;

    public void selectCacheTest() {
        SqlSession sqlSession = Template.getSqlSession();
        mapper = sqlSession.getMapper(ElementTestMapper.class);
        /* 필기. 최초 요청 시에는 시간이 걸리지만 그 이후에는 캐싱된 데이터를 불러오기 때문에 속도가 빠르다. */
        for (int i = 0; i < 10; i++) {
            Long startTime = System.currentTimeMillis(); // 시작시간

            List<String> nameList = mapper.selectCacheTest();
            System.out.println(nameList);

            Long endTime = System.currentTimeMillis();  // 종료시간

            Long interval = endTime - startTime;
            System.out.println("수행 시간 : " + interval + "(ms)");
        }
        sqlSession.close();
    }


    public void selectResultMapTest() {
        SqlSession sqlSession = Template.getSqlSession();
        mapper = sqlSession.getMapper(ElementTestMapper.class);

        List<MenuDTO> menuList = mapper.selectResultMapTest();

        for (MenuDTO menu : menuList) {
            System.out.println(menu);
        }
        sqlSession.close();
    }

    public void selectResultMapConstructorTest() {

        SqlSession sqlSession = Template.getSqlSession();
        mapper = sqlSession.getMapper(ElementTestMapper.class);

        List<MenuDTO> menuList = mapper.selectResultMapConstructorTest();

        for (MenuDTO menu : menuList) {
            System.out.println(menu);
        }
        sqlSession.close();
    }

    public void selectResultMapAssociationTest() {

        SqlSession sqlSession = Template.getSqlSession();
        mapper = sqlSession.getMapper(ElementTestMapper.class);

        List<MenuAndCategoryDTO> menuList = mapper.selectResultMapAssociationTest();

        for (MenuAndCategoryDTO menu : menuList) {
            System.out.println(menu);
        }
        sqlSession.close();
    }

    public void selectResultMapCollectionTest() {
        SqlSession sqlSession = Template.getSqlSession();
        mapper = sqlSession.getMapper(ElementTestMapper.class);

        List<CategoryAndMenuDTO> menuList = mapper.selectResultMapCollectionTest();

        for (CategoryAndMenuDTO menu : menuList) {
            System.out.println(menu);
        }
        sqlSession.close();
    }

    public void insertMenuTest(MenuDTO menuDTO) {
        SqlSession sqlSession = Template.getSqlSession();
        mapper = sqlSession.getMapper(ElementTestMapper.class);

        int result = mapper.insertMenuTest(menuDTO);
        if (result > 0) {
            System.out.println("메뉴 등록 성공");
            sqlSession.commit();
        } else {
            System.out.println("메뉴 등록 실패");
            sqlSession.rollback();
        }
        sqlSession.close();

    }

    public void insertCategoryAndMenuTest(MenuAndCategoryDTO menuAndCategoryDTO) {

        SqlSession sqlSession = Template.getSqlSession();
        mapper = sqlSession.getMapper(ElementTestMapper.class);

        int result1 = mapper.insertNewCategory(menuAndCategoryDTO);
        int result2 = mapper.insertNewMenu(menuAndCategoryDTO);


        if (result1 > 0 && result2 > 0) {
            System.out.println("신규 카테고리와 메뉴 등록 성공");
            sqlSession.commit();
        } else {
            System.out.println("신규 카테고리와 메뉴 등록 실패");
            sqlSession.rollback();
        }
        sqlSession.close();

    }
}
