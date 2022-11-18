package com.spring.test01.fishInfo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spring.test01.fishInfo.dao.FishInfoDAO;
import com.spring.test01.fishInfo.vo.FishInfoVO;

@Service("fishInfoService")
@Transactional(propagation = Propagation.REQUIRED)
public class FishInfoServiceImpl implements FishInfoService {

	@Autowired
	FishInfoDAO fishInfoDAO;
	
	int count = 0;
	List<FishInfoVO> fishInfoList;
	
	@Override
	public int addFishInfo(FishInfoVO fishInfoVO) throws Exception {
		// TODO Auto-generated method stub
		count = fishInfoDAO.insertFishInfo(fishInfoVO);
		return count;
	}
	@Override
	public List<FishInfoVO> getFishInfoList(Map pagingMap) throws Exception {
		// TODO Auto-generated method stub
		fishInfoList = fishInfoDAO.selectFishInfoList(pagingMap);
		return fishInfoList;
	}
	@Override
	public int removeFishInfo(int fishNum) throws Exception {
		// TODO Auto-generated method stub
		count = fishInfoDAO.deleteFishInfo(fishNum);
		return count;
	}
	@Override
	public int getCountAllFishInfoListBySearchText(Map pagingMap) throws Exception {
		// TODO Auto-generated method stub
		count = fishInfoDAO.selectCountAllFishInfoListBySearchText(pagingMap);
		return count;
		
	}
	@Override
	public int updateFishInfo(FishInfoVO fishInfoVO) throws Exception {
		// TODO Auto-generated method stub
		count = fishInfoDAO.updateFishInfo(fishInfoVO);
		return count;
	}
}
