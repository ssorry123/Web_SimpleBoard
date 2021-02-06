package sw.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sw.util.MyUtil;

/**
 * 로그아웃 진행
 * Servlet implementation class LogoutServlet
 */
@WebServlet(urlPatterns = { "/logout" })
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			HttpSession session = request.getSession();
			session.invalidate();	// 세션 폐기
			response.sendRedirect(request.getContextPath() + "/index.jsp"); // home으로 이동
		} catch (Exception e) {
			MyUtil.catchExceptionInServlet(request, response, e);
		}
	}

}
