package com.spring.test01.fishInfo.dao;

import java.util.List;
import java.util.Map;

import com.spring.test01.fishInfo.vo.FishInfoVO;

public interface FishInfoDAO {

	public int insertFishInfo(FishInfoVO fishInfoVO) throws Exception;
	public List<FishInfoVO> selectFishInfoList(Map pagingMap) throws Exception;
	public int deleteFishInfo(int fishNum) throws Exception;
	public int selectCountAllFishInfoListBySearchText(Map pagingMap) throws Exception;
	public int updateFishInfo(FishInfoVO fishInfoVO) throws Exception;
}
