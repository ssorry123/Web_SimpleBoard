package sw.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
			HttpSession session = request.getSession(false); // 새로운 세션 할당 불가
			session.invalidate();	// 세션 폐기
			System.out.println("로그아웃 완료");
			response.sendRedirect(request.getContextPath() + "/index.jsp");
		} catch (Exception e) {
			request.getSession().invalidate();
			request.getSession().setAttribute("msg", "이미 로그아웃 되어있습니다");
			response.sendRedirect(request.getContextPath() + "/msg.jsp");
		}
	}

}
