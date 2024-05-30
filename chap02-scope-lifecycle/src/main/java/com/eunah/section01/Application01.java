package com.eunah.section01;

import static com.eunah.section01.Template.getSqlSession;

public class Application01 {
    public static void main(String[] args) {

        System.out.println(getSqlSession().hashCode());
        System.out.println(getSqlSession().hashCode());

    }
}
