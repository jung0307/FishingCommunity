package com.spring.test01.member.controller;

import java.net.http.HttpHeaders;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jca.cci.object.EisOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.test01.board.dao.BoardDAO;
import com.spring.test01.board.service.BoardService;
import com.spring.test01.board.service.BoardServiceImpl;
import com.spring.test01.board.service.FreeBoardService;
import com.spring.test01.board.service.FreeBoardServiceImpl;
import com.spring.test01.board.vo.BoardVO;
import com.spring.test01.board.vo.CommentVO;
import com.spring.test01.board.vo.FreeBoardVO;
import com.spring.test01.board.vo.GoodAndBadVO;
import com.spring.test01.common.random.RandomGuestBookColor;
import com.spring.test01.member.service.MemberService;
import com.spring.test01.member.vo.GuestBookVO;
import com.spring.test01.member.vo.MemberVO;

@Controller("memberController")
public class MemberControllerImpl implements MemberController{

	@Autowired
	MemberService memberService;
	@Autowired
	MemberVO member;
	@Autowired
	BoardService boardService;
	@Autowired
	FreeBoardService freeBoardService;
	
	List<MemberVO> memberList = new ArrayList<MemberVO>();
	List<GuestBookVO> guestBookList = new ArrayList<GuestBookVO>();
	List<GoodAndBadVO> goodAndBadList = new ArrayList<GoodAndBadVO>();
	
	
	@Override
	@RequestMapping(value = "/" , method = RequestMethod.GET)
	public ModelAndView main(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("main으로 오기");
		
		// 실험
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		List<FreeBoardVO> freeBoardList = new ArrayList<FreeBoardVO>();
		List<CommentVO> commentList = new ArrayList<CommentVO>();
		
		int countBoardList1 = 0;
		int countBoardList2 = 0;
		
//		BoardServiceImpl boardService = new BoardServiceImpl();
//		FreeBoardServiceImpl freeBoardService = new FreeBoardServiceImpl();
		
		boardList = boardService.getMainBoardList();
		freeBoardList = freeBoardService.getMainBoardList();
		
		countBoardList1 = boardService.getCountAllBoardList();
		countBoardList2 = freeBoardService.getCountAllBoardList();
		
		commentList = boardService.getCountCommentGroupByBoardNum();  // 댓글 개수 보여주는 list
		goodAndBadList = boardService.selectAllContentUpAndDown(); // 추천수 수 보여주는 list
		
		// board 추천 수 넣어주기
		goodAndBadList = boardService.selectAllContentUpAndDown();
		for(int i =0; i<boardList.size(); i++) {
			for(int j = 0; j < goodAndBadList.size(); j++) {
				if(boardList.get(i).getBoardNum() == goodAndBadList.get(j).getBoardNum()) {
					boardList.get(i).setUpCount(goodAndBadList.get(j).getUp());
				}
			}
		}
		
		// board 댓글 수 넣어주기
		for(int i = 0; i < boardList.size(); i++) {
			for(int j = 0; j < commentList.size(); j++) {
				if(boardList.get(i).getBoardNum() == commentList.get(j).getBoardNum()) {	
					boardList.get(i).setCommentCount(commentList.get(j).getCommentCount());
					System.out.println("boardNum "+boardList.get(i).getBoardNum()+" 댓글 수 : ======== " + boardList.get(i).getCommentCount());
				}
			}
		}
		
		
		
		commentList = freeBoardService.getCountCommentGroupByBoardNum();  // 댓글 개수 보여주는 list
		
		// freeBoard 댓글 수 넣어주기
		for(int i = 0; i < freeBoardList.size(); i++) {
			for(int j = 0; j < commentList.size(); j++) {
				if(freeBoardList.get(i).getBoardNum() == commentList.get(j).getBoardNum()) {	
					freeBoardList.get(i).setCommentCount(commentList.get(j).getCommentCount());
				}
			}
		}		
		

		ModelAndView mav = new ModelAndView("main");
		mav.addObject("boardList", boardList);
		mav.addObject("freeBoardList", freeBoardList);
		mav.addObject("countBoardList1", countBoardList1);
		mav.addObject("countBoardList2", countBoardList2);
		return mav;
	}
	
