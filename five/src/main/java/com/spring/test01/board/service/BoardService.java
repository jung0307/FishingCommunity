package com.spring.test01.board.service;

import java.util.List;
import java.util.Map;

import com.spring.test01.board.vo.BoardVO;
import com.spring.test01.board.vo.CommentVO;
import com.spring.test01.board.vo.GoodAndBadVO;
import com.spring.test01.board.vo.ImageVO;

public interface BoardService {


//	public List<BoardVO> getBoardList() throws Exception;
	public List<BoardVO> getBoardList(Map pagingMap) throws Exception;
	public List<BoardVO> getMainBoardList() throws Exception;
	public int getCountBoardList() throws Exception;
	public int getCountAllBoardList() throws Exception;
	public int getCountAllBoardListBySearchText(Map pagingMap) throws Exception;
	public BoardVO getBoardContent(int boardNum) throws Exception;
	public void gainBoardCount(int boardNum) throws Exception;
	public int addBoardContent(Map boardContentMap) throws Exception;
	public int addImageFile(Map boardContentMap) throws Exception;
	public List<ImageVO> getImageFileList(int boardNum) throws Exception; 
	public int rewriteBoardContent(Map boardContentMap) throws Exception;
	public int removeBoardContent(Map boardContentMap) throws Exception;
	public int removeBoardContentByAdmin(Map boardContentMap) throws Exception;
	public List<CommentVO> getCommentList(int boardNum) throws Exception;
	public int addComment(CommentVO commentVO) throws Exception;
	public int getCommentCountByBoardNum(int boardNum) throws Exception;
	public int removeComment(int commentNum) throws Exception;
	public List<CommentVO> getCountCommentGroupByBoardNum() throws Exception;
	public int selectId(Map goodAndBadMap) throws Exception;
	public int selectUp(int boardNum) throws Exception;
	public int selectDown(int boardNum) throws Exception;
	public int selectCountUpById(Map goodAndBadMap) throws Exception;
	public int selectCountDownById(Map goodAndBadMap) throws Exception;
	public List<GoodAndBadVO> selectAllContentUpAndDown() throws Exception;
	
	public int insertUpAndDown(Map goodAndBadMap) throws Exception;
	public int updateUpDown(Map goodAndBadMap) throws Exception;
	public int removeGoodAndBad(int boardNum)throws Exception;


}
