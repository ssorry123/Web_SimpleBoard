package sw.simpleBoard;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sw.comment.biz.CommentBiz;
import sw.comment.dto.CommentEntity;
import sw.dto.entity.Member;
import sw.dto.entity.PostEntity;
import sw.simpleBoard.biz.SimpleBoardBiz;
import sw.util.MyUtil;

/**
 * 하나의 게시글을 보여줌
 */
@WebServlet(urlPatterns = { "/showOnePost" })
public class ShowOnePostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 댓글 입력시 여기로 들어옴 댓글 불러오기 AJAX로 수정 예정
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Member member = MyUtil.getLoginMember(request);
			
			// 게시글 번호 불러오기
			request.setCharacterEncoding("UTF-8");
			String postNo = request.getParameter("postNo");
			System.out.println(postNo);
			// 게시글 불러오기
			PostEntity post = SimpleBoardBiz.selectPost(postNo);

			// 댓글 불러오기 AJAX로 수정 예정
			List<CommentEntity> comments = CommentBiz.getComments(postNo);

			RequestDispatcher rd = request.getRequestDispatcher("board/showOnePost.jsp");
			request.setAttribute("post", post);
			request.setAttribute("comments", comments);
			rd.forward(request, response);
		} catch (Exception e) {
			MyUtil.catchExceptionInServlet(request, response, e);
		}
	}

}
