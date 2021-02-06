package sw.simpleBoard.dto;

public class InsertPostEntity {
	private String title;
	private String userId;
	private String content;

	/**
	 * 
	 * @param title
	 * @param userId
	 * @param content
	 */
	public InsertPostEntity(String title, String userId, String content) {
		super();
		this.title = title;
		this.userId = userId;
		this.content = content;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "InsertPostEntity [title=" + title + ", userId=" + userId + ", content=" + content + "]";
	}

}
