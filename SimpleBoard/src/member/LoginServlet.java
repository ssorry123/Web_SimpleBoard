package member;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.JDBC;
import util.MyUtil;

/**
 * 로그인 진행 Servlet implementation class login
 */
@WebServlet(name = "login", urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * 아이디 유효 확인
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			request.setCharacterEncoding("UTF-8");
			String id = (String) request.getParameter("id");
			String passwd = (String) request.getParameter("passwd");
			System.out.println(id + ", " + passwd);

			// 아이디, 비밀번호 조회
			String query = "SELECT id, pw " + "FROM `simpleboard`.`tb_member` " + "WHERE id=? AND pw=? ";
			List<String[]> ret = JDBC.select(query, 2, id, passwd);

			// 세션 할당(기존 세션 폐기)
			HttpSession session = MyUtil.resetSession(request);

			if (ret != null && ret.size() != 0) {
				// 세션에 아이디 등록
				session.setAttribute("id", id);
				// simpleBoard로 이동
				response.sendRedirect(request.getContextPath() + "/board/simpleBoard");
			} else {
				// 세션에 메세지 등록
				MyUtil.resetSession(request).setAttribute("msg", "존재하지 않는 회원입니다.");
				response.sendRedirect(request.getContextPath() + "/msg.jsp");
			}
		} catch (Exception e) {
			MyUtil.resetSession(request).setAttribute("msg", e.getMessage());
			response.sendRedirect(request.getContextPath() + "/msg.jsp");
		}
	}
}
