package com.eunah.section01.xml;

import com.eunah.common.MenuDTO;
import com.eunah.common.SearchCriteria;

import java.util.List;
import java.util.Map;

public interface DynamicSqlMapper {

    List<MenuDTO> selectMenuByPrice(Map<String, Integer> map);

    List<MenuDTO> searchMenu(SearchCriteria searchCriteria);
}