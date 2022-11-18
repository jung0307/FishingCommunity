package com.spring.test01.board.dao;

import java.util.List;
import java.util.Map;

import com.spring.test01.board.vo.BoardVO;
import com.spring.test01.board.vo.CommentVO;
import com.spring.test01.board.vo.GoodAndBadVO;
import com.spring.test01.board.vo.ImageVO;

public interface BoardDAO {

//	public List<BoardVO> selectBoardList() throws Exception;
	public List<BoardVO> selectBoardList(Map pagingMap) throws Exception;
	public List<BoardVO> selectMainBoardList() throws Exception;
	public int selectCountBoardList() throws Exception;
	public int selectCountAllBoardList() throws Exception;
	public int selectCountAllBoardListBySearchText(Map pagingMap) throws Exception;
	public BoardVO selectBoardContent(int boardNum) throws Exception;
	public void updateBoardCount(int boardNum) throws Exception;
	public int insertBoardContent(Map boardContentMap) throws Exception;
	public int insertImageFile(Map boardContentMap) throws Exception;
	public List<ImageVO> selectImageFileList(int boardNum) throws Exception;
	public int updateBoardContent(Map boardContentMap) throws Exception;
	public int deleteBoardContent(Map boardContentMap) throws Exception;
	public int deleteBoardContentByAdmin(Map boardContentMap) throws Exception;
	public List<CommentVO> selectCommentByBoardNum(int boardNum) throws Exception;
	public int selectCommentHir(int commentGroup) throws Exception;
	public int selectCommentNum() throws Exception;
	public int insertComment(CommentVO commentVO)throws Exception;
	public int selectCommentCountByBoardNum(int boardNum) throws Exception;
	public int deleteComment(int commentNum) throws Exception;
	public List<CommentVO> selectCountCommentGroupByBoardNum() throws Exception;
	public int selectId(Map goodAndBadMap) throws Exception;
	public int selectUp(int boardNum) throws Exception;
	public int selectDown(int boardNum) throws Exception;
	public int selectCountUpById(Map goodAndBadMap) throws Exception;
	public int selectCountDownById(Map goodAndBadMap) throws Exception;
	public List<GoodAndBadVO> selectAllContentUpAndDown() throws Exception;
	public int insertUpAndDown(Map goodAndBadMap) throws Exception;
	public int updateUpDown(Map goodAndBadMap) throws Exception;
	public int deleteGoodAndBad(int boardNum) throws Exception;
}
