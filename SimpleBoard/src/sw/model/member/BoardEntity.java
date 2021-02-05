package sw.model.member;

public class BoardEntity {
	private String no;
	private String title;
	private String user;
	private String date;

	public BoardEntity() {

	}

	public BoardEntity(String no, String title, String user, String date) {
		super();
		this.no = no;
		this.title = title;
		this.user = user;
		this.date = date;
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

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
