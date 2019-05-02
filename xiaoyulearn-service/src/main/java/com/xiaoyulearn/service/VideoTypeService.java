/**  
 * @Title:  VideaTypeService.java   
 * @Package com.xiaoyulearn.service   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: PengHui     
 * @date:   2019年5月1日 下午9:20:24   
 * @version V1.0 
 */
package com.xiaoyulearn.service;

import java.util.List;

import com.xiaoyulearn.entity.VideoType;

/**   
 * @ClassName:  VideaTypeService   
 * @Description:TODO(视频类型查询接口)   
 * @author: PengHui 
 * @date:   2019年5月1日 下午9:20:24   
 *     
 */
public interface VideoTypeService {

	//查询所有视频类型
	public List<VideoType> showVideoType(VideoType record);
}
