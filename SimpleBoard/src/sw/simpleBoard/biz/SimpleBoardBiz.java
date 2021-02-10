package sw.simpleBoard.biz;

import java.sql.Connection;
import java.util.List;

import sw.dto.entity.Member;
import sw.dto.entity.PostEntity;
import sw.util.JDBC;

public class SimpleBoardBiz {

	/**
	 * 게시글에 해당하는 글을 수정한다
	 * @param post
	 * @throws Exception
	 */
	public static void updatePost(PostEntity post) throws Exception {
		Connection conn = null;
		try {
			conn = JDBC.getConn();
			conn.setAutoCommit(false);
			new SimpleBoardDao().updatePost(conn, post);
			JDBC.commit(conn);
		} catch (Exception e) {
			JDBC.rollback(conn);
			throw e;
		} finally {
			JDBC.close(conn);
		}
	}
	
	/**
	 * 글번호에 해당하는 글을 삭제한다.
	 * @param postNo
	 * @throws Exception
	 */
	public static void deletePost(String postNo) throws Exception {
		Connection conn = null;
		try {
			conn = JDBC.getConn();
			conn.setAutoCommit(false);
			new SimpleBoardDao().deletePost(conn, postNo);
			JDBC.commit(conn);
		} catch (Exception e) {
			JDBC.rollback(conn);
			throw e;
		} finally {
			JDBC.close(conn);
		}
	}
	
	
	/**
	 * 글 번호에 해당하는 게시글을 긁어온다(내용 포함)
	 * @param postNo
	 * @return
	 * @throws Exception
	 */
	public static PostEntity selectPost(String postNo) throws Exception {
		Connection conn = null;
		PostEntity ret = null;
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
	public static List<PostEntity> selectPostAll() throws Exception {
		Connection conn = null;
		List<PostEntity> ret = null;

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
	public static void insertPost(Member member, PostEntity post) throws Exception {

		Connection conn = null;
		try {
			// DB 컨넥션 획득
			conn = JDBC.getConn();
			conn.setAutoCommit(false);
			// DAO 생성
			new SimpleBoardDao().insertPost(conn, post);
			JDBC.commit(conn);
		} catch (Exception e) {
			JDBC.rollback(conn);
			throw e;
		} finally {
			// 컨넥션 해제
			JDBC.close(conn);
		}
	}
}
