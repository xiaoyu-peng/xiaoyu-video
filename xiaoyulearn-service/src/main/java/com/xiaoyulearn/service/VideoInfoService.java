/**  
 * @Title:  VideoInfoService.java   
 * @Package com.xiaoyulearn.service   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: PengHui     
 * @date:   2019年5月2日 上午10:20:02   
 * @version V1.0 
 */
package com.xiaoyulearn.service;



import java.util.List;

import com.xiaoyulearn.entity.VideoInfo;

/**   
 * @ClassName:  VideoInfoService   
 * @Description:TODO(视频类型查询接口)  
 * @author: PengHui 
 * @date:   2019年5月2日 上午10:20:02   
 *     
 */
public interface VideoInfoService {

	public List<VideoInfo> getVideoInfos();
	
	public List<VideoInfo> getVideoAll(VideoInfo video);
	
	public VideoInfo getVideoInfo(Integer id);
	
	public int addVideoInfo(VideoInfo video);
}
