package com.eunah.section01.xml;

import com.eunah.common.MenuDTO;
import com.eunah.common.SearchCriteria;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.eunah.common.Template.getSqlSession;

public class MenuService {

    private DynamicSqlMapper mapper;

    public void selectMenuByPrice(int price) {
        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(DynamicSqlMapper.class);

        Map<String, Integer> map = new HashMap<>();
        map.put("price", price);
        List<MenuDTO> menuList = mapper.selectMenuByPrice(map);

        if (menuList != null && menuList.size() > 0) {
            for (MenuDTO menu : menuList) {
                System.out.println(menu);
            }
        } else {
            System.out.println("검색 결과가 없습니다. ");
        }
        sqlSession.close();
    }

    public void searchMenu(SearchCriteria searchCriteria) {
        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(DynamicSqlMapper.class);

        List<MenuDTO> menuList = mapper.searchMenu(searchCriteria);

        if (menuList != null && menuList.size() > 0) {
            for (MenuDTO menu : menuList) {
                System.out.println(menu);
            }
        } else {
            System.out.println("검색 결과가 없습니다. ");
        }
        sqlSession.close();
    }
}
