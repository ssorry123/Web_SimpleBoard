package sw.simpleBoard;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sw.dto.entity.Member;
import sw.dto.entity.PostEntity;
import sw.simpleBoard.biz.SimpleBoardBiz;
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
			Member member = MyUtil.getLoginMember(request);
			
			List<PostEntity> posts = SimpleBoardBiz.selectPostAll();
			
			RequestDispatcher rd = request.getRequestDispatcher("/board/simpleBoard.jsp");
			request.setAttribute("posts", posts);
			rd.forward(request, response);
		} catch (Exception e) {
			MyUtil.catchExceptionInServlet(request, response, e);
		}
	}


}
