package com.spring.test01.board.controller;

import java.awt.Image;
import java.io.File;
import java.net.http.HttpHeaders;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.test01.board.service.BoardService;
import com.spring.test01.board.service.FreeBoardService;
import com.spring.test01.board.vo.BoardVO;
import com.spring.test01.board.vo.CommentVO;
import com.spring.test01.board.vo.FreeBoardVO;
import com.spring.test01.board.vo.ImageVO;
import com.spring.test01.common.paging.Paging;

@RestController("freeBoardController")
public class FreeBoardControllerImpl implements FreeBoardController{

	@Autowired
	FreeBoardService boardService;
	@Autowired
	FreeBoardVO boardVO;
	
	ImageVO imageVO;
	
	List<FreeBoardVO> boardList;
	List<ImageVO> imageFileList;
	List<CommentVO> commentList;
	
	private static String ARTICLE_IMAGE_REPO_PATH = "c:\\spring\\img2";
	
	/* File settingFile = new File(ARTICLE_IMAGE_REPO_PATH); */
	
	@Override
	@RequestMapping(value = "/freeBoard/getBoardList" , method = RequestMethod.GET)
	public ModelAndView getBoardList(@RequestParam(required = false) String pagingNum ,@RequestParam(required = false) String searchSection,
			@RequestParam(required = false)String searchText,HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Free getBoardList 도달");
		
		Map<String , Object> pagingMap = new HashMap<String , Object>();
		
		 // 댓글 개수 보여주는 list
		
		int countBoardList = 0; // 총 게시물 수
		int count = 0;
		int pagingNumInt = 1; // 기본 pagingNum 값
		Paging paging = new Paging();
		
		// 고정값
		int pagingBlock = 5; // 한 화면에 보이는 페이지 블럭 수
		int pagingSize = 30; // 한 화면에 보이는 게시물 수
		
//		System.out.println("searchSection : "+searchSection);
		
		
		// searchSection에 따라 구분해서 map에 넣어줌
			if(searchSection!=null) {
				if(searchSection.equals("boardID")) {
					System.out.println("searchSection : " + searchSection);
					pagingMap.put("boardID", searchSection);
				}else if(searchSection.equals("boardTitle")) {
					System.out.println("searchSection : " + searchSection);
					pagingMap.put("boardTitle", searchSection);
				}else if(searchSection.equals("boardContent")) {
					System.out.println("searchSection : " + searchSection);
					pagingMap.put("boardContent", searchSection);
				}
			}
			
			System.out.println("searchSection : "+searchSection);
		

		// 검색어가 있을 경우
		if(searchText!=null && !searchText.equals("")) {
			System.out.println("searchSection : "+searchSection);
			System.out.println("searchText : "+searchText);
			pagingMap.put("searchText", searchText.trim());
//			pagingMap.put("searchSection", searchSection.trim());
			countBoardList = boardService.getCountAllBoardListBySearchText(pagingMap);
			System.out.println("countBoardList : " + countBoardList);
		}
		// 검색어가 없을 경우
		else {
			System.out.println("searchText 없음");
			searchText = "";
			countBoardList = boardService.getCountAllBoardList(); // max(boardNum)
			System.out.println("countBoardList : " + countBoardList);
		}
		
//		countBoardList = boardService.getCountAllBoardList(); // max(boardNum)
		
		int totalBlock = (int) Math.ceil(((double)countBoardList / pagingSize));
		System.out.println("(countBoardList / pagingSize) : "+((double)countBoardList / pagingSize));
		if(pagingNum!=null) {
			 pagingNumInt = Integer.parseInt(pagingNum);
		}
		System.out.println("pagingMap : "+pagingNumInt);
		int startNum = (pagingSize * (pagingNumInt - 1)) + 1; // db에서 가져올 때 사용하는 변수
		int endNum = (pagingSize * pagingNumInt); // 마찬가지
		
		pagingMap.put("startNum", startNum);
		pagingMap.put("endNum", endNum);
		
		
		System.out.println("pagingBlock :  "+pagingBlock);
		System.out.println("pagingNumInt :  "+pagingNumInt);
		System.out.println("pagingSize :  "+pagingSize);
		System.out.println("totalBlock :  "+totalBlock);
		System.out.println("countBoardList :  "+countBoardList);
		System.out.println("startNum :  "+startNum);
		System.out.println("endNum :  "+endNum);
		
		String path = "freeBoard";
		String action = "getBoardList";
		
//		int pagingBlock,int pagingNum, int totalBlock, int totalNum
		String pagingMessage = paging.pagination(pagingBlock, pagingNumInt, totalBlock, countBoardList,searchSection,searchText,req,path,action);
//		String pagingMessage = paging.pagination(5, 1, 30, 533, req);
		ModelAndView mav = new ModelAndView("freeBoard");
//		boardList = boardService.getBoardList();
		boardList = boardService.getBoardList(pagingMap);
		commentList = boardService.getCountCommentGroupByBoardNum();  // 댓글 개수 보여주는 list
		
		
		for(int i = 0; i < boardList.size(); i++) {
//			System.out.println("iiiii boardList 단");
//			System.out.println(boardList.get(i).getBoardNum());
			for(int j = 0; j < commentList.size(); j++) {
//				System.out.println("jjjjj commentList단");
//				System.out.println(commentList.get(j).getBoardNum());
				if(boardList.get(i).getBoardNum() == commentList.get(j).getBoardNum()) {	
					boardList.get(i).setCommentCount(commentList.get(j).getCommentCount());
//					System.out.println("boardList에 CommentCount입력 완료");
					
				}
				
			}
			
		}
		
//		countBoardList = boardService.getCountBoardList(); count(*)
//		System.out.println(boardList.get(0).getBoardCount());
//		System.out.println(boardList.get(0).getBoardDate());
		mav.addObject("boardList", boardList);
//		mav.addObject("commentList", commentList);
		mav.addObject("countBoardList", countBoardList);
		mav.addObject("startNum", startNum);
		mav.addObject("endNum", endNum);
		mav.addObject("pagingNum", pagingNum);
		mav.addObject("pagingMessage", pagingMessage);
		
		
		return mav;
	}
	
