package sw.member.dto;

public class Member {
	private String id;
	private String passwd;
	private String name;

	public Member() {
		id = passwd = name = null;
	}
	
	public Member(String id, String passwd) {
		super();
		this.id = id;
		this.passwd = passwd;
	}


	public Member(String id, String passwd, String name) {
		super();
		this.id = id;
		this.passwd = passwd;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", passwd=" + passwd + ", name=" + name + "]";
	}

}
