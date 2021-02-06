package sw.simpleBoard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sw.simpleBoard.biz.SimpleBoardBiz;
import sw.simpleBoard.dto.SelectPostEntity;
import sw.util.MyUtil;

/**
 * 하나의 게시글을 보여줌
 */
@WebServlet(urlPatterns = {"/showOnePost"})
public class ShowOnePostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			request.setCharacterEncoding("UTF-8");
			String postNo = request.getParameter("postNo");
			
			SelectPostEntity post = SimpleBoardBiz.selectPost(postNo);
			HttpSession session = request.getSession(false);
			session.setAttribute("post", post);
			
			response.sendRedirect(request.getContextPath() + "/board/showOnePost.jsp");
			
		} catch (Exception e) {
			MyUtil.catchExceptionInServlet(request, response, e);
		}
	}

}
