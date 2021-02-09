package sw.comment.dto;

import sw.dto.entity.Member;

public class CommentEntity {
	private String postNo;
	private String userId;
	private String userName;
	private String comment;
	private String dateTime;

	public CommentEntity() {

	}
	
	public CommentEntity(Member member, String postNo, String comment) {
		this.postNo = postNo;
		this.comment = comment;
		this.userId= member.getId();
		this.userName = member.getName();
		this.dateTime = null;
	}

	public CommentEntity(String postNo, String userId, String userName, String comment) {
		super();
		this.postNo = postNo;
		this.userId = userId;
		this.userName = userName;
		this.comment = comment;
	}

	public String getPostNo() {
		return postNo;
	}

	public void setPostNo(String postNo) {
		this.postNo = postNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

}
