package com.spring.test01.member.dao;

import java.util.List;

import com.spring.test01.member.vo.GuestBookVO;
import com.spring.test01.member.vo.MemberVO;

public interface MemberDAO {

	public int insertMember(MemberVO memberVO) throws Exception;
	public int selectOverLapId(String id) throws Exception;
	public MemberVO selectCheckId(MemberVO memberVO) throws Exception;
	public List<MemberVO> selectAllMember() throws Exception;
	public int deleteMember(String id) throws Exception;
	public int updateMemberInfo(MemberVO memberVO) throws Exception;
	public int insertGuestBook(GuestBookVO guestBookVO) throws Exception;
	public List<GuestBookVO> selectGuestBook(String id) throws Exception;
}