	@Override
	@RequestMapping(value = "/freeBoard/getBoardContent.do" , method = RequestMethod.GET)
	public ModelAndView getBoardContent(@RequestParam("boardNum") int boardNum, HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Free getBoardContent 도달");
		System.out.println(boardNum);
		ModelAndView mav = new ModelAndView("freeBoardContentView");
		boardService.gainBoardCount(boardNum);
		boardVO = boardService.getBoardContent(boardNum);
		imageFileList = boardService.getImageFileList(boardNum);
		for(ImageVO s : imageFileList) {
			System.out.println("imageFileList : "+ s.getContentNum());
			System.out.println("imageFileList : "+ s.getImageFileName());
			System.out.println("imageFileList : "+ s.getImageFileNo());
			System.out.println("imageFileList : "+ s.getRegDate());
		}
		
		System.out.println("boardPwd : "+boardVO.getBoardPwd());
		mav.addObject("boardVO",boardVO);
		mav.addObject("imageFileList",imageFileList);
		return mav;
	}
	
	@Override
	@RequestMapping(value = "/freeBoard/writeBoardContent.do" , method = RequestMethod.GET)
	public ModelAndView writeBoardContent(@RequestParam(required = false) String boardID, HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Free writeBoardContent 도달");
		System.out.println(boardID);
		
		ModelAndView mav = new ModelAndView("freeBoardContentForm");
 		return mav;
	}
	
	@Override
	@RequestMapping(value = "/freeBoard/uploadBoardContent.do")
	public ResponseEntity uploadBoardContent(MultipartHttpServletRequest mReq, HttpServletResponse resp) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Free uploadBoardContent 도달");
		
		mReq.setCharacterEncoding("utf-8");
		
		String message;
		ResponseEntity resEnt;
		org.springframework.http.HttpHeaders responseHeaders = new org.springframework.http.HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		
		Map<String , Object> boardContentMap = new HashMap();
		List<String> fileList = upload(mReq);
		List<ImageVO> imageFileList = new ArrayList<ImageVO>();
		
		int boardNum = boardService.getCountBoardList()+1;
		String boardID = null;
		System.out.println("boardNum : "+boardNum);

