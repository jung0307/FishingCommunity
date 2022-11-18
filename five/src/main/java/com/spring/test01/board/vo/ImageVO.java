package com.spring.test01.board.vo;

import java.util.Date;

public class ImageVO {

	private int imageFileNo;
	private String imageFileName;
	private Date regDate;
	private int contentNum;
	
	public ImageVO() {
		// TODO Auto-generated constructor stub
	}
	
	public int getImageFileNo() {
		return imageFileNo;
	}
	public void setImageFileNo(int imageFileNo) {
		this.imageFileNo = imageFileNo;
	}
	public String getImageFileName() {
		return imageFileName;
	}
	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public int getContentNum() {
		return contentNum;
	}
	public void setContentNum(int contentNum) {
		this.contentNum = contentNum;
	}
	public ImageVO(int imageFileNo, String imageFileName, Date regDate, int contentNum) {
		this.imageFileNo = imageFileNo;
		this.imageFileName = imageFileName;
		this.regDate = regDate;
		this.contentNum = contentNum;
	}
	
	
}
