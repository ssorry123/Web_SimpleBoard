package sw.util;

public class SWException extends Exception {

	private static final long serialVersionUID = 397302860623597034L;

	private String type;
	private String content;

	public SWException() {
	}

	public SWException(String type, String content) {
		super();
		this.type = type;
		this.content = content;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