		Enumeration enu = mReq.getParameterNames();
		while(enu.hasMoreElements()) {
			String name = (String) enu.nextElement();
			String value = mReq.getParameter(name);
			System.out.println("name : " + name + "  value : " + value );
			if(name.equals("boardID")) {
				boardID = value;
			}
			if(name.equals("boardContent")) {
				String value1 = value.replace("<div>", "<p>");
				String value2 = value1.replace("</div>", "</p>");
				value = value2;
			}
			boardContentMap.put(name, value);
		}
		
		if(fileList!=null) {
			int i = 1;
			for(String s : fileList) {
				imageVO = new ImageVO();
				imageVO.setImageFileName(s);
				imageVO.setContentNum(boardNum);
				imageVO.setImageFileNo(i++);
				System.out.println("getImageFileName 에서 추출 "+imageVO.getImageFileName());
				System.out.println("getContentNum 에서 추출 "+imageVO.getContentNum());
				System.out.println("getImageFileNo 에서 추출 "+imageVO.getImageFileNo());
				imageFileList.add(imageVO);
			}
		}
		
		boardContentMap.put("imageFileList", imageFileList);
		boardContentMap.put("boardNum", boardNum);
		
		try {
			
			  boardService.addBoardContent(boardContentMap);
			  if(imageFileList.size() == 0) {
				  System.out.println("imageFileList.size() == 0");
			  }else {				  
				  boardService.addImageFile(boardContentMap);
			  }
	

		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("addBoardContent : addImageFile 오류 ");
			e.printStackTrace();
		}
		
		try {
//			if(fileList!=null && fileList.size() !=0) {
//				File destDir = new File(ARTICLE_IMAGE_REPO_PATH + "\\" + boardNum);
//				for(String fileName : fileList) {
//					File srcFile = new File(ARTICLE_IMAGE_REPO_PATH + "\\" + "temp" + "\\" + fileName);
//					if(srcFile.exists()) {
//						FileUtils.moveFileToDirectory(srcFile, destDir, true);						
//					}
//				}
//			}
			message = "<script>";
			message = message + " alert('새글을 추가했습니다'); ";
			message = message + " location.href='" + mReq.getContextPath()+"/freeBoard/getBoardList';";
			message = message + " </script> ";
			
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
			
			
		}catch (Exception e) {
			// TODO: handle exception
			
//			if(fileList!=null && fileList.size() !=0) {
//				for(String fileName : fileList) {
//					File srcFile = new File(ARTICLE_IMAGE_REPO_PATH + "\\" + "temp" + "\\" + fileName);
//					srcFile.delete();
//				}
//			}
			message = "<script>";
			message = message + " alert('오류 발생! 다시 시도하십시오'); ";
			message = message + " location.href='" + mReq.getContextPath()+"/freeBoard/writeBoardContent.do?boardID="+boardID+"';";
			message = message + " </script> ";
			
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
			
			e.printStackTrace();
		}

		return resEnt;
	}
	

	/* consumes = "application/json;" */
	@Override
	@ResponseBody
	@RequestMapping(value = "/freeBoard/rewriteBoardContentForm.do" , method = RequestMethod.POST)
	public ModelAndView rewriteBoardContentForm(@ModelAttribute("boradVO") FreeBoardVO boardVO,HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		System.out.println("Free rewriteBoardContentForm 도달");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("freeBoardRewriteContentForm");
		mav.addObject("boardVO", boardVO);
//		System.out.println("getBoardContent : " + boardVO.getBoardContent());
//		System.out.println("getBoardCount : " +boardVO.getBoardCount());
//		System.out.println("getBoardDate : " +boardVO.getBoardDate());
//		System.out.println("getBoardID : " +boardVO.getBoardID());
//		System.out.println("getBoardNum : " +boardVO.getBoardNum());
//		System.out.println("getBoardTitle : " +boardVO.getBoardTitle());
//		System.out.println("getFileName : " +boardVO.getFileName());
		System.out.println("getBoardPwd : " +boardVO.getBoardPwd());
		return mav;
	}
	
	@Override
	@RequestMapping(value = "/freeBoard/rewriteBoardContent.do" , method = RequestMethod.POST)
	public ResponseEntity rewriteBoardContent(MultipartHttpServletRequest mReq, HttpServletResponse resp, @RequestParam("boardNum_") int boardNum_)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Free rewriteBoardContent 도달");
		
		mReq.setCharacterEncoding("utf-8");
		
		String message;
		int updateCount = 0;
		ResponseEntity resEnt;
		org.springframework.http.HttpHeaders responseHeaders = new org.springframework.http.HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		
		Map<String , Object> boardContentMap = new HashMap();
