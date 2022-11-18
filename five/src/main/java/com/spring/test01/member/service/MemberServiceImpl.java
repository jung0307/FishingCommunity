package com.spring.test01.member.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spring.test01.member.dao.MemberDAO;
import com.spring.test01.member.vo.GuestBookVO;
import com.spring.test01.member.vo.MemberVO;

@Service("memberService")
@Transactional(propagation = Propagation.REQUIRED)
public class MemberServiceImpl implements MemberService{

	@Autowired
	MemberDAO memberDAO;
	@Autowired
	MemberVO member;
	
	int count = 0;
	
	List<MemberVO> memberList = new ArrayList<MemberVO>();
	List<GuestBookVO> guestBookList = new ArrayList<GuestBookVO>();
	
	@Override
	public int addMember(MemberVO memberVO) throws Exception {
		int count = 0;
		count = memberDAO.insertMember(memberVO);
		return count;
	}
	
	@Override
	public int checkOverLapId(String id) throws Exception {
		// TODO Auto-generated method stub
		int count = 0;
		count = memberDAO.selectOverLapId(id);
		return count;
	}
	
	@Override
	public MemberVO checkMember(MemberVO memberVO) throws Exception {
		// TODO Auto-generated method stub
		member = memberDAO.selectCheckId(memberVO);
		return member;
	}
	
	@Override
	public List<MemberVO> getAllMember() throws Exception {
		// TODO Auto-generated method stub
		memberList = memberDAO.selectAllMember();
		return memberList;
	}
	
	@Override
	public int removeMember(String id) throws Exception {
		// TODO Auto-generated method stub
		count = memberDAO.deleteMember(id);
		return count;
	}
	
	@Override
	public int updateMemberInfo(MemberVO memberVO) throws Exception {
		// TODO Auto-generated method stub
		count = memberDAO.updateMemberInfo(memberVO);
		return count;
	}
	
	@Override
	public int addGuestBook(GuestBookVO guestBookVO) throws Exception {
		// TODO Auto-generated method stub
		count = memberDAO.insertGuestBook(guestBookVO);
		return count;
	}
	
	@Override
	public List<GuestBookVO> getGuestBook(String id) throws Exception {
		// TODO Auto-generated method stub
		guestBookList = memberDAO.selectGuestBook(id);
		return guestBookList;
	}

}
