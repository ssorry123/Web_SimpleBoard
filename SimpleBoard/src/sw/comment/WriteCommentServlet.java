//package sw.comment;
//
//import java.io.IOException;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import sw.comment.biz.CommentBiz;
//import sw.member.dto.Member;
//import sw.util.MyUtil;
//
///**
// * Servlet implementation class WriteCommentServlet
// */
//@WebServlet(urlPatterns = { "/writeComment" })
//public class WriteCommentServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//
//	@Override
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		try {
//			Member member = MyUtil.getLoginMember(request);
//
//			request.setCharacterEncoding("UTF-8");
//			String postNo = request.getParameter("postNo");
//			String comment = request.getParameter("writeComment");
//			System.out.println(postNo + ", " + comment);
//			
//			CommentBiz.writeComment(member, postNo, comment);
//			
//			RequestDispatcher rd = request.getRequestDispatcher("/showOnePost");
//			rd.forward(request, response);
//
//		} catch (Exception e) {
//			MyUtil.catchExceptionInServlet(request, response, e);
//		}
//	}
//
//}
