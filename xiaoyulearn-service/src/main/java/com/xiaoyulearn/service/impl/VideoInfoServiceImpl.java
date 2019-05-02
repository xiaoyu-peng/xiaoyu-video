/**  
 * @Title:  SelectVideoInfoImpl.java   
 * @Package com.xiaoyulearn.service.impl   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: PengHui     
 * @date:   2019年5月2日 上午10:21:29   
 * @version V1.0 
 */
package com.xiaoyulearn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiaoyulearn.dao.VideoInfoMapper;
import com.xiaoyulearn.entity.VideoInfo;
import com.xiaoyulearn.service.VideoInfoService;

/**   
 * @ClassName:  SelectVideoInfoImpl   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: PengHui 
 * @date:   2019年5月2日 上午10:21:29   
 *     
 */
@Service
public class VideoInfoServiceImpl implements VideoInfoService {

	@Autowired
	private VideoInfoMapper videoInfoMapper;
	
	/**
	 * (非 Javadoc)
	 * <p>Title: getVideoAll</p>   
	 * <p>Description: </p>   
	 * @param video
	 * @return   
	 * @see com.xiaoyulearn.service.VideoInfoService#getVideoAll(com.xiaoyulearn.entity.VideoInfo)   
	 */
	@Override
	public List<VideoInfo> getVideoAll(VideoInfo video) {
		return videoInfoMapper.getVideoAll(null);
	}

	/**
	 * (非 Javadoc)
	 * <p>Title: getVideoInfo</p>   
	 * <p>Description: </p>   
	 * @param id
	 * @return   
	 * @see com.xiaoyulearn.service.VideoInfoService#getVideoInfo(java.lang.Integer)   
	 */
	@Override
	public VideoInfo getVideoInfo(Integer id) {
		return videoInfoMapper.selectByPrimaryKey(id);
	}

	/**
	 * (非 Javadoc)
	 * <p>Title: addVideoInfo</p>   
	 * <p>Description: </p>   
	 * @param video
	 * @return   
	 * @see com.xiaoyulearn.service.VideoInfoService#addVideoInfo(com.xiaoyulearn.entity.VideoInfo)   
	 */
	@Override
	public int addVideoInfo(VideoInfo record) {
		return videoInfoMapper.insert(record);
	}

	/**
	 * (非 Javadoc)
	 * <p>Title: getVideoInfos</p>   
	 * <p>Description: </p>   
	 * @return   
	 * @see com.xiaoyulearn.service.VideoInfoService#getVideoInfos()   
	 */
	@Override
	public List<VideoInfo> getVideoInfos() {
		return videoInfoMapper.getVideoAll(null);
	}

}
