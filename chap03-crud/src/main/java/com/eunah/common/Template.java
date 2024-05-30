package com.eunah.common;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Template {

    private static SqlSessionFactory sqlSessionFactory; // SQL 세션 팩토리를 저장하는 정적 변수

    // SQL 세션을 반환하는 메소드
    public static SqlSession getSqlSession() {
        // SQL 세션을 반환

        if (sqlSessionFactory == null) {
            // SQL 세션 팩토리가 null 인 경우, 새로운 SQL 세션 팩토리를 생성
            // null 인 경우 MyBatis 의 Resources.getResourceAsStream() 메서드를 사용하여
            // mybatis-config.xml 파일에서 구성을 읽어 sqlSessionFactory 를 초기화

            try {
                // mybatis-config.xml 파일에서 설정을 읽어와 SQL 세션 팩토리를 생성
                InputStream inputStream = Resources.getResourceAsStream("xmlconfig/mybatis-config.xml");
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException e) {
                // 예외가 발생한 경우, RuntimeException 을 던져서 예외 처리
                throw new RuntimeException(e);
            }
        }

        // 설정된 SQL 세션 팩토리를 통해 새로운 SQL 세션 오픈
        return sqlSessionFactory.openSession(false);
        // 자동 커밋을 사용하지 않는 SQL 세션을 반환
    }
}