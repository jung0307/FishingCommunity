package com.spring.test01.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.test01.member.vo.GuestBookVO;
import com.spring.test01.member.vo.MemberVO;

public interface MemberController {

	
	public ModelAndView main(HttpServletRequest req , HttpServletResponse resp)throws Exception;
	public ModelAndView memberPage(HttpServletRequest req , HttpServletResponse resp)throws Exception;
	public ResponseEntity addMember(@ModelAttribute("memberVO") MemberVO memberVO , HttpServletRequest req, HttpServletResponse resp)throws Exception;
	public ResponseEntity loginMember(@ModelAttribute("memberVO") MemberVO memberVO , RedirectAttributes rAttr,
			HttpServletRequest req, HttpServletResponse resp)throws Exception;
	public ModelAndView addMemberForm(HttpServletRequest req, HttpServletResponse resp) throws Exception;
	public ModelAndView loginMemberForm(HttpServletRequest req, HttpServletResponse resp) throws Exception;
	public ModelAndView loginMemberFormMain(HttpServletRequest req, HttpServletResponse resp) throws Exception;
	public ModelAndView welcomeIndex(HttpServletRequest req, HttpServletResponse resp) throws Exception;
	public ResponseEntity logout(@RequestParam("id") String id, HttpServletRequest req, HttpServletResponse resp)throws Exception;
	public ResponseEntity removeMember(@RequestParam("id") String id, HttpServletRequest req, HttpServletResponse resp)throws Exception;
	public ModelAndView updateMemberInfoForm(@RequestParam("id") String id, HttpServletRequest req, HttpServletResponse resp)throws Exception;
	public ResponseEntity updateMemberInfo(@ModelAttribute("memberVO") MemberVO memberVO, HttpServletRequest req, HttpServletResponse resp)throws Exception;
	public ModelAndView guestBookForm(@RequestParam("id") String id,HttpServletRequest req, HttpServletResponse resp)throws Exception;
	public ResponseEntity addGuestBook(@ModelAttribute GuestBookVO guestBookVO ,@RequestParam String guestBookId ,HttpServletRequest req, HttpServletResponse resp)throws Exception;
	
}
