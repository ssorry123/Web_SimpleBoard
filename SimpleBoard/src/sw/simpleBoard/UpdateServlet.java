package sw.simpleBoard;

import java.io.IOException;

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
 * Servlet implementation class UpdateServlet
 */
@WebServlet(urlPatterns = { "/update" })
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 글 번호 받고 수정 페이지로 옮긴다.
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Member member = MyUtil.getLoginMember(req);
			req.setCharacterEncoding("UTF-8");

			// 수정할 글을 불러오고 수정 페이지로 넘긴다.
			String postNo = (String) req.getParameter("postNo");
			System.out.println("전달받은 글 번호 update " + postNo);

			PostEntity post = SimpleBoardBiz.selectPost(postNo);
			// 유효성 검사(본인 게시글인지 확인)
			if (!member.getId().equals(post.getUserId())) {
				throw new Exception("본인 글이 아니거나 세션이 만료되었습니다.");
			}

			// db에는 <br>로 저장되어있는 뉴라인을 textarea에서 뉴라인으로 보이도록 수정
			post.setContent(post.getContent().replace("<br>", "\n"));

			RequestDispatcher rd = req.getRequestDispatcher("/board/update.jsp");
			req.setAttribute("post", post);
			rd.forward(req, resp);
		} catch (Exception e) {
			MyUtil.catchExceptionInServlet(req, resp, e);
		}
	}

	/**
	 * 변경하고 포워드
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Member member = MyUtil.getLoginMember(request);

			// 유효성 검사, 본인 글인지 확인
			request.setCharacterEncoding("UTF-8");
			String postUserId = request.getParameter("postUserId");
			if (!member.getId().equals(postUserId)) {
				throw new Exception("본인 글이 아니거나 세션이 만료되었습니다.");
			}

			String postNo = request.getParameter("postNo");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			PostEntity post = new PostEntity();
			post.setNo(postNo);
			post.setTitle(title);
			post.setContent(content);
			SimpleBoardBiz.updatePost(post);
			
			RequestDispatcher rd = request.getRequestDispatcher("/board/showOnePost.jsp");
			post = SimpleBoardBiz.selectPost(postNo);
			request.setAttribute("post", post);
			rd.forward(request, response);
			
		} catch (Exception e) {
			MyUtil.catchExceptionInServlet(request, response, e);
		}
	}

}
