package sw.member.biz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import sw.dbms.JDBC;
import sw.member.dto.Member;
import sw.util.MyUtil;

public class MemberDao {
	/**
	 * 비밀번호 변경
	 * 
	 * @param conn
	 * @param member
	 * @param newPasswd
	 * @throws Exception
	 */
	public void passwdChange(Connection conn, Member member, String newPasswd) throws Exception {
		String query = "UPDATE `simpleboard`.`tb_member` SET `pw`=? WHERE  `id`=?";
		PreparedStatement stmt = null;

		try {
			String id = member.getId();

			stmt = MyUtil.setQuery(conn, query, newPasswd, id);
			int ret = stmt.executeUpdate();

			if (ret != 1)
				throw new Exception("error : 비밀번호 수정 실패");

		} catch (Exception e) {
			if (e instanceof SQLException) {
				e = new SQLException("존재하지 않는 회원일까?");
			}
			throw e;
		} finally {
			JDBC.close(stmt);
		}
	}

	/**
	 * 닉네임 변경
	 * 
	 * @param conn
	 * @param member
	 * @param newNick
	 * @throws Exception
	 */
	public void nickChange(Connection conn, Member member, String newNick) throws Exception {
		String query = "UPDATE `simpleboard`.`tb_member` SET `name`=? WHERE  `id`=?";
		PreparedStatement stmt = null;

		try {
			String id = member.getId();

			stmt = MyUtil.setQuery(conn, query, newNick, id);
			int ret = stmt.executeUpdate();

			if (ret != 1)
				throw new Exception("error : 닉네임 수정 실패");

		} catch (Exception e) {
			if (e instanceof SQLException) {
				e = new SQLException("존재하지 않는 회원일까?");
			}
			throw e;
		} finally {
			JDBC.close(stmt);
		}
	}

	/**
	 * 회원탈퇴 DAO
	 * 
	 * @param conn
	 * @param member
	 * @throws Exception
	 */
	public void signOut(Connection conn, Member member) throws Exception {
		String query = "DELETE FROM `simpleboard`.`tb_member` WHERE  `id`=?";
		PreparedStatement stmt = null;

		try {
			String id = member.getId();

			stmt = MyUtil.setQuery(conn, query, id);
			int ret = stmt.executeUpdate();

			if (ret != 1)
				throw new Exception("error : 회원탈퇴 실패");

		} catch (Exception e) {
			if (e instanceof SQLException) {
				e = new SQLException("존재하지 않는 회원일까?");
			}
			throw e;
		} finally {
			JDBC.close(stmt);
		}
	}

	/**
	 * 회원가입 DAO
	 * 
	 * @param conn
	 * @param member
	 * @throws Exception
	 */
	public void signUp(Connection conn, Member member) throws Exception {
		String query = "INSERT INTO `simpleboard`.`tb_member` (`id`, `pw`, `name`) VALUES (?, ?, ?)";
		PreparedStatement stmt = null;

		try {
			String id = member.getId();
			String pw = member.getPasswd();
			String name = member.getName();

			stmt = MyUtil.setQuery(conn, query, id, pw, name);
			int ret = stmt.executeUpdate();

			if (ret != 1)
				throw new Exception("error : 회원가입 실패");

		} catch (Exception e) {
			if (e instanceof SQLException) {
				e = new Exception("이미 존재하는 회원입니다.");
			}
			throw e;
		} finally {
			JDBC.close(stmt);
		}
	}

	/**
	 * 로그인 DAO
	 * 
	 * @param conn
	 * @param member
	 * @throws Exception
	 */
	public void login(Connection conn, Member member) throws Exception {
		String query = "SELECT id, pw, name FROM `simpleboard`.`tb_member` WHERE id=? AND pw=? ";
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
				member.setName(rset.getString(3));
			} else {
				throw new Exception("일치하는 회원이 없거나 비밀번호가 다릅니다.");
			}

		} catch (Exception e) {
			throw e;
		} finally {
			JDBC.close(rset);
			JDBC.close(stmt);
		}
	}
}
