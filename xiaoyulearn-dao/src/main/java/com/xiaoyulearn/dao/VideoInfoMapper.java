package com.xiaoyulearn.dao;

import java.util.List;

import com.xiaoyulearn.entity.VideoInfo;

public interface VideoInfoMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(VideoInfo record);

	int insertSelective(VideoInfo record);

	VideoInfo selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(VideoInfo record);

	int updateByPrimaryKey(VideoInfo record);

	List<VideoInfo> getVideoAll(VideoInfo record);
}