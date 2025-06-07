package egovframework.example.sample.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.example.sample.service.DainService;
import egovframework.example.sample.service.MemberVO;

@Service
public class DainServiceImpl implements DainService{
	
	@Resource(name="dainMapper")
	private DainMapper dainMapper;

	@Override
	public MemberVO getMemberInfo(String id, String pw) {
		MemberVO vo = dainMapper.selectMemberById(id, pw);
		return vo;
	}

	@Override
	public void addMemberInfo(String id, String pw, String name, String computer) {
		dainMapper.insertMember(new MemberVO(id, pw, name, computer));
	}

	@Override
	public void updateComputer(String id, String computer) {
		dainMapper.updateComputer(id, computer);
	}

	@Override
	public MemberVO getMember(String id) {
		MemberVO vo = dainMapper.getMember(id);
		return vo;
	}

}
