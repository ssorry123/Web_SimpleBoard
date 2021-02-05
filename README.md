# SimpleBoard
회원가입, 게시글 작성, 조회 등 게시판

<br>

---

## USE
- eclipse
- dynamic web project
- java
- js (jquery)
- jsp & servlet (EL, JSTL)
- DBMS
- ~~CSS~~

<br>

---

## Development Design
- MVC
    - View
        - html, jsp
    - Controller
        - servlet (flow control)
    - Model
        - business Logic
        - DAO (DBMS)
        - DTO
![Screenshot](/imgs/mvc.png)

<br>

- make page
    - SPA(Single Page Application) (Now)
    - MPA(Mulit Page Application)   


<br>

---

## Setting
### Server
- Apache Tomcat 9.0
### EL, JSTL 사용
- <a href="https://tomcat.apache.org/download-taglibs.cgi">다운 링크</a>
- 4개의 jar 파일 WEB-INF/lib 폴더에 넣기
### Jquery
- <a href="https://jquery.com/">다운 링크</a>
### DBMS
- MariaDB
    - 10.5.8
    - HeidiSQL
- JDBC Driver
    - mariadb-java-client-2.6.0.jar
        - Java Resources's Libraries 등록
            - [Eclipse] - [ProjectName] - [BuildPath] - [Libraries] -
            - [ClassPath] - [Add Library...] - [User Libraries...] - [Add JARs]
        - WebContent 등록
            - 폴더로 드래그
- Tomcat db connection pool 설정
    - <a href="https://hwan2.tistory.com/entry/Servlet%EC%97%90%EC%84%9C-MariaDB-%EC%82%AC%EC%9A%A9%EC%8B%9C-Connection-Pool-%EC%84%A4%EC%A0%95-%EB%B0%A9%EB%B2%95">참고</a>
---

