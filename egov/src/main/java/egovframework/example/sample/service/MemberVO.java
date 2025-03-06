package egovframework.example.sample.service;

public class MemberVO {
	private String id;
	private String pw;
	private String name;
	private String computer;
	public MemberVO(String id, String computer) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.computer = computer;
	}
	public MemberVO( String id, String pw, String name, String computer) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.computer = computer;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getComputer() {
		return computer;
	}
	public void setComputer(String computer) {
		this.computer = computer;
	}
	

}
