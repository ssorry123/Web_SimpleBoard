package sw.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sw.member.biz.MemberBiz;
import sw.member.dto.Member;
import sw.util.MyUtil;

/**
 * 회원가입 진행 Servlet implementation class SignUpServlet
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

			// js에서 검사하지만 double check
			// js가 동작하지 않는 경우도 있음
			String passwd1 = (String) request.getParameter("passwd1");
			String passwd2 = (String) request.getParameter("passwd2");
			if (!passwd1.equals(passwd2))
				throw new Exception("두 비밀번호가 일치하지 않습니다.");

			String name = (String) request.getParameter("name");
			System.out.println(id + ", " + passwd1);

			// DB 저장 시도
			MemberBiz.signUp(new Member(id, passwd1, name), passwd2);

			request.getSession().setAttribute("msg", "회원가입 완료");
			response.sendRedirect(request.getContextPath() + "/msg.jsp");

		} catch (Exception e) {
			MyUtil.catchExceptionInServlet(request, response, e);
		}
	}
}
