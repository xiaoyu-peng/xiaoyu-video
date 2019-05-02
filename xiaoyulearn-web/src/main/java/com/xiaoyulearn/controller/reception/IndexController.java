
package com.xiaoyulearn.controller.reception;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xiaoyulearn.entity.VideoInfo;
import com.xiaoyulearn.entity.VideoType;
import com.xiaoyulearn.service.VideoInfoService;
import com.xiaoyulearn.service.VideoTypeService;

/**
 * 
 * @ClassName:  IndexController   
 * @Description:TODO(前台展示数据)   
 * @author: PengHui 
 * @date:   2019年5月2日 下午5:32:30   
 *
 */
@Controller("/")
public class IndexController {
	private static final String INDEX = "index";
	private static final String INDEXVIDEODETAILS = "indexVideoDetails";
	@Autowired
	private VideoTypeService videoTypeService;
	@Autowired
	private VideoInfoService videoInfoService;

	@RequestMapping("/")
	public String index(HttpServletRequest request) {
		//查询所有类型
		List<VideoType> listShowVideoType = videoTypeService.showVideoType(null);
		request.setAttribute("listShowVideoType", listShowVideoType);
		List<VideoInfo> listVideoInfo = videoInfoService.getVideoInfos();
		request.setAttribute("listVideoInfo", listVideoInfo);
		return INDEX;
	}
	
	@RequestMapping("/indexVideoDetails")
	public String indexVideoDetails(HttpServletRequest request,int id){
		VideoInfo videoInfo = videoInfoService.getVideoInfo(id);
		request.setAttribute("videoInfo", videoInfo);
		return INDEXVIDEODETAILS;
	}
}
