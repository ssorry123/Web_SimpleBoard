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
 * Servlet implementation class SignChangeServlet
 */
@WebServlet(urlPatterns = { "/nickChange" })
public class nickChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {			
			Member member = MyUtil.getLoginMember(request);
			
			request.setCharacterEncoding("UTF-8");
			String newNick = request.getParameter("newNick");
			
			MemberBiz.nickChange(member, newNick);
			
			MyUtil.alertAndSendRedirect(response, request.getContextPath() + "/simpleBoard", "닉네임 수정 완료");
//			request.getSession().setAttribute("msg", "닉네임 수정 완료");
//			response.sendRedirect(request.getContextPath() + "/simpleBoard");

		} catch (Exception e) {
			MyUtil.catchExceptionInServlet(request, response, e);
		}
	}

}
