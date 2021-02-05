package sw.model.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import sw.model.dbms.JDBC;
import sw.util.MyUtil;

public class MemberDAO {
	/**
	 * id, pw 일치시 true 리턴
	 * 
	 * @param conn
	 * @param member
	 * @return boolean
	 * @throws Exception
	 */
	public static boolean login(Connection conn, MemberDTO member) throws Exception {
		String query = "SELECT id, pw FROM `simpleboard`.`tb_member` WHERE id=? AND pw=? ";
		String id = member.getId();
		String pw = member.getPasswd();
		PreparedStatement stmt = null;
		ResultSet rset = null;

		try {
			// 쿼리 세팅
			stmt = MyUtil.setQuery(conn, query, id, pw);
			// 쿼리 실행 및 결과 저장
			rset = stmt.executeQuery();

			// 쿼리 결과가 있다면, 회원이 존재하는 것
			if (rset.next()) {
				System.out.println("id " + rset.getString(1));
				System.out.println("id " + rset.getString(2));
				return true;
			}

		} catch (Exception e) {
			throw e;
		} finally {
			JDBC.close(rset);
			JDBC.close(stmt);
		}

		return false;
	}
}
