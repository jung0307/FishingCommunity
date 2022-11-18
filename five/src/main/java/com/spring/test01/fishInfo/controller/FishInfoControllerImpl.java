package com.spring.test01.fishInfo.controller;

import java.net.http.HttpHeaders;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.spring.test01.common.paging.Paging;
import com.spring.test01.fishInfo.service.FishInfoService;
import com.spring.test01.fishInfo.vo.FishInfoVO;

@RestController("fishInfoController")
public class FishInfoControllerImpl implements FishInfoController{
	
	@Autowired
	FishInfoService fishInfoService;
	
	int count = 0;
	List<FishInfoVO> fishInfoList;
	@Override
	@RequestMapping(value = "/fishInfo/getFishInfoMain.do" , method = RequestMethod.GET)
	public ModelAndView getFishInfoMain(@RequestParam Map<String, Object> fishMap, HttpServletRequest req, HttpServletRequest resp) throws Exception {
		// TODO Auto-generated method stub
		Map<String , Object> pagingMap = new HashMap<String , Object>();
		
		 // 댓글 개수 보여주는 list
		
		int countfishInfoList = 0; // 총 게시물 수
		int count = 0;
		int pagingNumInt = 1; // 기본 pagingNum 값
		Paging paging = new Paging();
		
		// 고정값
		int pagingBlock = 10; // 한 화면에 보이는 페이지 블럭 수
		int pagingSize = 10; // 한 화면에 보이는 게시물 수
		
			
		String searchSection = (String) fishMap.get("searchSection");
		String searchText = (String) fishMap.get("searchText");
		String pagingNum = (String) fishMap.get("pagingNum");
		
		System.out.println("searchSection1 : " + searchSection);
		System.out.println("searchText1 : " + searchText);
		
		// searchSection에 따라 구분해서 map에 넣어줌
			if(searchSection!=null) {
				if(searchSection.equals("fishNum")) {
					System.out.println("searchSection : " + searchSection);
					pagingMap.put("fishNum", searchSection);
				}else if(searchSection.equals("fishName")) {
					System.out.println("searchSection : " + searchSection);
					pagingMap.put("fishName", searchSection);
				}
			}
		// 	searchSection == null
			else {
				System.out.println("searchSection == null ");
				searchSection = "";
				searchText = "";
				pagingMap.put("fishNum", searchSection);
				pagingMap.put("fishName", searchSection);
			}
			
			System.out.println("searchSection : "+searchSection);
		

		// 검색어가 있을 경우
		if(searchText!=null && !searchText.equals("")) {
			System.out.println("searchSection : "+searchSection);
			System.out.println("searchText : "+searchText);
			pagingMap.put("searchText", searchText.trim());
//			pagingMap.put("searchSection", searchSection.trim());
			countfishInfoList = fishInfoService.getCountAllFishInfoListBySearchText(pagingMap);
			System.out.println("countfishInfoList : " + countfishInfoList);
		}
		// 검색어가 없을 경우
		else {
			System.out.println("searchText 없음");
			searchText = "";
			countfishInfoList = fishInfoService.getCountAllFishInfoListBySearchText(pagingMap); // max(boardNum)
			System.out.println("countBoardList : " + countfishInfoList);
		}
		
		
		int totalBlock = (int) Math.ceil(((double)countfishInfoList / pagingSize));
		System.out.println("(countBoardList / pagingSize) : "+((double)countfishInfoList / pagingSize));
		if(pagingNum!=null) {
			 pagingNumInt = Integer.parseInt(pagingNum);
		}
		System.out.println("pagingMap : "+pagingNumInt);
		int startNum = (pagingSize * (pagingNumInt - 1)) + 1; // db에서 가져올 때 사용하는 변수
		int endNum = (pagingSize * pagingNumInt); // 마찬가지
		
		pagingMap.put("startNum", startNum);
		pagingMap.put("endNum", endNum);
		
		
		System.out.println("pagingBlock :  "+pagingBlock);
		System.out.println("pagingNumInt :  "+pagingNumInt);
		System.out.println("pagingSize :  "+pagingSize);
		System.out.println("totalBlock :  "+totalBlock);
		System.out.println("countfishInfoList :  "+countfishInfoList);
		System.out.println("startNum :  "+startNum);
		System.out.println("endNum :  "+endNum);
		

		String path = "fishInfo";
		String action = "getFishInfoMain.do";
		
//		int pagingBlock,int pagingNum, int totalBlock, int totalNum
		String pagingMessage = paging.pagination(pagingBlock, pagingNumInt, totalBlock, countfishInfoList,searchSection,searchText,req,path,action);
//		String pagingMessage = paging.pagination(5, 1, 30, 533, req);
		ModelAndView mav = new ModelAndView();

		mav.addObject("startNum", startNum);
		mav.addObject("endNum", endNum);
		mav.addObject("pagingNum", pagingNum);
		mav.addObject("pagingMessage", pagingMessage);
		
		fishInfoList = fishInfoService.getFishInfoList(pagingMap);
		mav.addObject("fishInfoList", fishInfoList);
		mav.setViewName("fishInfoMain");
		
		return mav;
	}
	
