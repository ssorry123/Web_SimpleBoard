package sw.util;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class MyUtil {
	public static HttpSession resetSession(HttpServletRequest req) {
		HttpSession ret = req.getSession();
		ret.invalidate();
		ret = req.getSession();
		return ret;
	}

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
