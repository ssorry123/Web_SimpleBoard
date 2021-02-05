package sw.controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 회원가입 진행
 * Servlet implementation class SignUpServlet
 */
@WebServlet(name = "/SignUpServlet", urlPatterns = { "/signUp" })
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 데이터 확인 후 회원 가입, 로그인페이지로 이동
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			// 입력된 아이디와 비밀번호 추출
			request.setCharacterEncoding("UTF-8");
			String id = (String) request.getParameter("id");
			String passwd = (String) request.getParameter("passwd");
			System.out.println(id + ", " + passwd);

			// DB 저장
			boolean ret = insert(id, passwd);

			// 홈으로
			if (ret) {
				request.getSession().setAttribute("msg", "회원가입 완료");
				response.sendRedirect(request.getContextPath() + "/msg.jsp");
			} else {
				request.getSession().invalidate();
				request.getSession().setAttribute("msg", "회원가입 오류");
				response.sendRedirect(request.getContextPath() + "/msg.jsp");
			}
		} catch (Exception e) {
			request.getSession().invalidate();
			request.getSession().setAttribute("msg", e.getMessage());
			response.sendRedirect(request.getContextPath() + "/msg.jsp");
		}
	}

	private boolean insert(String id, String passwd) {
		// db 추후 연동
		return true;
	}

}
