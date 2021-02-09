package sw.simpleBoard.dto;

import sw.member.dto.Member;

public class PostEntity {
	private String no;
	private String title;
	private String userId;
	private String userName;
	private String dateTime;
	private String content;

	/**
	 * 글 쓰기 데이터 전달 용
	 * 
	 * @param title
	 * @param content
	 * @param member
	 */
	public PostEntity(String title, String content, Member member) {
		super();
		this.title = title;
		this.content = content;
		this.userId = member.getId();
		this.userName = member.getName();
		no = dateTime = null;
	}

	/**
	 * 전체 게시글 목록 보여주기용 생성자
	 * 
	 * @param no
	 * @param title
	 * @param userId
	 * @param dateTime
	 */
	public PostEntity(String no, String title, String userId, String dateTime) {
		super();
		this.no = no;
		this.title = title;
		this.userId = userId;
		this.dateTime = dateTime;
		this.content = null;
	}

	public PostEntity() {
		// TODO Auto-generated constructor stub
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
