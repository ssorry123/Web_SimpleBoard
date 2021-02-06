package sw.simpleBoard;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sw.member.dto.Member;
import sw.simpleBoard.biz.SimpleBoardBiz;
import sw.simpleBoard.dto.InsertPostEntity;
import sw.simpleBoard.dto.SelectPostEntity;
import sw.util.MyUtil;

/**
 * 게시판 내용 받은 후 게시판 페이지에 전달 
 */
@WebServlet(urlPatterns = { "/simpleBoard" })
public class simpleBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 게시글 목록 받고 jsp에 부려줌
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("get");
		// TODO Auto-generated method stub

		try {
			// 로그인 유효성 검사
			HttpSession session = request.getSession(false);
			Member member = (Member) session.getAttribute("member");
			if (member == null) {
				throw new Exception("유효하지 않은 로그인입니다.");
			}
			
			List<SelectPostEntity> posts = SimpleBoardBiz.selectPostAll();

			session.setAttribute("posts", posts);
			response.sendRedirect(request.getContextPath() + "/board/simpleBoard.jsp");
		} catch (Exception e) {
			MyUtil.catchExceptionInServlet(request, response, e);
		}
	}


}
