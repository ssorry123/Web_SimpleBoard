# SimpleBoard
회원가입, 게시글 작성, 조회 등 게시판

<br>

1. USING
2. Development Design
3. NextTodo
4. Implemented
    - service
    - db table
5. setting

---

## USING
- eclipse
    - dynamic web project
- java
- js (jquery)
- jsp & servlet (EL, JSTL)
- ajax
- MVC
- DBMS(mariadb)
- COS(file up/down)
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

---

## NextTodo
```
파일 업로드 구현
게시글에 사진 기능 추가
```

<br>

---

### 구현된 목록 (2021-02-09)
- 회원 관리
    - 회원가입(signUp)
    - 회원탈퇴(signOut)
    - 로그인(login)
    - 로그아웃(logout)
    - 회원정보 수정(memberChange)
        - 닉네임변경(nickChange)
        - 비밀번호변경(passwdChange)

- 게시글
    - 전체 게시글 목록 보기(simpleBoard)
    - 특정 게시글 상세 보기(showOnePost)
    - 게시글 작성하기(writePost)
    - 자신의 게시글 삭제(deletePost)
    - 자신의 게시글 수정(updatePost)
    - 댓글(comment)
        - 댓글 보기, 댓글 달기(writeComment)

<br>

---

### Table 구조 (2021-02-09)

![Screenshot](/imgs/ERD.png)

<br>

#### TB_MEMBER
회원 관리
```sql
CREATE TABLE `tb_member` (
	`id` VARCHAR(50) NOT NULL COLLATE 'utf8_general_ci',
	`name` VARCHAR(50) NOT NULL COLLATE 'utf8_general_ci',
	`pw` VARCHAR(50) NOT NULL COLLATE 'utf8_general_ci',
	PRIMARY KEY (`id`, `name`) USING BTREE,
	UNIQUE INDEX `name` (`name`) USING BTREE,
	UNIQUE INDEX `id` (`id`) USING BTREE
)
-- COLLATE='utf8_general_ci'
-- ENGINE=InnoDB
;
```

#### TB_SIMPLEBOARD
게시글 관리
```sql
CREATE TABLE `tb_simpleboard` (
	`no` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
	`userid` VARCHAR(50) NULL DEFAULT NULL COLLATE 'utf8_general_ci',
	`username` VARCHAR(50) NULL DEFAULT NULL COLLATE 'utf8_general_ci',
	`title` VARCHAR(50) NOT NULL DEFAULT 'titleEx' COLLATE 'utf8_general_ci',
	`date` DATETIME NOT NULL DEFAULT current_timestamp(),
	`newdate` DATETIME NULL DEFAULT NULL,
	`content` MEDIUMTEXT NULL DEFAULT NULL COLLATE 'utf8_general_ci',
	PRIMARY KEY (`no`) USING BTREE,
	INDEX `FK_tb_simpleboard_tb_member` (`userid`, `username`) USING BTREE,
	CONSTRAINT `FK_tb_simpleboard_tb_member` FOREIGN KEY (`userid`, `username`) REFERENCES `simpleboard`.`tb_member` (`id`, `name`) ON UPDATE CASCADE ON DELETE SET NULL
)
-- COLLATE='utf8_general_ci'
-- ENGINE=InnoDB
-- AUTO_INCREMENT=36
;
```

#### TB_COMMENT
댓글 관리
```sql
CREATE TABLE `tb_comment` (
	`no` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
	`postNo` BIGINT(20) UNSIGNED NULL DEFAULT NULL,
	`userid` VARCHAR(50) NULL DEFAULT NULL COLLATE 'utf8_general_ci',
	`username` VARCHAR(50) NULL DEFAULT NULL COLLATE 'utf8_general_ci',
	`comment` VARCHAR(50) NULL DEFAULT NULL COLLATE 'utf8_general_ci',
	`date` DATETIME NOT NULL DEFAULT current_timestamp(),
	PRIMARY KEY (`no`) USING BTREE,
	INDEX `FK_tb_comment_tb_simpleboard` (`postNo`) USING BTREE,
	INDEX `FK_tb_comment_tb_member` (`userid`, `username`) USING BTREE,
	CONSTRAINT `FK_tb_comment_tb_member` FOREIGN KEY (`userid`, `username`) REFERENCES `simpleboard`.`tb_member` (`id`, `name`) ON UPDATE CASCADE ON DELETE SET NULL,
	CONSTRAINT `FK_tb_comment_tb_simpleboard` FOREIGN KEY (`postNo`) REFERENCES `simpleboard`.`tb_simpleboard` (`no`) ON UPDATE CASCADE ON DELETE CASCADE
)
-- COLLATE='utf8_general_ci'
-- ENGINE=InnoDB
-- AUTO_INCREMENT=21
;
```

<br>

---


## Setting
### Server
- Apache Tomcat 9.0
    - [server runtime environments] - [add] ...
### EL, JSTL 사용
- <a href="https://tomcat.apache.org/download-taglibs.cgi">다운 링크</a>
    - 4개의 jar 파일 WEB-INF/lib 폴더에 넣기
### Jquery
- <a href="https://jquery.com/">다운 링크</a>
    - WebContent/lib
#### JSON
- <a href="https://code.google.com/archive/p/json-simple/downloads">다운 링크</a>
    - WEB-INF/lib 폴더에 넣기
### DBMS
- MariaDB
    - 10.5.8
    - HeidiSQL
- JDBC Driver
    - mariadb-java-client-2.6.0.jar
        - WEB-INF/lib 폴더에 넣기
- Tomcat db connection pool 설정(META-INF/context.xml)
    - <a href="https://hwan2.tistory.com/entry/Servlet%EC%97%90%EC%84%9C-MariaDB-%EC%82%AC%EC%9A%A9%EC%8B%9C-Connection-Pool-%EC%84%A4%EC%A0%95-%EB%B0%A9%EB%B2%95">참고</a>
### File Upload Download
- cos.jar
- <a href="http://servlets.com/cos/">다운 링크</a>
    - WEB-INF/lib
---

