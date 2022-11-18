package com.spring.test01.board.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.test01.board.vo.BoardVO;
import com.spring.test01.board.vo.CommentVO;
import com.spring.test01.board.vo.FreeBoardVO;
import com.spring.test01.board.vo.ImageVO;

@Repository("freeBoardDAO")
public class FreeBoardDAOImpl implements FreeBoardDAO{

	@Autowired
	SqlSession session;

	FreeBoardVO boardVO = new FreeBoardVO();
	CommentVO commentVO = new CommentVO();
	
	List<FreeBoardVO> boardList;
	List<ImageVO> imageFileList;
	List<CommentVO> commentList;
	int count = 0;
	
//	@Override
//	public List<BoardVO> selectBoardList() throws Exception {
//		// TODO Auto-generated method stub
//		boardList = session.selectList("mapper.board.selectBoardList");
//		return boardList;
//	}
	@Override
	public List<FreeBoardVO> selectBoardList(Map pagingMap) throws Exception {
		// TODO Auto-generated method stub
		boardList = session.selectList("mapper.freeBoard.selectBoardList",pagingMap);
		return boardList;
	}
	
	@Override
	public List<FreeBoardVO> selectMainBoardList() throws Exception {
		// TODO Auto-generated method stub
		boardList = session.selectList("mapper.freeBoard.selectMainBoardList");
		return boardList;
	}
	@Override
	public int selectCountBoardList() throws Exception {
		// TODO Auto-generated method stub
		try {
			count = session.selectOne("mapper.freeBoard.selectCountBoardList");
		}catch (Exception e) {
			// TODO: handle exception
			count = 0;
		}
		return count;
	}
	
	@Override
	public int selectCountAllBoardList() throws Exception {
		// TODO Auto-generated method stub
		count = session.selectOne("mapper.freeBoard.selectCountAllBoardList");
		return count;
	}
	
	@Override
	public int selectCountAllBoardListBySearchText(Map pagingMap) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("=====DAO========" + pagingMap.get("searchSection")+"=====DAO========");
		System.out.println("=====DAO========" + pagingMap.get("searchText")+"=====DAO========");
		count = session.selectOne("mapper.freeBoard.selectCountAllBoardListBySearchText", pagingMap);
		System.out.println("=====DAO===count===="+count+"=====DAO========");
		return count;
	}
	
	@Override
	public FreeBoardVO selectBoardContent(int boardNum) throws Exception {
		// TODO Auto-generated method stub
		boardVO = session.selectOne("mapper.freeBoard.selectBoardContent", boardNum);
		return boardVO;
	}
	
	@Override
	public void updateBoardCount(int boardNum) throws Exception {
		// TODO Auto-generated method stub
		session.update("mapper.freeBoard.updateBoardCount", boardNum);
	}
	
	@Override
	public int insertBoardContent(Map boardContentMap) throws Exception {
		// TODO Auto-generated method stub
		count = session.insert("mapper.freeBoard.insertBoardContent", boardContentMap);
		return count;
	}
	
	@Override
	public int insertImageFile(Map boardContentMap) throws Exception {
		// TODO Auto-generated method stub
		count = session.insert("mapper.freeBoard.insertImageFile", boardContentMap);
		return count;
	}
	
	@Override
	public List<ImageVO> selectImageFileList(int boardNum) throws Exception {
		// TODO Auto-generated method stub
		int contentNum = boardNum;
		imageFileList = session.selectList("mapper.freeBoard.selectImageFileList", contentNum);
		return imageFileList;
	}
	
	@Override
	public int updateBoardContent(Map boardContentMap) throws Exception {
		// TODO Auto-generated method stub
		int updateCount = 0;
		updateCount = session.update("mapper.freeBoard.updateBoardContent", boardContentMap);
		return updateCount;
	}
	
	@Override
	public int deleteBoardContent(Map boardContentMap) throws Exception {
		// TODO Auto-generated method stub
		int deleteCount = 0;
		deleteCount = session.delete("mapper.freeBoard.deleteBoardContent", boardContentMap);
		return deleteCount;
	}
	
	@Override
	public List<CommentVO> selectCommentByBoardNum(int boardNum) throws Exception {
		// TODO Auto-generated method stub
		commentList = session.selectList("mapper.freeComment.selectCommentByBoardNum", boardNum);
		return commentList;
	}
	
	@Override
	public int selectCommentNum() throws Exception {
		// TODO Auto-generated method stub
		int commentNum = 0;
		
		try {
			commentNum = session.selectOne("mapper.freeComment.selectCommentNum");
			return commentNum;
		}catch (Exception e) {
			// TODO: handle exception
			commentNum = 0;
			return commentNum;
		}
	}
	
	@Override
	public int selectCommentHir(int commentGroup) throws Exception {
		// TODO Auto-generated method stub
		int commentHir = 0;
		
		try {
			commentHir = session.selectOne("mapper.freeComment.selectCommentHir", commentGroup);
			return commentHir;
		}catch (Exception e) {
			// TODO: handle exception
			return commentHir;
		}
	}
	
	@Override
	public int insertComment(CommentVO commentVO) throws Exception {
		// TODO Auto-generated method stub
		int commentNum = (selectCommentNum()+1);
		commentVO.setCommentNum(commentNum);
		
		if(commentVO.getCommentHir() > 0) {
			int commentHir = 1;
			commentHir = (selectCommentHir(commentVO.getCommentGroup())) + 1;
			commentVO.setCommentHir(commentHir);
			count = session.insert("mapper.freeComment.insertComment2", commentVO);
		}else if(commentVO.getCommentHir() == 0) {
			count = session.insert("mapper.freeComment.insertComment", commentVO);
		}
		return count;
	}
	
	@Override
	public int selectCommentCountByBoardNum(int boardNum) throws Exception {
		// TODO Auto-generated method stub
		count = session.selectOne("mapper.freeComment.selectCommentCountByBoardNum", boardNum);
		return count;
	}
	
	 @Override
	public int deleteComment(Map commentMap) throws Exception {
		// TODO Auto-generated method stub
		 System.out.println("dc commentNum : "+commentMap.get("commentNum")); 
		 System.out.println("dc commentPwd : "+commentMap.get("commentPwd")); 
		 count = session.delete("mapper.freeComment.deleteComment", commentMap);
		return count;
	}
	 
	 @Override
	public List<CommentVO> selectCountCommentGroupByBoardNum() throws Exception {
		// TODO Auto-generated method stub
		 commentList = session.selectList("mapper.freeComment.selectCountCommentGroupByBoardNum");
		return commentList;
	}
	

	
}
