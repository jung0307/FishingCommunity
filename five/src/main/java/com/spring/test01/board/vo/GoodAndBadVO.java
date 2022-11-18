package com.spring.test01.board.vo;

public class GoodAndBadVO {

	private int boardNum;
	private String id;
	private int up;
	private int down;
	
	public GoodAndBadVO() {
		// TODO Auto-generated constructor stub
	}

	public int getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getUp() {
		return up;
	}

	public void setUp(int up) {
		this.up = up;
	}

	public int getDown() {
		return down;
	}

	public void setDown(int down) {
		this.down = down;
	}

	public GoodAndBadVO(int boardNum, String id, int up, int down) {
		
		this.boardNum = boardNum;
		this.id = id;
		this.up = up;
		this.down = down;
	}
	
	
}
