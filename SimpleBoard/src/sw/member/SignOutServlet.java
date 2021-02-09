package sw.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sw.dto.entity.Member;
import sw.member.biz.MemberBiz;
import sw.util.MyUtil;

/**
 * 회원가입 진행 Servlet implementation class SignUpServlet
 */
@WebServlet(urlPatterns = { "/signOut" })
public class SignOutServlet extends HttpServlet {
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
			Member member = MyUtil.getLoginMember(request);

			// DB 삭제 시도
			MemberBiz.signOut(member);

			request.getSession().setAttribute("msg", "회원탈퇴 완료");
			response.sendRedirect(request.getContextPath() + "/msg.jsp");

		} catch (Exception e) {
			MyUtil.catchExceptionInServlet(request, response, e);
		}
	}
}
