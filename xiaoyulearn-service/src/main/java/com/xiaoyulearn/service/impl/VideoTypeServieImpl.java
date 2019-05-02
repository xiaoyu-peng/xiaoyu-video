/**  
 * @Title:  VideoTypeServieImpl.java   
 * @Package com.xiaoyulearn.service.impl   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: PengHui     
 * @date:   2019年5月1日 下午9:22:14   
 * @version V1.0 
 */
package com.xiaoyulearn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiaoyulearn.dao.VideoTypeMapper;
import com.xiaoyulearn.entity.VideoType;
import com.xiaoyulearn.service.VideoTypeService;

/**   
 * @ClassName:  VideoTypeServieImpl   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: PengHui 
 * @date:   2019年5月1日 下午9:22:14   
 *     
 */
@Service
public class VideoTypeServieImpl implements VideoTypeService {

	@Autowired
	private VideoTypeMapper videoTypeMapper;

	public List<VideoType> showVideoType(VideoType record) {
		return videoTypeMapper.selectList(record);
	}

}
