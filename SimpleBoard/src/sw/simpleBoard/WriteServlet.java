package sw.simpleBoard;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import sw.dto.entity.Member;
import sw.dto.entity.PostEntity;
import sw.simpleBoard.biz.SimpleBoardBiz;
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

			//// 파일 포함 post 받기(request.getParam 불가)
			// 사진을 실제로 저장할 폴더 생성
			String WebContentRealPath = MyUtil.getWebContentRealPath(); // WebContent 폴더에 저장
			String uploadFolder = "serverFile"; // 폴더 한단계 더
			String uploadRealFolder = WebContentRealPath + File.separator + uploadFolder;
			File folder = new File(uploadRealFolder);
			if (!folder.exists()) {
				folder.mkdir();
				System.out.println("새로운 폴더 생성");
			}
			int size = 15 * 1024 * 1024; // 15mb 제한

			// post 요청 받기 클래스 생성
			MultipartRequest mr = new MultipartRequest(request, uploadRealFolder, size, "UTF-8",
					new DefaultFileRenamePolicy());

			// 유저가 입력한 내용들 저장
			PostEntity post = new PostEntity(member);

			String title = mr.getParameter("title");
			String content = mr.getParameter("content");
			post.setTitle(title);
			post.setContent(content);

			// 유저가 올린 파일 보기
			Enumeration files = mr.getFileNames();

			String param = (String) files.nextElement(); // jsp name
			String picServerFileName = mr.getFilesystemName(param); // 서버에 저장되는 파일 이름
			String picOriginFileName = mr.getOriginalFileName(param); // 유저가 올릴때 파일 이름

			if (picServerFileName != null) {
				System.out.println(param + ", " + picServerFileName + ", " + picOriginFileName);
				post.setPicPath(uploadFolder + "/" + picServerFileName); // "/"로 해야함(브라우저상에서)}
			} else {
				System.out.println("사진 안올림");
				post.setPicPath(null);
			}

			System.out.println(post);
			SimpleBoardBiz.insertPost(member, post); // db 저장

			MyUtil.alertAndSendRedirect(response, request.getContextPath() + "/simpleBoard", "글 작성이 완료되었습니다");
		} catch (Exception e) {
			MyUtil.catchExceptionInServlet(request, response, e);
		}
	}

}