//		File dir = new File(ARTICLE_IMAGE_REPO_PATH+"\\"+boardNum_);
//		if(dir.exists()) {
//			FileUtils.cleanDirectory(dir);
//			System.out.println(boardNum_+"dir 삭제");
//		}
		List<String> fileList = upload(mReq);
		List<ImageVO> imageFileList = new ArrayList<ImageVO>();
		
		int boardNum = boardService.getCountBoardList()+1;
		String boardID = null;
		String boardPwd = null;
		System.out.println("boardNum : "+boardNum);

		Enumeration enu = mReq.getParameterNames();
		while(enu.hasMoreElements()) {
			String name = (String) enu.nextElement();
			String value = mReq.getParameter(name);
			System.out.println("name : " + name + "  value : " + value );
			if(name.equals("boardID")) {
				boardID = value;
			}
			if(name.equals("boardPwd")) {
				boardPwd = value;
			}
			if(name.equals("boardContent")) {
				String value1 = value.replace("<div>", "<p>");
				String value2 = value1.replace("</div>", "</p>");
				value = value2;
			}
			boardContentMap.put(name, value);
		}
		
		if(fileList!=null) {
			int i = 1;
			for(String s : fileList) {
				imageVO = new ImageVO();
				imageVO.setImageFileName(s);
				imageVO.setContentNum(boardNum);
				imageVO.setImageFileNo(i++);
				System.out.println("getImageFileName 에서 추출 "+imageVO.getImageFileName());
				System.out.println("getContentNum 에서 추출 "+imageVO.getContentNum());
				System.out.println("getImageFileNo 에서 추출 "+imageVO.getImageFileNo());
				imageFileList.add(imageVO);
			}
		}
		
//		boardContentMap.put("imageFileList", imageFileList);
//		boardContentMap.put("boardNum", boardNum);
		
		try {
			
			  updateCount = boardService.rewriteBoardContent(boardContentMap);
//			  boardService.addImageFile(boardContentMap);

		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("rewriteBoardContent : rewriteBoardContent 오류 ");
			e.printStackTrace();
		}
		
		try {
//			if(fileList!=null && fileList.size() !=0 && updateCount!=0) {
////				File destDir = new File(ARTICLE_IMAGE_REPO_PATH + "\\" + boardNum);
//				for(String fileName : fileList) {
//					File srcFile = new File(ARTICLE_IMAGE_REPO_PATH + "\\" + "temp" + "\\" + fileName);
//					if(srcFile.exists()) {
//						FileUtils.moveFileToDirectory(srcFile, dir, true);						
//					}
//				}
//			}
			message = "<script>";
			message = message + " alert('수정 완료!'); ";
			message = message + " location.href='" + mReq.getContextPath()+"/freeBoard/getBoardList';";
			message = message + " </script> ";
			
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
			
			
		}catch (Exception e) {
			// TODO: handle exception
			
//			if(fileList!=null && fileList.size() !=0) {
//				for(String fileName : fileList) {
//					File srcFile = new File(ARTICLE_IMAGE_REPO_PATH + "\\" + "temp" + "\\" + fileName);
//					srcFile.delete();
//				}
//			}
			message = "<script>";
			message = message + " alert('오류 발생! 다시 시도하십시오'); ";
			message = message + " location.href='" + mReq.getContextPath()+"/freeBoard/getBoardList';";
			message = message + " </script> ";
			
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
			
			e.printStackTrace();
		}

		return resEnt;
	}
	
	@Override
	@RequestMapping(value = "/freeBoard/removeBoardContent.do" , method = RequestMethod.GET)
	public ResponseEntity removeBoardContent(HttpServletRequest req, HttpServletResponse resp, @RequestParam("boardNum") int boardNum,
		@RequestParam("boardPwdStr") String boardPwdStr , @RequestParam(required = false) String role) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Free removeBoardContent 도달");
		int deleteCount = 0;
