package com.spring.test01.fishInfo.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.test01.fishInfo.vo.FishInfoVO;

public interface FishInfoController {

	public ModelAndView getFishInfoMain(@RequestParam Map<String, Object> fishMap ,HttpServletRequest req, HttpServletRequest resp) throws Exception;
	public ModelAndView writeFishInfo(@RequestParam String boardID ,HttpServletRequest req, HttpServletRequest resp) throws Exception;
	public ModelAndView uploadFishInfo(@ModelAttribute FishInfoVO FishInfoVO ,HttpServletRequest req, HttpServletRequest resp) throws Exception;
	public ModelAndView removeFishInfo(@RequestParam int fishNum ,HttpServletRequest req, HttpServletRequest resp) throws Exception;
	public ModelAndView updateFishInfoForm(@RequestParam int fishNum ,HttpServletRequest req, HttpServletRequest resp) throws Exception;
	public ResponseEntity updateFishInfo(@ModelAttribute FishInfoVO FishInfoVO ,HttpServletRequest req, HttpServletRequest resp) throws Exception;
	
}
