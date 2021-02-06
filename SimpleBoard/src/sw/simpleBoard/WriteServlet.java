package sw.simpleBoard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sw.member.dto.Member;
import sw.simpleBoard.biz.SimpleBoardBiz;
import sw.simpleBoard.dto.InsertPostEntity;
import sw.util.MyUtil;

/**
 * 글쓰기 기능
 */
@WebServlet(urlPatterns = { "/write" })
public class WriteServlet extends HttpServlet {
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
			if (member == null) {
				throw new Exception("세션만료");
			}

			request.setCharacterEncoding("UTF-8");
			String title = request.getParameter("title");
			String content = request.getParameter("content");

			InsertPostEntity post = new InsertPostEntity(title, member.getId(), content);
			System.out.println(post);
			SimpleBoardBiz.insertPost(member, post);

			MyUtil.alertAndSendRedirect(response, request.getContextPath() + "/simpleBoard", "글 작성이 완료되었습니다");
		} catch (Exception e) {
			MyUtil.catchExceptionInServlet(request, response, e);
		}
	}

}
