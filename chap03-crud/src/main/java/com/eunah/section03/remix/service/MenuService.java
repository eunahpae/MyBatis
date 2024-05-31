package com.eunah.section03.remix.service;

import com.eunah.dto.MenuDTO;
import com.eunah.section03.remix.model.MenuMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.eunah.common.Template.getRemixSqlSession;

public class MenuService {

    private MenuMapper menuMapper;

    public List<MenuDTO> selectAllMenu() {
        SqlSession sqlSession = getRemixSqlSession();
        menuMapper = sqlSession.getMapper(MenuMapper.class);
        List<MenuDTO> menuList = menuMapper.selectAllMenu();
        sqlSession.close();
        return menuList;
    }

    public MenuDTO selectMenuByCode(int code) {
        SqlSession sqlSession = getRemixSqlSession();
        menuMapper = sqlSession.getMapper(MenuMapper.class);
        MenuDTO menu = menuMapper.selectMenuByCode(code);
        sqlSession.close();
        return menu;
    }

    public boolean registMenu(MenuDTO menu) {
        SqlSession sqlSession = getRemixSqlSession();
        menuMapper = sqlSession.getMapper(MenuMapper.class);
        int result = menuMapper.registMenu(menu);

        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();
        return result > 0 ? true : false;
    }


    public boolean updateMenuByCode(MenuDTO menu) {
        SqlSession sqlSession = getRemixSqlSession();
        menuMapper = sqlSession.getMapper(MenuMapper.class);
        int result = menuMapper.updateMenuByCode(menu);

        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();
        return result > 0 ? true : false;
    }

    public boolean deleteMenuByCode(int code) {
        SqlSession sqlSession = getRemixSqlSession();
        menuMapper = sqlSession.getMapper(MenuMapper.class);
        int result = menuMapper.deleteMenuByCode(code);

        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();
        return result > 0 ? true : false;
    }
}
