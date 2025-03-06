package egovframework.example.sample.service.impl;

import java.util.Map;
import org.apache.ibatis.annotations.Param;
import org.egovframe.rte.psl.dataaccess.mapper.Mapper;
import egovframework.example.sample.service.MemberVO;

@Mapper("dainMapper")
public interface DainMapper {
    void insertMember(MemberVO vo);

    MemberVO selectMemberById(@Param("id") String id, @Param("pw") String pw);

    void updateComputer(@Param("id") String id, @Param("computer") String computer);

	MemberVO getMember(@Param("id") String id);
}
