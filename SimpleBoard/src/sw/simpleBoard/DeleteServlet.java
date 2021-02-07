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
import sw.util.MyUtil;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet(urlPatterns = { "/delete" })
public class DeleteServlet extends HttpServlet {
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
			String postNo = request.getParameter("postNo");
			SimpleBoardBiz.deletePost(postNo);
			MyUtil.alertAndSendRedirect(response, request.getContextPath() + "/simpleBoard", "게시글이 성공적으로 삭제되었습니다.");

		} catch (Exception e) {
			MyUtil.catchExceptionInServlet(request, response, e);
		}
	}

}
