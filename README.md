# MyBatis

## MyBatis(마이바티스)란?
MyBatis (마이바티스)는  XML 설명자 또는 주석 을 사용하여 저장 프로시저 또는 SQL 문과 개체를 연결 하는 Java 지속성 프레임워크

 

 ### MyBatis(마이바티스) 특징 1

MyBatis는 SQL을 별도의 파일로 분리해서 관리
객체-SQL 사이의 파라미터 Mapping 작업을 자동으로 해줌
MyBatis는 개발자가 익숙한 SQL을 그대로 이용하면서 JDBC 코드 작성의 불편함도 제거
도메인 객체나 VO 객체를 중심으로 개발이 가능하다는 장점이 있음
* Domain Object (도메인 객체) - 개발하고자 하는 영역을 분석하고, 그 분석의 결과로 도출된 객체들을 의미

* Value Object (VO 객체) - DTO의 읽기 버전 (VO는 출력 : Read Only)

### MyBatis(마이바티스) 특징 2 

1. 쉬운 접근성과 코드의 간결함 - 가장 간단한 퍼시턴스 프레임워크
XML 형태로 서술된 JDBC 코드라고 생각해도 될 만큼 JDBC의 모든 기능을 MyBatis가 대부분 제공
복잡한 JDBC코드를 걷어내며 깔끔한 소스코드를 유지할 수 있음
수동적인 파라미터 설정과 쿼리 결과에 대한 맵핑 구문을 제거할 수 있음
2. SQL문과 프로그래밍 코드의 분리 - SQL에 변경에 있을 때마다 자바 코드를 수정하거나 컴파일하지 않아도 된다.
3.  다양한 프로그래밍 언어로 구현가능 - Java, C#, .NET, Ruby
 

#### MyBatis와 MyBatis-Spring을 사용한 DB Access Architecture

개발자가 지정한 SQL, 저장 프로시저 그리고 몇 가지 고급 매핑을 지원하는 SQL Mapper
JDBC로 처리하는 상당 부분의 코드와 파라미터 설정 및 결과 매핑을 대신해준다.
기존에 JDBC를 사용할 때는 DB와 관련된 여러 복잡한 설정(Connection)들을 다루어야 했지만 SQL Mapper는 자바 객체를 실제 SQL문에 연결함으로써, 빠른 개발과 편리한 테스트 환경을 제공한다.
데이터베이스 record에 원시 타입과 Map 인터페이스 그리고 자바 POJO를 설정해서 매핑하기 위해 xml과 Annotation을 사용할 수 있다.

장점
- SQL에 대한 모든 컨트롤을 하고자 할때 매우 적합하다.
- SQL쿼리들이 매우 잘 최적화되어 있을 때에 유용하다.

단점
- 애플리케이션과 데이터베이스 간의 설계에 대한 모든 조작을 하고자 할 때는 적합하지 않다.
- 애플리케이션과 데이터베이스 간에 서로 잘 구조화되도록 많은 설정이 바뀌어야 하기 때문이다.


 #### MyBatis를 사용하는 Data Access Layer

MyBatis는 Data Access Layer에서 사용하는 framework
Controller에서 Service 호출
Service가 DAO 계층에 있는 method를 호출하면 DAO에서 MyBatis를 호출
 

#### MyBatis의 주요 컴포넌트

SqlSession Factory Builder가 Config File을 읽고 Factory를 생성해준다. 개발자가 DB에 insert하거나 Read하는 메서드를 호출하면 SqlSession Factory가 SqlSession를 생성하고 개발자가 작성한 Application코드에 반환해준다.

SqlSession은 개발자가 작성한 SQL문을 호출해주는 기능을 해준다고 생각하면된다.

(1) Appication에서 SqlSession Factory Builder라고 하는 interface 호출<br/>
(2) SqlSession Factory Builder가 MyBatis Config File 정보를 읽음<br/>
(3) SqlSession Factory Builder가 SqlSession Factory 생성<br/>
(4) 개발자가 Appication에 있는 DB Access하는 READ하거나 INSERT하는 Method를 호출<br/>
(5) SqlSession Factory를 Appication 상에서 호출<br/>
(6) SqlSession Factory가 SqlSession이라는 컴포넌트 생성<br/>
(7) SqlSession을 개발자가 작성하는 Appication Code에 retrun(반환) 해줌 - return 받아서 SqlSession에 있는 Method 호출<br/>
(8) SqlSession은 핵심 기능으로 볼 수 있으며 개발자가 작성한 SQL문(Mapping File)을 호출해줌


##### 출처 
MyBatis 정의 : https://en.wikipedia.org/wiki/MyBatis <br/>
MyBatis 특징 & 주요 컴포넌트 & Data Access Layer : https://www.youtube.com/watch?v=9b5P4YiyqOY <br/>
MyBatis와 MyBatis-Spring을 사용한 DB Access Architecture : https://gmlwjd9405.github.io/2018/12/25/difference-jdbc-jpa-mybatis.html<br/>
Domain Object & Value Object : https://sb.pe.kr/7312