package sw.simpleBoard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sw.member.dto.Member;
import sw.simpleBoard.biz.SimpleBoardBiz;
import sw.simpleBoard.dto.PostEntity;
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
			Member member = MyUtil.getLoginMember(request);

			request.setCharacterEncoding("UTF-8");
			String title = request.getParameter("title");
			String content = request.getParameter("content");

			// 유저 아이디와 이름을 둘다 저장하자
			PostEntity post = new PostEntity(title, content, member);
			System.out.println(post);
			SimpleBoardBiz.insertPost(member, post);

			MyUtil.alertAndSendRedirect(response, request.getContextPath() + "/simpleBoard", "글 작성이 완료되었습니다");
		} catch (Exception e) {
			MyUtil.catchExceptionInServlet(request, response, e);
		}
	}

}
