package sw.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 * db 커넥션 풀
 * 
 * WebContent/META-INF/context.xml 참고
 * 
 * @author 26060
 *
 */
public final class JDBC {
	private JDBC() throws Exception {
		throw new Exception("커넥션");
	}

	// db 연결 객체
	public static Connection getConn() throws Exception {
		Connection conn = null;

		try {
			Context initContext = new InitialContext();
			DataSource datasource = (DataSource) initContext.lookup("java:comp/env/jdbc_mariadb");
			conn = datasource.getConnection();
			conn.setAutoCommit(false);
		} catch (Exception e) {
			throw e;
		}

		return conn;
	}

	private static boolean isConnected(Connection conn) {
		boolean ret = true;

		try {
			// 연결이 없거나 닫힌 경우
			if (conn == null || conn.isClosed())
				ret = false;
		} catch (Exception e) {
			ret = false;
			e.printStackTrace();
		}

		return ret;
	}

	// 닫기 메소드
	public static void close(ResultSet rset) throws Exception {
		try {
			if (rset != null)
				rset.close();
		} catch (Exception e) {
			throw e;
		}
	}

	public static void close(Statement stmt) throws Exception {
		try {
			if (stmt != null)
				stmt.close();
		} catch (Exception e) {
			throw e;
		}
	}

	public static void close(Connection conn) throws Exception {
		try {
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			throw e;
		}
	}

	// 트랜잭션 관련
	public static void commit(Connection conn) throws Exception {
		try {
			if (isConnected(conn)) {
				conn.commit();
			}
		} catch (Exception e) {
			throw e;
		}
	}

	public static void rollback(Connection conn) throws Exception {
		try {
			if (isConnected(conn)) {
				conn.rollback();
			}
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * 쿼리에 ?를 채워준다
	 * 
	 * @param conn
	 * @param query
	 * @param vars
	 * @return
	 * @throws Exception
	 */
	public static PreparedStatement setQuery(Connection conn, String query, String... vars) throws Exception {
		// 상황에 따라 값을 수정할 수 있는 쿼리 생성
		PreparedStatement stmt = conn.prepareStatement(query);
	
		// 인자 개수만큼 세팅
		for (int i = 0; i < vars.length; ++i) {
			stmt.setString(i + 1, vars[i]);
		}
		return stmt;
	}

}
