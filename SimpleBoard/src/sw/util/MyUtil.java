package sw.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyUtil {

	public static void alertAndSendRedirect(HttpServletResponse response, String url, String msg) throws Exception {
		response.setContentType("text/html; charset=UTF-8");

		String str = String.format("<script>alert('%s'); location.href='%s';</script>", msg, url);
		
		PrintWriter out = response.getWriter();
		out.println(str);
		out.flush();
	}

	/**
	 * 세션에 에러값 입력후 에러 페이지로 이동
	 * 
	 * @param req
	 * @param resp
	 * @param e
	 * @throws IOException
	 */
	public static void catchExceptionInServlet(HttpServletRequest req, HttpServletResponse resp, Exception e)
			throws IOException {
		e.printStackTrace();
		req.getSession().invalidate();
		req.getSession().setAttribute("msg", e.getMessage());
		resp.sendRedirect(req.getContextPath() + "/msg.jsp");
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
