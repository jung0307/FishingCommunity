package com.spring.test01.board.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.test01.board.vo.BoardVO;
import com.spring.test01.board.vo.CommentVO;
import com.spring.test01.board.vo.GoodAndBadVO;
import com.spring.test01.board.vo.ImageVO;

@Repository("boardDAO")
public class BoardDAOImpl implements BoardDAO{

	@Autowired
	SqlSession session;

	BoardVO boardVO = new BoardVO();
	CommentVO commentVO = new CommentVO();
	
	List<BoardVO> boardList;
	List<ImageVO> imageFileList;
	List<CommentVO> commentList;
	List<GoodAndBadVO> goodAndBadList;
	int count = 0;
	
//	@Override
//	public List<BoardVO> selectBoardList() throws Exception {
//		// TODO Auto-generated method stub
//		boardList = session.selectList("mapper.board.selectBoardList");
//		return boardList;
//	}
	@Override
	public List<BoardVO> selectBoardList(Map pagingMap) throws Exception {
		// TODO Auto-generated method stub
		boardList = session.selectList("mapper.board.selectBoardList",pagingMap);
		return boardList;
	}
	@Override
	public List<BoardVO> selectMainBoardList() throws Exception {
		// TODO Auto-generated method stub
		boardList = session.selectList("mapper.board.selectMainBoardList");
		return boardList;
	}
	@Override
	public int selectCountBoardList() throws Exception {
		// TODO Auto-generated method stub
		try {
			count = session.selectOne("mapper.board.selectCountBoardList");
		} catch (Exception e) {
			// TODO: handle exception
			count = 0;
		}
		
		return count;
	}
	
	@Override
	public int selectCountAllBoardList() throws Exception {
		// TODO Auto-generated method stub
		count = session.selectOne("mapper.board.selectCountAllBoardList");
		return count;
	}
	
