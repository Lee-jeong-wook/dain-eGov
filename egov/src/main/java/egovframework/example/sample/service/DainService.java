package egovframework.example.sample.service;

public interface DainService {
	public MemberVO getMemberInfo(String id, String pw);
	public void addMemberInfo(String id, String pw, String name, String computer);
	public void updateComputer(String id, String computer);
	public MemberVO getMember(String id);

}
