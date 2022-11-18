package com.spring.test01.board.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spring.test01.board.dao.BoardDAO;
import com.spring.test01.board.vo.BoardVO;
import com.spring.test01.board.vo.CommentVO;
import com.spring.test01.board.vo.GoodAndBadVO;
import com.spring.test01.board.vo.ImageVO;

@Service("boardService")
@Transactional(propagation = Propagation.REQUIRED)
public class BoardServiceImpl implements BoardService{

	@Autowired
	BoardDAO boardDAO;
	
	BoardVO boardVO = new BoardVO();
	
	List<BoardVO> boardList;
	List<ImageVO> imageFileList;
	List<CommentVO> commentList;
	List<GoodAndBadVO> goodAndBadList; 
	int count = 0;
	
//	@Override
//	public List<BoardVO> getBoardList() throws Exception {
//		// TODO Auto-generated method stub
//		boardList = boardDAO.selectBoardList();
//		return boardList;
//	}
	
	@Override
	public List<BoardVO> getBoardList(Map pagingMap) throws Exception {
		// TODO Auto-generated method stub
		boardList = boardDAO.selectBoardList(pagingMap);
		return boardList;
	}
	
	@Override
	public List<BoardVO> getMainBoardList() throws Exception {
		// TODO Auto-generated method stub
		boardList = boardDAO.selectMainBoardList();
		return boardList;
	}
	
	
	@Override
	public int getCountBoardList() throws Exception {
		// TODO Auto-generated method stub
		count = boardDAO.selectCountBoardList();
		return count;
	}
	
	@Override
	public int getCountAllBoardList() throws Exception {
		// TODO Auto-generated method stub
		count = boardDAO.selectCountAllBoardList();
		return count;
	}
	
	@Override
	public int getCountAllBoardListBySearchText(Map pagingMap) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("=======service=======" + pagingMap.get("searchSection")+"=======service=======");
		System.out.println("=======service=======" + pagingMap.get("searchText")+"=======service=======");
		count = boardDAO.selectCountAllBoardListBySearchText(pagingMap);
		return count;
	}
	
	@Override
	public BoardVO getBoardContent(int boardNum) throws Exception {
		// TODO Auto-generated method stub
		boardVO = boardDAO.selectBoardContent(boardNum);
		return boardVO;
	}
	
	@Override
	public void gainBoardCount(int boardNum) throws Exception {
		// TODO Auto-generated method stub
		boardDAO.updateBoardCount(boardNum);
	}
	
	@Override
	public int addBoardContent(Map boardContentMap) throws Exception {
		// TODO Auto-generated method stub
		count = boardDAO.insertBoardContent(boardContentMap);
		return count;
	}
	
	@Override
	public int addImageFile(Map boardContentMap) throws Exception {
		// TODO Auto-generated method stub
		count = boardDAO.insertImageFile(boardContentMap);
		return count;
	}
	
	@Override
		public List<ImageVO> getImageFileList(int boardNum) throws Exception {
			// TODO Auto-generated method stub
			imageFileList = boardDAO.selectImageFileList(boardNum);
			return imageFileList;
		}	
	@Override
	public int rewriteBoardContent(Map boardContentMap) throws Exception {
		// TODO Auto-generated method stub
		int updateCount = 0;
//		System.out.println("rewriteBoardContent : "+ boardVO.getBoardTitle());
//		System.out.println("rewriteBoardContent : "+boardVO.getBoardContent());
//		System.out.println("rewriteBoardContent : "+boardVO.getBoardNum());
//		System.out.println("rewriteBoardContent : "+boardVO.getBoardID());
//		System.out.println("rewriteBoardContent : "+boardVO.getBoardCount());
		updateCount = boardDAO.updateBoardContent(boardContentMap);
		return updateCount;
	}
	@Override
	public int removeBoardContent(Map boardContentMap) throws Exception {
		// TODO Auto-generated method stub
		int deleteCount = 0;
		deleteCount = boardDAO.deleteBoardContent(boardContentMap);
		return deleteCount;
	}
	
	@Override
	public int removeBoardContentByAdmin(Map boardContentMap) throws Exception {
		// TODO Auto-generated method stub
		int deleteCount = 0;
		deleteCount = boardDAO.deleteBoardContentByAdmin(boardContentMap);
		return deleteCount;
	}
	
	@Override
	public List<CommentVO> getCommentList(int boardNum) throws Exception {
		// TODO Auto-generated method stub
		commentList = boardDAO.selectCommentByBoardNum(boardNum);
		return commentList;
	}
	
	@Override
	public int addComment(CommentVO commentVO) throws Exception {
		// TODO Auto-generated method stub
		count = boardDAO.insertComment(commentVO);
		return count;
	}
	
	@Override
	public int getCommentCountByBoardNum(int boardNum) throws Exception {
		// TODO Auto-generated method stub
		count = boardDAO.selectCommentCountByBoardNum(boardNum);
		return count;
	}
	
	@Override
	public int removeComment(int commentNum) throws Exception {
		// TODO Auto-generated method stub
		count = boardDAO.deleteComment(commentNum);
		return count;
	}
	
	@Override
	public List<CommentVO> getCountCommentGroupByBoardNum() throws Exception {
		// TODO Auto-generated method stub
		commentList = boardDAO.selectCountCommentGroupByBoardNum();
		return commentList;
	}
	@Override
	public int selectId(Map goodAndBadMap) throws Exception {
		// TODO Auto-generated method stub
		count = boardDAO.selectId(goodAndBadMap);
		return count;
	}
	
	
	 @Override
	public int selectUp(int boardNum) throws Exception {
		// TODO Auto-generated method stub
		 count = boardDAO.selectUp(boardNum);
		return count;
	}
	 @Override
	public int selectDown(int boardNum) throws Exception {
		// TODO Auto-generated method stub
		 count = boardDAO.selectDown(boardNum);
		return count;
	}
	 @Override
	public int selectCountUpById(Map goodAndBadMap) throws Exception {
		// TODO Auto-generated method stub
		 count = boardDAO.selectCountUpById(goodAndBadMap);
		return count;
	}
	 @Override
	public int selectCountDownById(Map goodAndBadMap) throws Exception {
		// TODO Auto-generated method stub
		 count = boardDAO.selectCountDownById(goodAndBadMap);
		return count;
	}
	 
	 @Override
	public List<GoodAndBadVO> selectAllContentUpAndDown() throws Exception {
		// TODO Auto-generated method stub
		 goodAndBadList = boardDAO.selectAllContentUpAndDown();
		return goodAndBadList;
	}
	 @Override
	public int insertUpAndDown(Map goodAndBadMap) throws Exception {
		// TODO Auto-generated method stub
		 count = boardDAO.insertUpAndDown(goodAndBadMap);
		return count;
	}
	 @Override
	public int updateUpDown(Map goodAndBadMap) throws Exception {
		// TODO Auto-generated method stub
		 count = boardDAO.updateUpDown(goodAndBadMap);
		return count;
	}
	 @Override
	public int removeGoodAndBad(int boardNum) throws Exception {
		// TODO Auto-generated method stub
		 count = boardDAO.deleteGoodAndBad(boardNum);
		return count;
	}
}
