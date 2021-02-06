package sw.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sw.member.biz.MemberBiz;
import sw.member.dto.Member;
import sw.util.MyUtil;

/**
 * 로그인 진행
 */
@WebServlet(name = "login", urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
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
			Member member = new Member();
			member.setId(id);
			member.setPasswd(passwd);

			// DB 연결후 로그인 시도
			MemberBiz.login(member);

			// 세션 할당(기존 세션 폐기)
			HttpSession session = request.getSession();
			session.invalidate();
			session = request.getSession();

			session.setAttribute("member", member);
			response.sendRedirect(request.getContextPath() + "/simpleBoard");

		} catch (Exception e) {
			MyUtil.catchExceptionInServlet(request, response, e);
		}
	}
}