//		int boardPwd = 0;
		String boardPwd = "";
		String message;
		
		Map boardContentMap = new HashMap();
		org.springframework.http.HttpHeaders responseHeaders = new org.springframework.http.HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		
		System.out.println("boardPwdStr : "+boardPwdStr + " boardNum : "+boardNum + " role : " + role);
		
		if(boardPwdStr!="") {
			System.out.println("boardPwdStr!=\"\"");
//			boardPwd = Integer.parseInt(boardPwdStr);
			boardPwd = boardPwdStr;
		}
		
		if(role.equals("admin") || boardPwdStr!="") {
			System.out.println("role.equals(\"admin\")");
			boardContentMap.put("boardNum", boardNum);
			boardContentMap.put("boardPwd", boardPwd);
			deleteCount = boardService.removeBoardContent(boardContentMap);			
		}else {
			message = "<script> ";
			message = message + " alert('삭제 실패!'); ";
			message = message + " location.href='" + req.getContextPath()+"/freeBoard/getBoardList';";
			message = message + " </script> ";
			
			return new ResponseEntity(message,responseHeaders,HttpStatus.OK);
		}
		
		if(deleteCount!=0) {
			
//			File dir = new File(ARTICLE_IMAGE_REPO_PATH + "\\" + boardNum);
//			if(dir.isDirectory()) {
//				FileUtils.cleanDirectory(dir);
//				dir.delete();
//				System.out.println("dir 삭제");
//			}
			
			message = "<script> ";
			message = message + " alert('삭제 완료!'); ";
			message = message + " location.href='" + req.getContextPath()+"/freeBoard/getBoardList';";
			message = message + " </script> ";
			
			return new ResponseEntity(message,responseHeaders,HttpStatus.OK);
		}else {
			message = "<script> ";
			message = message + " alert('삭제 실패!'); ";
			message = message + " location.href='" + req.getContextPath()+"/freeBoard/getBoardList';";
			message = message + " </script> ";
			
			return new ResponseEntity(message,responseHeaders,HttpStatus.OK);
		}
	}
	
	@Override
	@ResponseBody
	@RequestMapping(value = "/freeBoard/addComment.do" , method = RequestMethod.POST , produces = "application/text; charset=UTF-8")
	public String addComment(@RequestBody CommentVO commentVO, HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Free addComment 도달");
		int count = 0;
		
		Map<String,Object> commentMap = new HashMap<String, Object>();
		
//		System.out.println("commentVO.getBoardNum() : "+commentVO.getBoardNum());
//		System.out.println("commentVO.getCommentContent() : "+commentVO.getCommentContent());
//		System.out.println("commentVO.getCommentDate() : "+commentVO.getCommentDate());
//		System.out.println("commentVO.getCommentGroup() : "+commentVO.getCommentGroup());
//		System.out.println("commentVO.getCommentHir() : "+commentVO.getCommentHir());
//		System.out.println("commentVO.getCommentID() : "+commentVO.getCommentID());
		
		System.out.println("commentPwd : " + commentVO.getCommentPwd());
		
		count = boardService.addComment(commentVO);
		if(count!=0) {
			System.out.println("댓글 입력 완료!");
		}else {
			System.out.println("댓글 입력 실패");
		}
		commentList = boardService.getCommentList(commentVO.getBoardNum());
		
		for(CommentVO c : commentList) {
			System.out.println("commentNum : "+ c.getCommentNum());
		}
		
		commentMap.put("commentList", commentList);
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonMap = mapper.writeValueAsString(commentMap);
		System.out.println(jsonMap);
		return jsonMap;
		
	}
	
	@Override
	@ResponseBody
	@RequestMapping(value = "/freeBoard/addComment2.do" , method = RequestMethod.POST , produces = "application/text; charset=UTF-8")
	public String addComment2(@RequestBody CommentVO commentVO, HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("Free addComment2 도달");
		int count = 0;
		
		Map<String,Object> commentMap = new HashMap<String, Object>();
		
		System.out.println("commentVO.getBoardNum() : "+commentVO.getBoardNum());
		System.out.println("commentVO.getCommentContent() : "+commentVO.getCommentContent());
		System.out.println("commentVO.getCommentDate() : "+commentVO.getCommentDate());
		System.out.println("commentVO.getCommentGroup() : "+commentVO.getCommentGroup());
		System.out.println("commentVO.getCommentHir() : "+commentVO.getCommentHir());
		System.out.println("commentVO.getCommentID() : "+commentVO.getCommentID());
		
		
		
		count = boardService.addComment(commentVO);
		if(count!=0) {
			System.out.println("댓글2 입력 완료!");
		}else {
			System.out.println("댓글2 입력 실패");
		}
		commentList = boardService.getCommentList(commentVO.getBoardNum());
		
		for(CommentVO c : commentList) {
			System.out.println("commentGroup : "+ c.getCommentGroup());
			System.out.println("commentHir : "+ c.getCommentHir());
		}
		
		commentMap.put("commentList", commentList);
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonMap = mapper.writeValueAsString(commentMap);
		System.out.println(jsonMap);
		return jsonMap;

	}
	
	@Override
	@ResponseBody
	@RequestMapping(value = "/freeBoard/getCommentList.do" , method = RequestMethod.GET , produces = "application/text; charset=UTF-8")
	public String getCommentList(@RequestParam("boardNum") int boardNum, HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Free getCommentList 도달");
		Map<String, Object> commentMap = new HashMap<String, Object>();
		
		commentList = boardService.getCommentList(boardNum);
		commentMap.put("commentList", commentList);
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonMap = mapper.writeValueAsString(commentMap);
		System.out.println(jsonMap);

		return jsonMap;
	}
	
	@Override
	@ResponseBody
	@RequestMapping(value = "/freeBoard/removeComment.do" , method = RequestMethod.POST , produces = "application/text; charset=utf-8")
	public String removeComment(@RequestBody CommentVO commentVO, HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("Free removeComment 도달");
		
		Map commentMap = new HashMap();
		
		int count = 0;
		int commentNum = commentVO.getCommentNum();
		int boardNum = commentVO.getBoardNum();
		String commentPwd = commentVO.getCommentPwd();
		String role = commentVO.getRole();
		
		System.out.println("commentContent : " + commentVO.getCommentContent());
		System.out.println("commentNum : " + commentNum);
		System.out.println("boardNum : " + boardNum);
		System.out.println("commentPwd : " + commentPwd);

		System.out.println("role : " + role);
		
		if(role.equals("admin")) {
			System.out.println("role : " + role);
			commentMap.put("commentNum", commentNum);
			count = boardService.removeComment(commentMap);
		}else {
			commentMap.put("commentNum", commentNum);
			commentMap.put("commentPwd", commentPwd);
			count = boardService.removeComment(commentMap);
		}
		
		
		if(count!=0) {
			System.out.println("댓글 삭제 성공!");

		}else {
			System.out.println("댓글 삭제 실패!");
		
		}
		commentList = boardService.getCommentList(boardNum);
		
		for(CommentVO c : commentList) {
			System.out.println("commentGroup : "+ c.getCommentGroup());
			System.out.println("commentHir : "+ c.getCommentHir());
		}
		commentMap.clear();
		
		commentMap.put("commentList", commentList);
		ObjectMapper mapper = new ObjectMapper();
		String jsonMap = mapper.writeValueAsString(commentMap);
		System.out.println(jsonMap);
		
		return jsonMap;

	}
	
	
	private List<String> upload(MultipartHttpServletRequest mReq) throws Exception{
		List<String> fileList = new ArrayList<String>();
		Iterator<String> fileNames = mReq.getFileNames();
		
//		File temp = new File(ARTICLE_IMAGE_REPO_PATH+"\\"+"temp");
//		
//		if(!temp.exists()) {
//			temp.mkdirs();
//			System.out.println("temp 생성");
//		}else {
//			if(!temp.isDirectory()) {
//				temp.delete();
//				temp.mkdirs();
//				System.out.println("temp 삭제 후 다시 생성");
//			}
//			System.out.println("temp 이미 있음");
//		}
		
		while(fileNames.hasNext()) {
			String fileName = fileNames.next(); // input file name ex file1...file2...
			MultipartFile mFile = mReq.getFile(fileName);
			String originalFileName = mFile.getOriginalFilename();
//			System.out.println(originalFileName);
			fileList.add(originalFileName);
//			File file = new File(ARTICLE_IMAGE_REPO_PATH+"\\"+fileName);
//			if(mFile.getSize()!=0) {
//				if(!file.exists()) {
//					if(file.getParentFile().mkdirs()) {
//						file.createNewFile();
//					}
//				}
//			}
			
//			mFile.transferTo(new File(ARTICLE_IMAGE_REPO_PATH+"\\"+"temp"+"\\"+originalFileName));
		}
		return fileList;
	}
}
