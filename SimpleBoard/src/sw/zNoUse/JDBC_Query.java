package sw.zNoUse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sw.dbms.JDBC;

/**
 * DBMS 접속 관리 쿼리 처리
 * 
 * @author 26060
 *
 */
public class JDBC_Query {
//	private static String driver = "org.mariadb.jdbc.Driver";
//	private static String url = "jdbc:mariadb://127.0.0.1:3306";
//	private static String dbUser = "simpleDeveloper";
//	private static String dbUserPWD = "1234";

	private static void setQuery(PreparedStatement stmt, String[] vars) throws SQLException {
		for (int i = 0; i < vars.length; ++i) {
			stmt.setString(i + 1, vars[i]);
		}
	}

	public static List<String[]> select(String query, int colSize, String... vars) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		List<String[]> ret = new ArrayList<>();

		try {
			try {
				// 드라이버 연결, 커넥션 생성
				conn = JDBC.getConn();

				// 쿼리 셋팅
				stmt = conn.prepareStatement(query);
				setQuery(stmt, vars);

				// 쿼리 실행 및 결과 저장
				rset = stmt.executeQuery();
				while (rset.next()) {
					// 하나의 row의 각각의 col을 저장
					String[] item = new String[colSize];
					for (int i = 0; i < colSize; ++i) {
						item[i] = rset.getString(i + 1);
					}

					// 하나의 로우 추가
					ret.add(item);
				}

			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			} finally {
				try {
					JDBC.close(rset);
					JDBC.close(stmt);
					JDBC.close(conn);
				} catch (Exception e) {
					throw e;
				}
			}
		} catch (Exception e) {
			ret = null;
			System.out.println("JDBC에러");
			e.printStackTrace();
		}
		return ret;
	}

}