	@Override
	public int selectCountAllBoardListBySearchText(Map pagingMap) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("=====DAO========" + pagingMap.get("searchSection")+"=====DAO========");
		System.out.println("=====DAO========" + pagingMap.get("searchText")+"=====DAO========");
		count = session.selectOne("mapper.board.selectCountAllBoardListBySearchText", pagingMap);
		System.out.println("=====DAO===count===="+count+"=====DAO========");
		return count;
	}
	
	@Override
	public BoardVO selectBoardContent(int boardNum) throws Exception {
		// TODO Auto-generated method stub
		boardVO = session.selectOne("mapper.board.selectBoardContent", boardNum);
		return boardVO;
	}
	
	@Override
	public void updateBoardCount(int boardNum) throws Exception {
		// TODO Auto-generated method stub
		session.update("mapper.board.updateBoardCount", boardNum);
	}
	
	@Override
	public int insertBoardContent(Map boardContentMap) throws Exception {
		// TODO Auto-generated method stub
		count = session.insert("mapper.board.insertBoardContent", boardContentMap);
		return count;
	}
	
	@Override
	public int insertImageFile(Map boardContentMap) throws Exception {
		// TODO Auto-generated method stub
		count = session.insert("mapper.board.insertImageFile", boardContentMap);
		return count;
	}
	
	@Override
	public List<ImageVO> selectImageFileList(int boardNum) throws Exception {
		// TODO Auto-generated method stub
		int contentNum = boardNum;
		imageFileList = session.selectList("mapper.board.selectImageFileList", contentNum);
		return imageFileList;
	}
	
	@Override
	public int updateBoardContent(Map boardContentMap) throws Exception {
		// TODO Auto-generated method stub
		int updateCount = 0;
		updateCount = session.update("mapper.board.updateBoardContent", boardContentMap);
		return updateCount;
	}
	
	@Override
	public int deleteBoardContent(Map boardContentMap) throws Exception {
		// TODO Auto-generated method stub
		int deleteCount = 0;
		deleteCount = session.delete("mapper.board.deleteBoardContent", boardContentMap);
		return deleteCount;
	}
	
	@Override
	public int deleteBoardContentByAdmin(Map boardContentMap) throws Exception {
		// TODO Auto-generated method stub
		int deleteCount = 0;
		System.out.println("boardNum : " + boardContentMap.get("boardNum"));
		deleteCount = session.delete("mapper.board.deleteBoardContentByAdmin", boardContentMap);
		return deleteCount;
	}
	
	@Override
	public List<CommentVO> selectCommentByBoardNum(int boardNum) throws Exception {
		// TODO Auto-generated method stub
		commentList = session.selectList("mapper.comment.selectCommentByBoardNum", boardNum);
		return commentList;
	}
	
	@Override
	public int selectCommentNum() throws Exception {
		// TODO Auto-generated method stub
		int commentNum = 0;
		
		try {
			commentNum = session.selectOne("mapper.comment.selectCommentNum");
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
			commentHir = session.selectOne("mapper.comment.selectCommentHir", commentGroup);
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
			count = session.insert("mapper.comment.insertComment2", commentVO);
		}else if(commentVO.getCommentHir() == 0) {
			count = session.insert("mapper.comment.insertComment", commentVO);
		}
		return count;
	}
	
	@Override
	public int selectCommentCountByBoardNum(int boardNum) throws Exception {
		// TODO Auto-generated method stub
		count = session.selectOne("mapper.comment.selectCommentCountByBoardNum", boardNum);
		return count;
	}
	
	 @Override
	public int deleteComment(int commentNum) throws Exception {
		// TODO Auto-generated method stub
		 System.out.println("dc commentNum : "+commentNum);
		 count = session.delete("mapper.comment.deleteComment", commentNum);
		return count;
	}
	 
	 @Override
	public List<CommentVO> selectCountCommentGroupByBoardNum() throws Exception {
		// TODO Auto-generated method stub
		 commentList = session.selectList("mapper.comment.selectCountCommentGroupByBoardNum");
		return commentList;
	}
	@Override
	public int selectId(Map goodAndBadMap) throws Exception {
		// TODO Auto-generated method stub
		count = session.selectOne("mapper.goodAndBad.selectId",goodAndBadMap);
		return count;
	}
	 
	 @Override
	public int selectUp(int boardNum) throws Exception {
		// TODO Auto-generated method stub
		 try {
			 count = session.selectOne("mapper.goodAndBad.selectUp", boardNum);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("selectUp 처음");
			count = 0;
		}
		 
		return count;
	}
	 @Override
	public int selectDown(int boardNum) throws Exception {
		// TODO Auto-generated method stub
		 try {
			 count = session.selectOne("mapper.goodAndBad.selectDown", boardNum);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("selectDown 처음");
			count = 0;
		}
		return count;
	}
	 @Override
	public int selectCountUpById(Map goodAndBadMap) throws Exception {
		// TODO Auto-generated method stub
		 try {
			 count = session.selectOne("mapper.goodAndBad.selectCountUpById", goodAndBadMap);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("selectCountUpById 처음");
			count = 0;
		}
		return count;
	}
	 @Override
	public int selectCountDownById(Map goodAndBadMap) throws Exception {
		// TODO Auto-generated method stub
		 try {
			 count = session.selectOne("mapper.goodAndBad.selectCountDownById", goodAndBadMap);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("selectCountDownById 처음");
			count = 0;
		}

		return count;
	}
	 
	@Override
	public List<GoodAndBadVO> selectAllContentUpAndDown() throws Exception {
		// TODO Auto-generated method stub
		goodAndBadList = session.selectList("mapper.goodAndBad.selectAllContentUpAndDown");
		return goodAndBadList;
	}
	 
	 @Override
	public int insertUpAndDown(Map goodAndBadMap) throws Exception {
		// TODO Auto-generated method stub
		 System.out.println("id : " + goodAndBadMap.get("id"));
		 System.out.println("boardNum : " + goodAndBadMap.get("boardNum"));
		 count = session.insert("mapper.goodAndBad.insertUpAndDown", goodAndBadMap);
		 System.out.println("insertUpAndDown 결과 : " + count);
		return count;
	}

	 @Override
	public int updateUpDown(Map goodAndBadMap) throws Exception {
		// TODO Auto-generated method stub
		 System.out.println("id : -" + goodAndBadMap.get("id")+"-");
		 System.out.println("boardNum : -" + goodAndBadMap.get("boardNum")+"-");
		 System.out.println("up : -" + goodAndBadMap.get("up")+"-");
		 System.out.println("down : -" + goodAndBadMap.get("down")+"-");
		 count = session.update("mapper.goodAndBad.updateUpDown", goodAndBadMap);
		 System.out.println("updateUpDown 실행 : " + count);
		return count;
	}
	 
	 @Override
	public int deleteGoodAndBad(int boardNum) throws Exception {
		// TODO Auto-generated method stub
		 count = session.delete("mapper.goodAndBad.deleteGoodAndBad", boardNum);
		return count;
	}
	
}
