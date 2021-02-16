package sw.util;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sw.dto.entity.Member;

public class MyUtil {

	public static String getWebContentRealPath() {
		String t = File.separator;
		String ret = "D:" + t + "web" + t + "SimpleBoard" + t + "WebContent";
		return ret;
	}

	/**
	 * 세션을 살펴보고 현재 로그인되어있는지 확인한다.
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public static Member getLoginMember(HttpServletRequest request) throws Exception {
		Member member = null;
		HttpSession session = request.getSession(false);
		if (session == null)
			throw new Exception("세션 만료1");
		member = (Member) session.getAttribute("member");
		if (member == null)
			throw new Exception("세션 만료2");

		return member;
	}

	/**
	 * alert를 실행하고 다른 페이지로 리다이렉트 한다.
	 * 
	 * @param response
	 * @param url
	 * @param msg
	 * @throws Exception
	 */
	public static void alertAndSendRedirect(HttpServletResponse response, String url, String msg) throws Exception {
		response.setContentType("text/html; charset=UTF-8");

		String str = String.format("<script>alert('%s'); location.href='%s';</script>", msg, url);

		PrintWriter out = response.getWriter();
		out.println(str);
		out.flush();
	}

	/**
	 * 세션에 에러값 입력후 에러 페이지로 이동
	 * 
	 * @param req
	 * @param resp
	 * @param e
	 * @throws IOException
	 */
	public static void catchExceptionInServlet(HttpServletRequest req, HttpServletResponse resp, Exception e)
			throws IOException {
		e.printStackTrace();
		req.getSession().invalidate();
		req.getSession().setAttribute("msg", e.getMessage());
		resp.sendRedirect(req.getContextPath() + "/msg.jsp");
	}

}
