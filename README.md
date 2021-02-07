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
- MVC
- DBMS
- ~~CSS~~

<br>

---

### 구현된 목록 (2021-02-06)
- 회원 관리
    - 회원가입(signUp)
    - 회원탈퇴(signOut)
    - 로그인(login)
    - 로그아웃(logout)
    - 회원정보 수정(memberChange)
        - 닉네임변경(nickChange)
        - 비밀번호변경(passwdChange)

- 게시글
    - 전체 게시글 보기
    - 특정 게시글 보기
    - 게시글 작성하기
    - 자신의 게시글 삭제하기

<br>

---

### Table 구조 (2021-02-06)

![Screenshot](/imgs/ERD.png)

#### TB_MEMBER
```sql
CREATE TABLE `tb_member` (
	`id` VARCHAR(50) NOT NULL DEFAULT 'test' COLLATE 'utf8_general_ci',
	`pw` VARCHAR(50) NOT NULL COLLATE 'utf8_general_ci',
	`name` VARCHAR(50) NULL DEFAULT NULL COLLATE 'utf8_general_ci',
	PRIMARY KEY (`id`) USING BTREE
)
-- COLLATE='utf8_general_ci'
-- ENGINE=InnoDB
-- ;

```

#### TB_SIMPLEBOARD
```sql
CREATE TABLE `tb_simpleboard` (
	`no` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
	`userid` VARCHAR(50) NULL DEFAULT NULL COLLATE 'utf8_general_ci',
	`title` VARCHAR(50) NOT NULL COLLATE 'utf8_general_ci',
	`date` DATETIME NOT NULL DEFAULT current_timestamp(),
	`content` TEXT(65535) NULL DEFAULT '내용이 없습니다.' COLLATE 'utf8_general_ci',
	PRIMARY KEY (`no`) USING BTREE,
	INDEX `FK_tb_simpleboard_tb_member` (`userid`) USING BTREE,
	CONSTRAINT `FK_tb_simpleboard_tb_member` FOREIGN KEY (`userid`) REFERENCES `simpleboard`.`tb_member` (`id`) ON UPDATE CASCADE ON DELETE SET NULL
)
-- COLLATE='utf8_general_ci'
-- ENGINE=INNODB
-- AUTO_INCREMENT=18
-- ;
```

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
            - WEB-INF/lib 폴더로 드래그
- Tomcat db connection pool 설정
    - <a href="https://hwan2.tistory.com/entry/Servlet%EC%97%90%EC%84%9C-MariaDB-%EC%82%AC%EC%9A%A9%EC%8B%9C-Connection-Pool-%EC%84%A4%EC%A0%95-%EB%B0%A9%EB%B2%95">참고</a>
---

