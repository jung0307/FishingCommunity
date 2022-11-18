package com.spring.test01.member.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.test01.member.vo.GuestBookVO;
import com.spring.test01.member.vo.MemberVO;

@Repository("membrDAO")
public class MemberDAOImpl implements MemberDAO{

	@Autowired
	SqlSession session;
	@Autowired
	MemberVO member;
	
	int count = 0;
	
	List<MemberVO> memberList = new ArrayList<MemberVO>();
	List<GuestBookVO> guestBookList = new ArrayList<GuestBookVO>();
	
	@Override
	public int insertMember(MemberVO memberVO) throws Exception {
		// TODO Auto-generated method stub
		int count = 0;
		
		count = session.insert("mapper.member.insertMember" , memberVO);
		
		return count;
	}
	
	@Override
	public int selectOverLapId(String id) throws Exception {
		// TODO Auto-generated method stub
		int count = 0;
		
		count = session.selectOne("mapper.member.selectOverLapId", id);
		
		return count;
	}
	
	@Override
	public MemberVO selectCheckId(MemberVO memberVO) throws Exception {
		// TODO Auto-generated method stub
		member = (MemberVO)session.selectOne("mapper.member.selectCheckId", memberVO);
//		System.out.println(member.getId() + " /// " + member.getPwd());
		return member;
	}
	
	@Override
	public List<MemberVO> selectAllMember() throws Exception {
		// TODO Auto-generated method stub
		memberList = session.selectList("mapper.member.selectAllMember");
		return memberList;
	}
	
	@Override
	public int deleteMember(String id) throws Exception {
		// TODO Auto-generated method stub
		count = session.delete("mapper.member.deleteMember", id);
		return count;
	}
	
	@Override
	public int updateMemberInfo(MemberVO memberVO) throws Exception {
		// TODO Auto-generated method stub
		count = session.update("mapper.member.updateMemberInfo", memberVO);
		return count;
	}
	
	@Override
	public int insertGuestBook(GuestBookVO guestBookVO) throws Exception {
		// TODO Auto-generated method stub
		count = session.insert("mapper.guestBook.insertGuestBook", guestBookVO);
		return count;
	}
	
	@Override
	public List<GuestBookVO> selectGuestBook(String id) throws Exception {
		// TODO Auto-generated method stub
		guestBookList = session.selectList("mapper.guestBook.selectGuestBook", id);
		return guestBookList;
	}

}
