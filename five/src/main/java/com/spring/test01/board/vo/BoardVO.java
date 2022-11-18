package com.spring.test01.board.vo;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component("boardVO")
public class BoardVO {

	private String boardID;
	private int boardNum;
	private int boardCount;
	private String boardDate;
	private String boardContent;
	private String fileName;
	private String boardTitle;
	private int commentCount;
	private int upCount;

	
	public BoardVO() {
		// TODO Auto-generated constructor stub
	}
	
	public String getBoardID() {
		return boardID;
	}
	public void setBoardID(String boardID) {
		this.boardID = boardID;
	}
	public int getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}
	public int getBoardCount() {
		return boardCount;
	}
	public void setBoardCount(int boardCount) {
		this.boardCount = boardCount;
	}
	public String getBoardDate() {
		return boardDate;
	}
	public void setBoardDate(String boardDate) {
		this.boardDate = boardDate;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	
	

	public int getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}
	

	


	public int getUpCount() {
		return upCount;
	}

	public void setUpCount(int upCount) {
		this.upCount = upCount;
	}

	public BoardVO(String boardID, int boardNum, int boardCount, String boardDate, String boardContent, String fileName,
			String boardTitle, int commentCount, int upCount) {

		this.boardID = boardID;
		this.boardNum = boardNum;
		this.boardCount = boardCount;
		this.boardDate = boardDate;
		this.boardContent = boardContent;
		this.fileName = fileName;
		this.boardTitle = boardTitle;
		this.commentCount = commentCount;
		this.upCount = upCount;
	}


	
}
