package sw.comment;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import sw.comment.biz.CommentBiz;
import sw.member.dto.Member;
import sw.util.MyUtil;

/**
 * Servlet implementation class WriteCommentServlet
 */
@WebServlet(urlPatterns = { "/ajaxWriteComment" })
public class AjaxWriteCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {

			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=utf-8");

			Member member = MyUtil.getLoginMember(request);
			String postNo = request.getParameter("postNo");
			String comment = request.getParameter("comment");
			System.out.println(postNo + ", " + comment);

			CommentBiz.writeComment(member, postNo, comment);
			
			PrintWriter out = response.getWriter();
			
			JSONObject json = new JSONObject();
			json.put("id", member.getId());
			json.put("name", member.getName());
			out.print(json.toJSONString());

		} catch (Exception e) {
			MyUtil.catchExceptionInServlet(request, response, e);
		}
	}

}
