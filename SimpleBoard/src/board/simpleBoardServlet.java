package board;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 게시판 내용 받은 후 게시판 페이지에 전달 Servlet implementation class simpleBoard
 */
@WebServlet(urlPatterns = { "/board/simpleBoard" })
public class simpleBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 게시글 목록 받고 jsp에 부려줌
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("get");
		// TODO Auto-generated method stub

		try {
			// 로그인 유효성 검사
			HttpSession session = request.getSession(false);
			String id = (String) session.getAttribute("id");
			if(id==null) {
				throw new Exception("유효하지 않은 로그인입니다.");
			}
			
			session.setAttribute("boards", getBoards());
			response.sendRedirect(request.getContextPath() + "/board/simpleBoard.jsp");
		} catch (Exception e) {
			request.getSession().invalidate();
			request.getSession().setAttribute("msg", e.getMessage());
			response.sendRedirect(request.getContextPath() + "/msg.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("post");
		doGet(request, response);
	}
	
	private List<BoardEntity> getBoards(){
		List<BoardEntity> ret = new ArrayList<>();
		
		// DBMS로 변경 예정
		ret.add(new BoardEntity("1", "그래가자", "홍길동", "1시"));
		ret.add(new BoardEntity("2", "그만가자", "고길동", "3시"));
		ret.add(new BoardEntity("3", "어디가냐", "나길동", "2시"));
		ret.add(new BoardEntity("4", "가지마라", "길길동", "4시"));
		
		return ret;
	}

}
