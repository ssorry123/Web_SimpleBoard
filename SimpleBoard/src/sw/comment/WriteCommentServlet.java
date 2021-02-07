package sw.comment;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sw.comment.biz.CommentBiz;
import sw.member.dto.Member;
import sw.util.MyUtil;

/**
 * Servlet implementation class WriteCommentServlet
 */
@WebServlet(urlPatterns = { "/writeComment" })
public class WriteCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Member member = MyUtil.getLoginMember(request);

			request.setCharacterEncoding("UTF-8");
			String postNo = request.getParameter("commentPostNo");
			String comment = request.getParameter("writeComment");
			System.out.println(postNo + ", " + comment);
			
			CommentBiz.writeComment(member, postNo, comment);

			// AJAX로 수정 예정
			HttpSession session = request.getSession(false);
			session.setAttribute("postNo", postNo);
			
			response.sendRedirect(request.getContextPath() + "/showOnePost");

		} catch (Exception e) {
			MyUtil.catchExceptionInServlet(request, response, e);
		}
	}

}