	@Override
	@RequestMapping(value = "/member/memberPage.do" , method = RequestMethod.GET)
	public ModelAndView memberPage(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("memberPage 도달");
		ModelAndView mav = new ModelAndView("memberPage");
		
		memberList = memberService.getAllMember();
		
		mav.addObject("memberList", memberList);
		
		return mav;
	}
	
	@Override
	@RequestMapping(value = "/member/addMember.do" , method = RequestMethod.POST)
	public ResponseEntity addMember(@ModelAttribute("memberVO") MemberVO memberVO, HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		org.springframework.http.HttpHeaders responseHeaders = new org.springframework.http.HttpHeaders();
//		int count = 0;
//		count = memberService.addMember(memberVO);
//		if(count == 0) {
//			System.out.println("addMember 실패");
//		}else {
//			System.out.println("addMember 성공");
//		}
		int overLapCount = 0;
		
		String id = memberVO.getId();
		System.out.println("addMember id = " + id);
		
		overLapCount = memberService.checkOverLapId(id);
		System.out.println("overLapCount = " + overLapCount);
		if(overLapCount!=0) {
			System.out.println("중복된 아이디 입니다.");
			responseHeaders.add("Content-Type", "text/html; charset=utf-8");
			String message = "<script>";
			message =  message+" alert('중복된 아이디 입니다'); ";
			message =  message+" location.href='"+req.getContextPath()+"/member/addMemberForm.do'; ";
			message =  message+" </script> ";
			return new ResponseEntity(message,responseHeaders,HttpStatus.CREATED);
			
		}else {
			responseHeaders.add("Content-Type", "text/html; charset=utf-8");
			String message = "<script>";
			message = message + " alert('가입이 완료되었습니다.'); ";
			message = message + " alert('로그인 하십시오.'); ";
			message = message + " location.href='"+req.getContextPath()+"'; ";
			message = message + " </script> ";
			memberService.addMember(memberVO);
			return new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);

		}
		
	
	}
	@Override
	@RequestMapping(value = "/member/addMemberForm.do" , method = RequestMethod.GET)
	public ModelAndView addMemberForm(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		ModelAndView mav = new ModelAndView("addMemberForm");
		return mav;
	}
	
	@Override
	@RequestMapping(value = "/member/loginMemberForm2.do" , method = RequestMethod.GET)
	public ModelAndView loginMemberForm(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// TODO Auto-generated method stub
		ModelAndView mav = new ModelAndView("/member/loginMemberForm2");
		return mav;
	}
	
	@Override
	@RequestMapping(value = "/member/loginMemberFormMain.do" , method = RequestMethod.GET)
	public ModelAndView loginMemberFormMain(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// TODO Auto-generated method stub
		ModelAndView mav = new ModelAndView("loginMemberFormMain");
		return mav;
	}
	
	@Override
	@RequestMapping(value = "/member/welcomeIndex.do" , method = RequestMethod.GET)
	public ModelAndView welcomeIndex(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// TODO Auto-generated method stub
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/member/welcomeIndex");
		return mav;
		
//		HttpSession session = req.getSession();
//		if(session.getAttribute("memberMap")!=null) {
//			mav.setViewName("/member/welcomeIndex");
//			
//			return mav;
//		}else {
//			session.invalidate();
//			mav.setViewName("/member/loginMemberForm");
//			return mav;
//		}
	}
	
	@Override
	@RequestMapping(value = "/member/loginMember.do" , method = RequestMethod.POST)
	public ResponseEntity loginMember(@ModelAttribute MemberVO memberVO, RedirectAttributes rAttr ,
			HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
//		Map<String,Object> memberMap = new HashMap();
		
		String logIn = "off";
		
//		int overLapCount = 0;
//		
//		String id = memberVO.getId();
//		
//		overLapCount = memberService.checkOverLapId(id);
//		if(overLapCount==0) {
//			System.out.println("중복된 아이디 입니다.");
//		}else {
//			System.out.println("사용 가능한 아이디 입니다.");
//		}
		
		org.springframework.http.HttpHeaders responseHeaders = new org.springframework.http.HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		
//		HttpSession session = req.getSession();
		
		 member = memberService.checkMember(memberVO);
		 
		 
		 // member 객체가 있을 경우
		 if(member!=null) {
			 // 로그인 성공
			 if(memberVO.getId().equals(member.getId()) && memberVO.getPwd().equals(member.getPwd())) {
				 HttpSession session = req.getSession();
				 logIn = "on";
				 
//				 memberMap.put("logIn", logIn);
//				 memberMap.put("memberVO", memberVO);
				 System.out.println(logIn);
				 System.out.println(memberVO.getId());
//				 session.setAttribute("memberMap", memberMap);
				 
				 session.setAttribute("memberVO", member);
				 session.setAttribute("logIn", logIn);
				 
				 String message = " <script> ";
				 message = message + " alert('반갑습니다 "+member.getId()+"님!');  ";
//				 message = message + " location.href='/test01/member/welcomeIndex.do'  ";
				 message = message + " location.href='"+req.getContextPath()+"';  ";
				 message = message + " </script>  ";
				 
				 return new ResponseEntity(message, responseHeaders, HttpStatus.OK);
			 // 로그인 실패
			 }else{
				 
				 String message = " <script> ";
				 message = message + " alert('로그인 실패!');  ";
//				 message = message + " location.href='/test01/member/loginMemberForm.do'  ";
				 message = message + " location.href='"+req.getContextPath()+"';  ";
				 message = message + " </script>  ";
				 
				 return new ResponseEntity(message, responseHeaders, HttpStatus.OK);
			 }
		 // member 객체가 없을 경우
		 }else {
			 String message = " <script> ";
			 message = message + " alert('로그인 실패!');  ";
//			 message = message + " location.href='/test01/member/loginMemberForm.do'  ";
			 message = message + " location.href='"+req.getContextPath()+"';  ";
			 message = message + " </script>  ";
			 
			 return new ResponseEntity(message, responseHeaders, HttpStatus.OK);
		 }
		
	}
	
	@Override
	@RequestMapping(value = "/member/logout.do" , method = RequestMethod.GET)
	public ResponseEntity logout(@RequestParam("id") String id, HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		org.springframework.http.HttpHeaders responseHeader = new org.springframework.http.HttpHeaders();
		responseHeader.add("Content-Type", "text/html;charset=utf-8");
		
		System.out.println(" /member/logout.do "+id);
		
		HttpSession session = req.getSession();
		if(session.getAttribute("memberVO")!=null) {
			
			member = (MemberVO) session.getAttribute("memberVO");
			
			if(member.getId().equals(id)) {
				session.invalidate();
				
				String message = " <script> ";
				message = message + " alert('로그아웃 완료'); ";
//				message = message + " location.href='/test01/member/loginMemberForm.do'; ";
				 message = message + " location.href='"+req.getContextPath()+"';";
				message = message + " </script> ";
				
				return new ResponseEntity(message, responseHeader, HttpStatus.OK);
			}else {
				String message = " <script> ";
				message = message + " alert('로그아웃 실패'); ";
//				message = message + " location.href='/test01/member/welcomeIndex.do'; ";
				message = message + " location.href='"+req.getContextPath()+"';  ";
				message = message + " </script> ";
				
				return new ResponseEntity(message, responseHeader, HttpStatus.OK);
			}
			
		}else {
			String message = " <script> ";
			message = message + " alert('로그아웃 실패'); ";
			message = message + " location.href='"+req.getContextPath()+"/member/welcomeIndex.do'; ";
			message = message + " </script> ";
			
			return new ResponseEntity(message, responseHeader, HttpStatus.OK);
		}
	}
	
	@Override
	@RequestMapping(value = "/member/removeMember" , method = RequestMethod.GET)
	public ResponseEntity removeMember(@RequestParam String id, HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// TODO Auto-generated method stub
		int count = 0;
		String message;
		count = memberService.removeMember(id);
		
		org.springframework.http.HttpHeaders responseHeaders = new org.springframework.http.HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");

		message = "<script> ";
		if(count!=0) {
			message = message + " alert('회원 삭제 완료!'); ";
		}else {
			message = message + " alert('회원 삭제 실패!'); ";
		}
		message = message + " location.href='"+req.getContextPath()+"/member/memberPage.do'; ";
		message = message + "</script>";
		
		return new ResponseEntity(message, responseHeaders, HttpStatus.OK);
	}
	
	@Override
	@RequestMapping(value = "/member/updateMemberInfoForm.do" , method = RequestMethod.GET)
	public ModelAndView updateMemberInfoForm(@RequestParam String id, HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("updateMemberInfoForm 도달");
		
		ModelAndView mav = new ModelAndView("updateMemberInfoForm");
		mav.addObject("id", id);
		System.out.println("id : "+id);
		return mav;
	}
	
	@Override
	@RequestMapping(value = "/member/updateMemberInfo.do" , method = RequestMethod.POST)
	public ResponseEntity updateMemberInfo(@ModelAttribute(value = "memberVO") MemberVO memberVO, HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		System.out.println("updateMemberInfo 도달");
		
		String message;
		int count = 0;
		
		org.springframework.http.HttpHeaders responseHeaders = new org.springframework.http.HttpHeaders();
		
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		
		// System.out.println("id : " + memberVO.getId()); 
		System.out.println("pwd : " + memberVO.getPwd());
		
		count = memberService.updateMemberInfo(memberVO);
		
		message = "<script> ";
		if(count!=0) {
			message = message + " alert('회원 수정 완료!'); ";
		}else {
			message = message + " alert('회원 수정 실패!'); ";
		}
		message = message + " location.href='"+req.getContextPath()+"/member/memberPage.do'; ";
		message = message + "</script>";
		
		return new ResponseEntity(message, responseHeaders, HttpStatus.OK);
		
	}
	
	@Override
	@RequestMapping(value = "/member/guestBookForm.do" , method = RequestMethod.GET)
	public ModelAndView guestBookForm(@RequestParam("id") String id, HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("guestBookForm 도달");
		System.out.println("id : "+id);
		guestBookList = memberService.getGuestBook(id);
		
		ModelAndView mav = new ModelAndView("guestBookForm");
		mav.addObject("id", id);
		mav.addObject("guestBookList", guestBookList);
		return mav;
	}
	
	@Override
	@RequestMapping(value = "/member/addGuestBook.do" , method = RequestMethod.POST)
	public ResponseEntity addGuestBook(@ModelAttribute GuestBookVO guestBookVO, @RequestParam String id ,HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
		// TODO Auto-generated method stub
		
		String message = "";
		
		System.out.println("addGuestBook 도달");
		
		System.out.println("guestID : " + guestBookVO.getGuestID());
		System.out.println("id : " + id);
		System.out.println("message : " + guestBookVO.getMessage());
		System.out.println("role : " + guestBookVO.getRole());
		
		guestBookVO.setId(id);
		
		int randomNumber = (int)(Math.random()*8);
		String classColor = "";
		RandomGuestBookColor rgbc = new RandomGuestBookColor();
		classColor = rgbc.randomGuestBookColor(randomNumber);
		System.out.println("randomNumber : " + randomNumber);
		
		guestBookVO.setClassColor(classColor);
		
		int count = 0;
		count = memberService.addGuestBook(guestBookVO);
		
		org.springframework.http.HttpHeaders responseHeaders = new org.springframework.http.HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		
		message = message + "<script>";
		if(count!=0) {
			System.out.println("guestBook 등록 성공!");
			message = message + " alert('등록 성공!'); ";
		}else {
			System.out.println("guestBook 등록 실패!");
			message = message + " alert('등록 실패!'); ";
		}
		
		
		message = message + " location.href='"+req.getContextPath()+"/member/guestBookForm.do?id="+id+"'; ";
		message = message + "</script>";
		
		return new ResponseEntity(message,responseHeaders, HttpStatus.OK);

	}
}
