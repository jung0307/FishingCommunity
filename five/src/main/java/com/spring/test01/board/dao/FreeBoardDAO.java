package com.spring.test01.board.dao;

import java.util.List;
import java.util.Map;

import com.spring.test01.board.vo.FreeBoardVO;
import com.spring.test01.board.vo.CommentVO;
import com.spring.test01.board.vo.ImageVO;

public interface FreeBoardDAO {

//	public List<FreeBoardVO> selectBoardList() throws Exception;
	public List<FreeBoardVO> selectBoardList(Map pagingMap) throws Exception;
	public List<FreeBoardVO> selectMainBoardList() throws Exception;
	public int selectCountBoardList() throws Exception;
	public int selectCountAllBoardList() throws Exception;
	public int selectCountAllBoardListBySearchText(Map pagingMap) throws Exception;
	public FreeBoardVO selectBoardContent(int boardNum) throws Exception;
	public void updateBoardCount(int boardNum) throws Exception;
	public int insertBoardContent(Map boardContentMap) throws Exception;
	public int insertImageFile(Map boardContentMap) throws Exception;
	public List<ImageVO> selectImageFileList(int boardNum) throws Exception;
	public int updateBoardContent(Map boardContentMap) throws Exception;
	public int deleteBoardContent(Map boardContentMap) throws Exception;
	public List<CommentVO> selectCommentByBoardNum(int boardNum) throws Exception;
	public int selectCommentHir(int commentGroup) throws Exception;
	public int selectCommentNum() throws Exception;
	public int insertComment(CommentVO commentVO)throws Exception;
	public int selectCommentCountByBoardNum(int boardNum) throws Exception;
	public int deleteComment(Map commentMap) throws Exception;
	public List<CommentVO> selectCountCommentGroupByBoardNum() throws Exception;
}