	@Override
	@RequestMapping(value = "/fishInfo/writeFishInfo.do" , method = RequestMethod.GET)
	public ModelAndView writeFishInfo(@RequestParam String boardID, HttpServletRequest req, HttpServletRequest resp)
			throws Exception {
		// TODO Auto-generated method stub
		ModelAndView mav = new ModelAndView();
		mav.addObject("boardID", boardID);
		mav.setViewName("fishInfoForm");
		return mav;
	}
	
	@Override
	@RequestMapping(value = "/fishInfo/uploadFishInfo.do" , method = RequestMethod.POST)
	public ModelAndView uploadFishInfo(@ModelAttribute FishInfoVO fishInfoVO, HttpServletRequest req, HttpServletRequest resp)
			throws Exception {
		// TODO Auto-generated method stub
		
		ModelAndView mav = new ModelAndView();
		
//		System.out.println("fishImage : " + fishInfoVO.getFishImage());
//		System.out.println("fishName : " + fishInfoVO.getFishName());
//		System.out.println("fishExplanation : " + fishInfoVO.getFishExplanation());
//		System.out.println("fishLocation : " + fishInfoVO.getFishLocation());
//		System.out.println("fishTime : " + fishInfoVO.getFishTime());
//		System.out.println("fishWeather : " + fishInfoVO.getFishWeather());
		
		count = fishInfoService.addFishInfo(fishInfoVO);
		if(count != 0) {
			System.out.println("성공");
		}else {
			System.out.println("실패");
		}
//		fishInfoList = fishInfoService.getFishInfoList();
//		mav.addObject("fishInfoList", fishInfoList);
		mav.setViewName("redirect:/fishInfo/getFishInfoMain.do");
		return mav;
		
	}
	
	@Override
	@RequestMapping(value = "/fishInfo/removeFishInfo.do" , method = RequestMethod.GET)
	public ModelAndView removeFishInfo(@RequestParam int fishNum, HttpServletRequest req, HttpServletRequest resp) throws Exception {
		// TODO Auto-generated method stub
		ModelAndView mav = new ModelAndView();
		
		count = fishInfoService.removeFishInfo(fishNum);
		if(count != 0) {
			System.out.println("성공");
		}else {
			System.out.println("실패");
		}
//		fishInfoList = fishInfoService.getFishInfoList();
//		mav.addObject("fishInfoList", fishInfoList);
		mav.setViewName("redirect:/fishInfo/getFishInfoMain.do");
		return mav;
	}
	
	@Override
	@RequestMapping(value = "/fishInfo/updateFishInfoForm.do" , method = RequestMethod.GET)
	public ModelAndView updateFishInfoForm(int fishNum, HttpServletRequest req, HttpServletRequest resp)
			throws Exception {
		// TODO Auto-generated method stub
		ModelAndView mav = new ModelAndView("updateFishInfoForm");
		mav.addObject("fishNum", fishNum);
		return mav;
	}
	
	@Override
	@RequestMapping(value = "/fishInfo/updateFishInfo.do" , method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity updateFishInfo(@ModelAttribute FishInfoVO fishInfoVO, HttpServletRequest req, HttpServletRequest resp)
			throws Exception {
		// TODO Auto-generated method stub
		org.springframework.http.HttpHeaders responseHeaders = new org.springframework.http.HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		
		System.out.println("fishImage : " + fishInfoVO.getFishImage());
		System.out.println("fishName : " + fishInfoVO.getFishName());
		System.out.println("fishExplanation : " + fishInfoVO.getFishExplanation());
		System.out.println("fishLocation : " + fishInfoVO.getFishLocation());
		System.out.println("fishTime : " + fishInfoVO.getFishTime());
		System.out.println("fishWeather : " + fishInfoVO.getFishWeather());
		System.out.println("fishNum : " + fishInfoVO.getFishNum());
		
		
		count = fishInfoService.updateFishInfo(fishInfoVO);
		String message = "<script> ";
		if(count != 0) {
			System.out.println("업데이트 성공!");
			message = message + "alert('수정 성공!'); ";
		}else {
			System.out.println("업데이트 실패!");
			message = message + "alert('수정 실패!'); ";
		}
		message = message + "location.href='"+req.getContextPath()+"/fishInfo/getFishInfoMain.do'; ";
		message = message + "</script>";
		
		return new ResponseEntity(message,responseHeaders,HttpStatus.OK);
	}
	
}
