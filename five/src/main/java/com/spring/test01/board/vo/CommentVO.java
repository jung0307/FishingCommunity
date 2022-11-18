package com.spring.test01.board.vo;

public class CommentVO {

	private String commentID;
	private String commentContent;
	private String commentDate;
	private int commentGroup;
	private int commentHir;
	private int commentNum;
	private int boardNum;
	private int commentCount;
	private String commentPwd;
	private String role;
	
	public CommentVO() {
		// TODO Auto-generated constructor stub
	}
	
	public String getCommentID() {
		return commentID;
	}
	public void setCommentID(String commentID) {
		this.commentID = commentID;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public String getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}
	public int getCommentGroup() {
		return commentGroup;
	}
	public void setCommentGroup(int commentGroup) {
		this.commentGroup = commentGroup;
	}
	public int getCommentHir() {
		return commentHir;
	}
	public void setCommentHir(int commentHir) {
		this.commentHir = commentHir;
	}
	public int getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}
	public int getCommentNum() {
		return commentNum;
	}

	public void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
	}
	
	

	public int getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}
	
	

	public String getCommentPwd() {
		return commentPwd;
	}

	public void setCommentPwd(String commentPwd) {
		this.commentPwd = commentPwd;
	}
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public CommentVO(String commentID, String commentContent, String commentDate, int commentGroup, int commentHir,
			int commentNum, int boardNum, int commentCount, String commentPwd, String role) {
	
		this.commentID = commentID;
		this.commentContent = commentContent;
		this.commentDate = commentDate;
		this.commentGroup = commentGroup;
		this.commentHir = commentHir;
		this.commentNum = commentNum;
		this.boardNum = boardNum;
		this.commentCount = commentCount;
		this.commentPwd = commentPwd;
		this.role = role;
	}






	
	
}
