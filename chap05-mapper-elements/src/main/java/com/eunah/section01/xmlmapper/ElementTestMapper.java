package com.eunah.section01.xmlmapper;

import com.eunah.common.CategoryAndMenuDTO;
import com.eunah.common.MenuAndCategoryDTO;
import com.eunah.common.MenuDTO;

import java.util.List;

public interface ElementTestMapper {

    List<String> selectCacheTest();
    List<MenuDTO> selectResultMapTest();
    List<MenuDTO> selectResultMapConstructorTest();
    List<MenuAndCategoryDTO> selectResultMapAssociationTest();
    List<CategoryAndMenuDTO> selectResultMapCollectionTest();
}

