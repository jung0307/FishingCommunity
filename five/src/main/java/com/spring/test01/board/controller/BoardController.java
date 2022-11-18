package com.spring.test01.board.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.spring.test01.board.vo.BoardVO;
import com.spring.test01.board.vo.CommentVO;
import com.spring.test01.board.vo.GoodAndBadVO;

public interface BoardController {

	public ModelAndView getBoardList(@RequestParam(required = false)String pagingNum,@RequestParam(required = false) String searchSection,
			@RequestParam(required = false)String searchText ,HttpServletRequest req , HttpServletResponse resp) throws Exception;
	public ModelAndView getBoardContent(@RequestParam("boardNum") int boardNum , HttpServletRequest req, HttpServletResponse resp) throws Exception;
	public ModelAndView writeBoardContent(@RequestParam("boardID") String boardID, 
			HttpServletRequest req, HttpServletResponse resp) throws Exception;
	public ResponseEntity uploadBoardContent(MultipartHttpServletRequest mReq, HttpServletResponse resp) throws Exception;
	public ModelAndView rewriteBoardContentForm(@RequestBody BoardVO boardVO,HttpServletRequest req, HttpServletResponse resp) throws Exception;
	public ResponseEntity rewriteBoardContent(MultipartHttpServletRequest mReq, HttpServletResponse resp , int boardNum) throws Exception;
	public ResponseEntity removeBoardContent(HttpServletRequest req, HttpServletResponse resp,int boardNum , String boardID,String role) throws Exception;
	public String addComment(@RequestBody CommentVO commentVO , HttpServletRequest req, HttpServletResponse resp)throws Exception;
	public String addComment2(@RequestBody CommentVO commentVO , HttpServletRequest req, HttpServletResponse resp)throws Exception;
	public String getCommentList(@RequestParam("boardNum") int boardNum, HttpServletRequest req, HttpServletResponse resp)throws Exception;
	public String removeComment(@RequestBody CommentVO commentVO , HttpServletRequest req, HttpServletResponse resp) throws Exception;
	public String goodAndBad(@RequestBody GoodAndBadVO goodAndBadVO , HttpServletRequest req, HttpServletResponse resp) throws Exception;
	

}
