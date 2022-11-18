package com.spring.test01.member.service;

import java.util.List;

import com.spring.test01.member.vo.GuestBookVO;
import com.spring.test01.member.vo.MemberVO;

public interface MemberService {

	public int addMember(MemberVO memberVO) throws Exception;
	public int checkOverLapId(String id) throws Exception;
	public MemberVO checkMember(MemberVO memberVO) throws Exception;
	public List<MemberVO> getAllMember() throws Exception;
	public int removeMember(String id) throws Exception;
	public int updateMemberInfo(MemberVO memberVO) throws Exception;
	public int addGuestBook(GuestBookVO guestBookVO) throws Exception;
	public List<GuestBookVO> getGuestBook(String id) throws Exception;
}
