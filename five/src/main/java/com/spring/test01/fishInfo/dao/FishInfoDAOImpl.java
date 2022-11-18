package com.spring.test01.fishInfo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.test01.fishInfo.vo.FishInfoVO;

@Repository("fishInfoDAO")
public class FishInfoDAOImpl implements FishInfoDAO{

	@Autowired
	SqlSession session;
	
	int count = 0;
	List<FishInfoVO> fishInfoList;
	
	@Override
	public int insertFishInfo(FishInfoVO fishInfoVO) throws Exception {
		// TODO Auto-generated method stub
		count = session.insert("mapper.fishInfo.insertFishInfo" , fishInfoVO);
		return count;
	}
	@Override
	public List<FishInfoVO> selectFishInfoList(Map pagingMap) throws Exception {
		// TODO Auto-generated method stub
		fishInfoList = session.selectList("mapper.fishInfo.selectFishInfoList" , pagingMap);
		return fishInfoList;
	}
	@Override
	public int deleteFishInfo(int fishNum) throws Exception {
		// TODO Auto-generated method stub
		count = session.delete("mapper.fishInfo.deleteFishInfo", fishNum);
		return count;
	}
	
	@Override
	public int selectCountAllFishInfoListBySearchText(Map pagingMap) throws Exception {
		// TODO Auto-generated method stub
		count = session.selectOne("mapper.fishInfo.selectCountAllFishInfoListBySearchText", pagingMap);
		return count;
	}
	
	@Override
	public int updateFishInfo(FishInfoVO fishInfoVO) throws Exception {
		// TODO Auto-generated method stub
		count = session.update("mapper.fishInfo.updateFishInfo", fishInfoVO);
		return count;
	}
}
