package sw.member.biz;

import java.sql.Connection;

import sw.dbms.JDBC;
import sw.dto.entity.Member;

public class MemberBiz {

	/**
	 * 비밀번호 변경 로직
	 * 
	 * @param member
	 * @param xPasswd
	 * @param newPasswd1
	 * @param newPasswd2
	 * @throws Exception
	 */
	public static void passwdChange(Member member, String xPasswd, String newPasswd1, String newPasswd2)
			throws Exception {
		// 현재 비밀번호 검증
		if (!member.getPasswd().equals(xPasswd))
			throw new Exception("입력하신 현재 비밀번호가 일치하지 않습니다.");

		// 입력받은 두 비밀번호 검증
		if (!newPasswd1.equals(newPasswd2))
			throw new Exception("새로운 비밀번호 두 개가 일치하지 않습니다.");

		Connection conn = null;
		try {
			// DB 컨넥션 획득
			conn = JDBC.getConn();
			conn.setAutoCommit(false);
			// DAO 생성
			new MemberDao().passwdChange(conn, member, newPasswd2);
			JDBC.commit(conn);
			member.setPasswd(newPasswd2);
		} catch (Exception e) {
			JDBC.rollback(conn);
			throw e;
		} finally {
			// 컨넥션 해제
			JDBC.close(conn);
		}

	}

	/**
	 * 닉네임 변경 로직
	 * 
	 * @param member
	 * @param newNick
	 * @throws Exception
	 */
	public static void nickChange(Member member, String newNick) throws Exception {
		Connection conn = null;

		try {
			// DB 컨넥션 획득
			conn = JDBC.getConn();
			conn.setAutoCommit(false);
			// DAO 생성
			new MemberDao().nickChange(conn, member, newNick);
			JDBC.commit(conn);
			member.setName(newNick);
		} catch (Exception e) {
			JDBC.rollback(conn);
			throw e;
		} finally {
			// 컨넥션 해제
			JDBC.close(conn);
		}

	}

	/**
	 * 회원 탈퇴 로직
	 * 
	 * @param member
	 * @throws Exception
	 */
	public static void signOut(Member member) throws Exception {
		Connection conn = null;

		try {
			// DB 컨넥션 획득
			conn = JDBC.getConn();
			conn.setAutoCommit(false);
			// DAO 생성
			new MemberDao().signOut(conn, member);
			JDBC.commit(conn);

		} catch (Exception e) {
			JDBC.rollback(conn);
			throw e;
		} finally {
			// 컨넥션 해제
			JDBC.close(conn);
		}

	}

	/**
	 * 회원가입 로직
	 * 
	 * @param member
	 * @throws Exception
	 */
	public static void signUp(Member member, String passwd2) throws Exception {
		if (!member.getPasswd().equals(passwd2)) {
			throw new Exception("두 비밀번호가 일치하지 않습니다.");
		}

		Connection conn = null;
		try {
			// DB 컨넥션 획득
			conn = JDBC.getConn();
			conn.setAutoCommit(false);
			// DAO 생성
			new MemberDao().signUp(conn, member);
			JDBC.commit(conn);

		} catch (Exception e) {
			JDBC.rollback(conn);
			throw e;
		} finally {
			// 컨넥션 해제
			JDBC.close(conn);
		}

	}

	/**
	 * 로그인 로직
	 * 
	 * @param member
	 * @throws Exception
	 */
	public static void login(Member member) throws Exception {
		Connection conn = null;

		try {
			// DB 컨넥션 획득
			conn = JDBC.getConn();
			// DAO 생성
			new MemberDao().login(conn, member);

		} catch (Exception e) {
			throw e;
		} finally {
			// 컨넥션 해제
			JDBC.close(conn);
		}

	}
}
