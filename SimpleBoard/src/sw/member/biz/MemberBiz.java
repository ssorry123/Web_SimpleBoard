package sw.member.biz;

import java.sql.Connection;

import sw.dbms.JDBC;

public class MemberBiz {
	/**
	 * 회원 탈퇴
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
			conn.commit();

		} catch (Exception e) {
			conn.rollback();
			throw e;
		} finally {
			// 컨넥션 해제
			JDBC.close(conn);
		}

	}

	/**
	 * 회원가입
	 * 
	 * @param member
	 * @throws Exception
	 */
	public static void signUp(Member member) throws Exception {
		Connection conn = null;

		try {
			// DB 컨넥션 획득
			conn = JDBC.getConn();
			conn.setAutoCommit(false);
			// DAO 생성
			new MemberDao().signUp(conn, member);
			conn.commit();

		} catch (Exception e) {
			conn.rollback();
			throw e;
		} finally {
			// 컨넥션 해제
			JDBC.close(conn);
		}

	}

	/**
	 * 로그인
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
