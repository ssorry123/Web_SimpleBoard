package sw.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sw.member.biz.Member;
import sw.member.biz.MemberBiz;
import sw.util.MyUtil;

/**
 * Servlet implementation class SignChangeServlet
 */
@WebServlet(urlPatterns = { "/passwdChange" })
public class passwdChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			HttpSession session = request.getSession(false);
			Member member = (Member) session.getAttribute("member");
			if(member == null) {
				throw new Exception("회원 정보 수정 불가");
			}

			request.setCharacterEncoding("UTF-8");
			String xPasswd = request.getParameter("xPasswd");
			String newPasswd1 = request.getParameter("newPasswd1");
			String newPasswd2 = request.getParameter("newPasswd2");
			
			// 비밀번호 변경 시도
			MemberBiz.passwdChange(member, xPasswd, newPasswd1, newPasswd2);
			
			MyUtil.alertAndSendRedirect(response, request.getContextPath() + "/simpleBoard", "비밀번호 수정 완료");
//			request.getSession().setAttribute("msg", "비밀번호 수정 완료");
//			response.sendRedirect(request.getContextPath() + "/simpleBoard");

		} catch (Exception e) {
			MyUtil.catchExceptionInServlet(request, response, e);
		}
	}

}
