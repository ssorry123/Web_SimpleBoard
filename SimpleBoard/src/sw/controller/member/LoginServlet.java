package sw.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sw.model.member.MemberBiz;
import sw.model.member.MemberDTO;
import sw.util.MyUtil;
import sw.util.SWException;
import sw.util.SWExceptionDTO;

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
			MemberDTO member = new MemberDTO();
			member.setId(id);
			member.setPasswd(passwd);
			
			member = MemberBiz.login(member);

			// 세션 할당(기존 세션 폐기)
			HttpSession session = MyUtil.resetSession(request);

			if (member != null) {
				// 세션에 아이디 등록
				session.setAttribute("member", member);
				// simpleBoard로 이동
				response.sendRedirect(request.getContextPath() + "/board/simpleBoard");
			} else {
				// 세션에 메세지 등록
				SWException e = new SWException("로그인 실패", "존재하지 않는 회원이거나 비밀번호가 잘못되었습니다.");
				MyUtil.resetSessionSetAttributeMsg(request, e);
				response.sendRedirect(request.getContextPath() + "/msg.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
			SWException swe = new SWException("error", e.getMessage());
			MyUtil.resetSessionSetAttributeMsg(request, swe);
			response.sendRedirect(request.getContextPath() + "/msg.jsp");
		}
	}
}
