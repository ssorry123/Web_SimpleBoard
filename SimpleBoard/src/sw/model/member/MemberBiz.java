package sw.model.member;

import java.sql.Connection;

import sw.model.dbms.JDBC;

public class MemberBiz {
	public static MemberDTO login(MemberDTO member) throws Exception {
		Connection conn = null;

		try {
			// DB 컨넥션 획득
			conn = JDBC.getConn();

			// DAO 생성
			MemberDAO memberDAO = new MemberDAO();

			// DAO에서 쿼리 실행
			boolean ret = MemberDAO.login(conn, member);

			if (ret) {
				return member;
			}

		} catch (Exception e) {
			throw e;
		} finally {
			// 컨넥션 해제
			JDBC.close(conn);
		}

		return null;
	}
}
