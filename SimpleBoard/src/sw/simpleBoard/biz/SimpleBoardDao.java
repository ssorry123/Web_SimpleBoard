package sw.simpleBoard.biz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sw.dbms.JDBC;
import sw.simpleBoard.dto.InsertPostEntity;
import sw.simpleBoard.dto.SelectPostEntity;
import sw.util.MyUtil;

public class SimpleBoardDao {
	public SelectPostEntity selectPost(Connection conn, String postNo) throws Exception {
		// 모든 게시글 불러옴. 내용은 불러오지 않음
		String query = "SELECT NO, userid, title, DATE, content FROM simpleboard.tb_simpleboard WHERE NO = ?";
		PreparedStatement stmt = null;
		ResultSet rset = null;
		SelectPostEntity ret = null;

		try {
			stmt = MyUtil.setQuery(conn, query, postNo);
			rset = stmt.executeQuery();

			if (rset.next()) {
				ret = new SelectPostEntity();
				ret.setNo(rset.getString(1));
				ret.setUserId(rset.getString(2));
				ret.setTitle(rset.getString(3));
				ret.setDateTime(rset.getString(4));
				ret.setContent(rset.getString(5));
			} else {
				throw new Exception("해당하는 게시글이 삭제되거나 문제가 있습니다.");
			}

		} catch (Exception e) {
			if (e instanceof SQLException) {
				e = new SQLException("게시글 불러오기 실패");
			}
			throw e;
		} finally {
			JDBC.close(rset);
			JDBC.close(stmt);
		}
		return ret;
	}

	public List<SelectPostEntity> selectPostAll(Connection conn) throws Exception {
		// 모든 게시글 불러옴. 내용은 불러오지 않음
		String query = "SELECT `no`, `userid`, `title`, `date` FROM `simpleboard`.tb_simpleboard ORDER BY DATE DESC, NO DESC LIMIT 1000";
		PreparedStatement stmt = null;
		ResultSet rset = null;
		List<SelectPostEntity> ret = null;

		try {
			stmt = conn.prepareStatement(query);

			rset = stmt.executeQuery();

			ret = new ArrayList<>();
			while (rset.next()) {
				String no = rset.getString(1);
				String userid = rset.getString(2);
				String title = rset.getString(3);
				String date = rset.getString(4);

				ret.add(new SelectPostEntity(no, title, userid, date));
			}

		} catch (Exception e) {
			if (e instanceof SQLException) {
				e = new SQLException("게시글 불러오기 실패");
			}
			throw e;
		} finally {
			JDBC.close(rset);
			JDBC.close(stmt);
		}
		return ret;
	}

	/**
	 * 게시글 DB에 넣기
	 * 
	 * @param conn
	 * @param post
	 * @throws Exception
	 */
	public void insertPost(Connection conn, InsertPostEntity post) throws Exception {
		String query = "INSERT INTO `simpleboard`.`tb_simpleboard` (`userid`, `title`, `content`) VALUES (?, ?, ?)";
		PreparedStatement stmt = null;

		try {
			stmt = MyUtil.setQuery(conn, query, post.getUserId(), post.getTitle(), post.getContent());
			int ret = stmt.executeUpdate();

			if (ret != 1)
				throw new Exception("error : 게시글 작성 실패");

		} catch (Exception e) {
			if (e instanceof SQLException) {
				e = new SQLException("게시글 작성 실패");
			}
			throw e;
		} finally {
			JDBC.close(stmt);
		}
	}
}
