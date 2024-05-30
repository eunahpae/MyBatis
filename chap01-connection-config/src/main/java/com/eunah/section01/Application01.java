package com.eunah.section01;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import java.util.Date;

public class Application01 {

    // DB 설정 정보를 Field로 초기화
    private static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost:3306/menudb";
    private static String USER = "songpa";
    private static String PASS = "songpa";


    public static void main(String[] args) {

        /*
         * JdbcTransactionFactory : 수동 커밋
         * ManagerTransactionFactory : 으로 커밋
         * ------------------------------------------
         * PooledDataSource : connectionPool 을 사용함
         * UnPooledDataSource : 사용하지 않음
         */

        // 환경정보 객체 생성
        Environment environment = new Environment(
                "dev",
                new JdbcTransactionFactory(),
                new PooledDataSource(DRIVER, URL, USER, PASS)
        );

        // 생성한 환경 설정 정보로 MyBatis 설정 객체 생성
        Configuration config = new Configuration(environment);

        config.addMapper(Mapper.class);

        /*
         * SqlSessionFactory : SqlSession 객체를 생성하기 위한 팩토리 역할의 인터페이스
         *
         * SqlSessionFactoryBuilder : SqlSessionFactory 인터페이스 타입의 하위 구현 객체를 생성하기 위한 빌드 역할
         *
         * build : 설정에 대한 정보를 담고 있는 Configuration 타입의 객체 혹은 외부 설정 파일과 연관된 stream 을 매개변수로 전달하면
         *         SqlSessionFactory 인터페이스 타입의 객체를 반환하는 메소드
         *
         * SqlSession : jdbc 의 connection 과 같은 역할을 하는 객체
         */

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(config);
        System.out.println(sqlSessionFactory);

        /*
         * openSession() : sqlSession 인터페이스 타입의 객체를 반환하는 메소드  boolean 타입 인자 전달
         *
         *   - false : connection 인터페이스 타입 객체 DML 수행 후 Auto Commit 에 대한 옵션을 false 로 저장 <권장됨>
         *   - true : connection 인터페이스 타입 객체 DML 수행 후 Auto Commit 에 대한 옵션을 true 로 저장
         */
        SqlSession sqlSession = sqlSessionFactory.openSession(false);

        Mapper mapper = sqlSession.getMapper(Mapper.class);
        Date date = mapper.selectSysDate();
        System.out.println(date);
        sqlSession.close();
    }
}
