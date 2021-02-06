package sw.simpleBoard.biz;

import java.sql.Connection;
import java.util.List;

import sw.dbms.JDBC;
import sw.member.dto.Member;
import sw.simpleBoard.dto.InsertPostEntity;
import sw.simpleBoard.dto.SelectPostEntity;

public class SimpleBoardBiz {
	/**
	 * 글 번호에 해당하는 게시글을 긁어온다(내용 포함)
	 * @param postNo
	 * @return
	 * @throws Exception
	 */
	public static SelectPostEntity selectPost(String postNo) throws Exception {
		Connection conn = null;
		SelectPostEntity ret = null;
		try {
			conn = JDBC.getConn();
			ret = new SimpleBoardDao().selectPost(conn, postNo);
		} catch (Exception e) {
			throw e;
		} finally {
			JDBC.close(conn);
		}

		return ret;
	}

	/**
	 * 모든 게시물을 불러온다 (내용은 불러오지 않는다.)
	 * 
	 * @return
	 * @throws Exception
	 */
	public static List<SelectPostEntity> selectPostAll() throws Exception {
		Connection conn = null;
		List<SelectPostEntity> ret = null;

		try {
			// DB 컨넥션 획득
			conn = JDBC.getConn();
			// DAO 생성
			ret = new SimpleBoardDao().selectPostAll(conn);
		} catch (Exception e) {
			throw e;
		} finally {
			// 컨넥션 해제
			JDBC.close(conn);
		}

		return ret;
	}

	/**
	 * 게시글 쓰기, 내용에 작성 정보를 추가해줄 예정
	 * 
	 * @param member
	 * @param post
	 * @throws Exception
	 */
	public static void insertPost(Member member, InsertPostEntity post) throws Exception {

		Connection conn = null;
		try {
			// 무언가 조작을 하고싶다.
			String content = post.getContent();
			post.setContent(content);

			// DB 컨넥션 획득
			conn = JDBC.getConn();
			conn.setAutoCommit(false);
			// DAO 생성
			new SimpleBoardDao().insertPost(conn, post);
			conn.commit();
		} catch (Exception e) {
			conn.rollback();
			throw e;
		} finally {
			// 컨넥션 해제
			JDBC.close(conn);
		}
	}
}
