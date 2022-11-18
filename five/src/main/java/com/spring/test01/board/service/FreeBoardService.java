package com.spring.test01.board.service;

import java.util.List;
import java.util.Map;

import com.spring.test01.board.vo.FreeBoardVO;
import com.spring.test01.board.vo.CommentVO;
import com.spring.test01.board.vo.ImageVO;

public interface FreeBoardService {


//	public List<FreeBoardVO> getBoardList() throws Exception;
	public List<FreeBoardVO> getBoardList(Map pagingMap) throws Exception;
	public List<FreeBoardVO> getMainBoardList() throws Exception;
	public int getCountBoardList() throws Exception;
	public int getCountAllBoardList() throws Exception;
	public int getCountAllBoardListBySearchText(Map pagingMap) throws Exception;
	public FreeBoardVO getBoardContent(int boardNum) throws Exception;
	public void gainBoardCount(int boardNum) throws Exception;
	public int addBoardContent(Map boardContentMap) throws Exception;
	public int addImageFile(Map boardContentMap) throws Exception;
	public List<ImageVO> getImageFileList(int boardNum) throws Exception; 
	public int rewriteBoardContent(Map boardContentMap) throws Exception;
	public int removeBoardContent(Map boardContentMap) throws Exception;
	public List<CommentVO> getCommentList(int boardNum) throws Exception;
	public int addComment(CommentVO commentVO) throws Exception;
	public int getCommentCountByBoardNum(int boardNum) throws Exception;
	public int removeComment(Map commentMap) throws Exception;
	public List<CommentVO> getCountCommentGroupByBoardNum() throws Exception;

}
