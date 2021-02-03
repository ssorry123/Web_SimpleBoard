package member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class login
 */
@WebServlet(name = "login", urlPatterns= {"/login"})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * 아이디 유효 확인
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String id = (String)request.getParameter("id");
		String passwd = (String)request.getParameter("passwd");
		System.out.println(id + ", " + passwd);
		
		boolean ret = select(id, passwd);
		
		HttpSession session = request.getSession(true);
		if(ret) {
			// 세션에 아이디 등록
			session.setAttribute("id", id);
			response.sendRedirect(request.getContextPath() + "/board/simpleBoard.jsp");
		}else {
			// 세션에 메세지 등록
			session.setAttribute("msg", "존재하지 않는 회원입니다.");	
		}
	}

	private boolean select(String id, String passwd) {
		// DB 멤버 체크
		
		return true;
	}
}
