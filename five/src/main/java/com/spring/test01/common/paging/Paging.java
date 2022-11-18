package com.spring.test01.common.paging;

import javax.servlet.http.HttpServletRequest;

public class Paging {

	public String pagination(int pagingBlock,int pagingNum, int totalBlock, int totalNum,String searchSection
			,String searchText,HttpServletRequest req,String path,String action) {
		
		//pagingNum 페이지 블럭을 표시하는 숫자
		
		
		//pagingBlock 한 화면에 나타나는 페이지블럭 ex << 5 6 7 8 9 >> 고정 숫자
		//pagingTemp 현재 화면에 나타나는 pagingNum
		//totalBlock 전체 게시물을 pagingSize으로 나눈 수
		//totalNum 전체 게시물의 숫자 
		
		String pagingMessage = "<div>"
				+ "  <ul class='pagination'>";
		
		int pagingTemp = pagingNum; 
		
		// searchText가 공백일 때
		if(searchText.equals("")) {

			if(pagingNum != 1 ) {
				pagingMessage = pagingMessage + "<li class='page-item'>"
						+ "<a class='page-link' href='"
						+ req.getContextPath()
						+"/"+path+"/"+action+"?pagingNum=1'>&laquo;</a></li>";
				pagingMessage = pagingMessage + "<li class='page-item'>"
						+ "<a class='page-link' href='"
						+ req.getContextPath()
						+"/"+path+"/"+action+"?pagingNum="+(pagingNum - 1)+"'>&lt;</a></li>";
			}
			
			int blockNum = 1;
			
			while(blockNum <= pagingBlock && pagingTemp <= totalBlock) {
				if(pagingTemp == pagingNum) {
					pagingMessage = pagingMessage + "<li class='page-item'>"
							+ "<a class='page-link' href='"
							+ req.getContextPath()
							+ "/"+path+"/"+action+"?pagingNum="+pagingTemp+"'>"+pagingTemp+"</a></li>";	
				}else {
					pagingMessage = pagingMessage + "<li class='page-item'>"
							+ "<a class='page-link' href='"
							+ req.getContextPath()
							+ "/"+path+"/"+action+"?pagingNum="+pagingTemp+"'>"+pagingTemp+"</a></li>";	
				}
				pagingTemp++;
				blockNum++;
			}
			
			if(pagingTemp<=totalBlock) {
				pagingMessage = pagingMessage + "<li class='page-item'>"
						+ "<a class='page-link' href='"
						+ req.getContextPath()
						+ "/"+path+"/"+action+"?pagingNum="+pagingTemp+"'>&gt;</a></li>";	
				pagingMessage = pagingMessage + "<li class='page-item'>"
						+ "<a class='page-link' href='"
						+ req.getContextPath()
						+ "/"+path+"/"+action+"?pagingNum="+totalBlock+"'>&raquo;</a></li>";	
			}
//			else if(pagingTemp == totalBlock) {
//				pagingMessage = pagingMessage + "<li class='page-item'>"
//						+ "<a class='page-link' href='"
//						+ req.getContextPath()
//						+ "/"+path+"/"+action+"?pagingNum="+pagingTemp+"'>"+pagingTemp+"</a></li>";	
//			}
			System.out.println(pagingMessage);
			
		}
		// searchText가 있을 때
		else {

			if(pagingNum != 1 ) {
				pagingMessage = pagingMessage + "<li class='page-item'>"
						+ "<a class='page-link' href='"
						+ req.getContextPath()
						+"/"+path+"/"+action+"?pagingNum=1&searchSection="+searchSection+"&searchText="+searchText+"'>&laquo;</a></li>";
				pagingMessage = pagingMessage + "<li class='page-item'>"
						+ "<a class='page-link' href='"
						+ req.getContextPath()
						+"/"+path+"/"+action+"?pagingNum="+(pagingNum - 1)+"&searchSection="+searchSection+"&searchText="+searchText+"'>&lt;</a></li>";
			}
			
			int blockNum = 1;
			
			while(blockNum <= pagingBlock && pagingTemp < totalBlock) {
				if(pagingTemp == pagingNum) {
					pagingMessage = pagingMessage + "<li class='page-item'>"
							+ "<a class='page-link' href='"
							+ req.getContextPath()
							+ "/"+path+"/"+action+"?pagingNum="+pagingTemp+"&searchSection="+searchSection+"&searchText="+searchText+"'>"+pagingTemp+"</a></li>";	
				}else {
					pagingMessage = pagingMessage + "<li class='page-item'>"
							+ "<a class='page-link' href='"
							+ req.getContextPath()
							+ "/"+path+"/"+action+"?pagingNum="+pagingTemp+"&searchSection="+searchSection+"&searchText="+searchText+"'>"+pagingTemp+"</a></li>";	
				}
				pagingTemp++;
				blockNum++;
			}
			
			if(pagingTemp<=totalBlock) {
				pagingMessage = pagingMessage + "<li class='page-item'>"
						+ "<a class='page-link' href='"
						+ req.getContextPath()
						+ "/"+path+"/"+action+"?pagingNum="+pagingTemp+"&searchSection="+searchSection+"&searchText="+searchText+"'>&gt;</a></li>";	
				pagingMessage = pagingMessage + "<li class='page-item'>"
						+ "<a class='page-link' href='"
						+ req.getContextPath()
						+ "/"+path+"/"+action+"?pagingNum="+totalBlock+"&searchSection="+searchSection+"&searchText="+searchText+"'>&raquo;</a></li>";	
			}
//			else if(pagingTemp == totalBlock) {
//				pagingMessage = pagingMessage + "<li class='page-item'>"
//						+ "<a class='page-link' href='"
//						+ req.getContextPath()
//						+ "/"+path+"/"+action+"?pagingNum="+pagingTemp+"&searchSection="+searchSection+"&searchText="+searchText+"'>"+pagingTemp+"</a></li>";	
//			}
			System.out.println(pagingMessage);
		}
		
//		String pagingMessage = "<div>"
//				+ "  <ul class='pagination'>";
//		
//		int pagingTemp = pagingNum; 
//
//		if(pagingNum != 1 ) {
//			pagingMessage = pagingMessage + "<li class='page-item'>"
//					+ "<a class='page-link' href='"
//					+ req.getContextPath()
//					+"/board/getBoardList?pagingNum=1'>&laquo;</a></li>";
//		}
//		
//		int blockNum = 1;
//		
//		while(blockNum <= pagingBlock && pagingTemp < totalBlock) {
//			if(pagingTemp == pagingNum) {
//				pagingMessage = pagingMessage + "<li class='page-item'>"
//						+ "<a class='page-link' href='"
//						+ req.getContextPath()
//						+ "/board/getBoardList?pagingNum="+pagingTemp+"'>"+pagingTemp+"</a></li>";	
//			}else {
//				pagingMessage = pagingMessage + "<li class='page-item'>"
//						+ "<a class='page-link' href='"
//						+ req.getContextPath()
//						+ "/board/getBoardList?pagingNum="+pagingTemp+"'>"+pagingTemp+"</a></li>";	
//			}
//			pagingTemp++;
//			blockNum++;
//		}
//		
//		if(pagingTemp<totalBlock) {
//			pagingMessage = pagingMessage + "<li class='page-item'>"
//					+ "<a class='page-link' href='"
//					+ req.getContextPath()
//					+ "/board/getBoardList?pagingNum="+pagingTemp+"'>&raquo;</a></li>";	
//		}else if(pagingTemp == totalBlock) {
//			pagingMessage = pagingMessage + "<li class='page-item'>"
//					+ "<a class='page-link' href='"
//					+ req.getContextPath()
//					+ "/board/getBoardList?pagingNum="+pagingTemp+"'>"+pagingTemp+"</a></li>";	
//		}
//		System.out.println(pagingMessage);
		
		
	
//		for(int i=pagingTemp; i<totalBlock; i++) {
//			pagingMessage = pagingMessage + "<li class='page-item active'>"
//					+ "<a class='page-link' href='#'>"+i+"</a></li>";	
//		}
		
		
		return pagingMessage;
		
	}
}
