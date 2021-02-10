package sw.comment.biz;

import java.sql.Connection;
import java.util.List;

import sw.comment.dto.CommentEntity;
import sw.dto.entity.Member;
import sw.util.JDBC;

public class CommentBiz {

	/**
	 * 게시글에 해당하는 댓글들을 불러온다.
	 * @param postNo
	 * @return
	 * @throws Exception
	 */
	public static List<CommentEntity> getComments(String postNo) throws Exception {
		Connection conn = null;
		List<CommentEntity> ret = null;
		try {
			conn = JDBC.getConn();
			ret = new CommentDao().getComments(conn, postNo);

		} catch (Exception e) {
			throw e;
		} finally {
			JDBC.close(conn);
		}

		return ret;
	}

	/**
	 * 댓글을 작성한다.
	 * 
	 * @param member
	 * @param postNo
	 * @param comment
	 * @throws Exception
	 */
	public static void writeComment(Member member, String postNo, String comment) throws Exception {
		Connection conn = null;

		try {
			conn = JDBC.getConn();
			conn.setAutoCommit(false);

			CommentEntity cE = new CommentEntity(member, postNo, comment);
			new CommentDao().wrtieComment(conn, cE);

			JDBC.commit(conn);
		} catch (Exception e) {
			JDBC.rollback(conn);
			throw e;
		} finally {
			JDBC.close(conn);
		}
	}

}
