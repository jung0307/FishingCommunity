package com.spring.test01.fishInfo.service;

import java.util.List;
import java.util.Map;

import com.spring.test01.fishInfo.vo.FishInfoVO;

public interface FishInfoService {

	public int addFishInfo(FishInfoVO fishInfoVO) throws Exception;
	public List<FishInfoVO> getFishInfoList(Map pagingMap) throws Exception;
	public int removeFishInfo(int fishNum) throws Exception;
	public int getCountAllFishInfoListBySearchText(Map pagingMap) throws Exception;
	public int updateFishInfo(FishInfoVO fishInfoVO) throws Exception;
}
