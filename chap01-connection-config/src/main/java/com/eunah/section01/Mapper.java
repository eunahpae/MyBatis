package com.eunah.section01;

import org.apache.ibatis.annotations.Select;

import java.util.Date;

public interface Mapper {

    @Select("SELECT CURDATE() FROM DUAL")
    Date selectSysDate();


}
