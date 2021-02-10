package sw.comment.biz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sw.comment.dto.CommentEntity;
import sw.util.JDBC;

public class CommentDao {
	
	public List<CommentEntity> getComments(Connection conn, String postNo) throws Exception {
		String query = "SELECT `userid`, `username`, `comment`, `date` FROM `simpleboard`.`tb_comment` WHERE `postno` = ? order by `date`";
		PreparedStatement stmt = null;
		ResultSet rset = null;
		List<CommentEntity> ret = null;
		
		try {
			ret = new ArrayList<>();
			
			stmt = JDBC.setQuery(conn, query, postNo);
			rset = stmt.executeQuery();
			
			while(rset.next()){
				CommentEntity ce = new CommentEntity();
				ce.setUserId(rset.getString(1));
				ce.setUserName(rset.getString(2));
				ce.setComment(rset.getString(3));
				ce.setDateTime(rset.getString(4));
				ret.add(ce);
			}

		} catch (Exception e) {
			if (e instanceof SQLException) {
				e = new SQLException("댓글을 불러올 수 없습니다.");
			}
			throw e;
		} finally {
			JDBC.close(rset);
			JDBC.close(stmt);
		}
		return ret;
	}
	
	
	/**
	 * 댓글을 db에 삽입한다.
	 * @param conn
	 * @param cE
	 * @throws Exception
	 */
	public void wrtieComment(Connection conn, CommentEntity cE) throws Exception {
		String query = "INSERT INTO `simpleboard`.`tb_comment` (`postNo`, `userid`, `username`, `comment`) VALUES (?,?,?,?)";
		PreparedStatement stmt = null;

		try {
			stmt = JDBC.setQuery(conn, query, cE.getPostNo(), cE.getUserId(), cE.getUserName(), cE.getComment());
			int ret = stmt.executeUpdate();

			if (ret != 1) {
				throw new Exception("댓글을 작성할 수 없습니다.");
			}

		} catch (Exception e) {
			if (e instanceof SQLException) {
				e = new SQLException("댓글을 작성할 수 없습니다.");
			}
			throw e;
		} finally {
			JDBC.close(stmt);
		}
	}

}
