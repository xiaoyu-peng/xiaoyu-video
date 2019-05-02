/**  
 * @Title:  VideoInfoController.java   
 * @Package com.xiaoyulearn.controller   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: PengHui     
 * @date:   2019年5月2日 上午10:26:57   
 * @version V1.0 
 */
package com.xiaoyulearn.controller.backstage;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xiaoyulearn.entity.VideoInfo;
import com.xiaoyulearn.entity.VideoType;
import com.xiaoyulearn.service.VideoInfoService;
import com.xiaoyulearn.service.VideoTypeService;

/**   
 * @ClassName:  VideoInfoController   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: PengHui 
 * @date:   2019年5月2日 上午10:26:57   
 *     
 */
@Controller
public class VideoInfoController {

	@Autowired
	private VideoInfoService videoInfoService;

	@Autowired
	private VideoTypeService videoTypeService;

	private static final String BASE = "backstage/";
	// 视频管理页面
	private static final String INDEX_VIDEO = BASE + "indexVideo";
	private static final String ADD_VIDEO = BASE + "addVideo";
	private static final String VIDEO_DETAILS = BASE + "videoDetails";
	
	private static Logger log = Logger.getLogger(VideoInfoController.class);


	@RequestMapping("/indexVideo")
	public String indexVideo(HttpServletRequest request, Integer pageIndex) {

		if(pageIndex == null) {
			pageIndex = 1;
		}
		Page startPage = PageHelper.startPage(pageIndex,1);

		List<VideoInfo> videoList = videoInfoService.getVideoAll(null);
		request.setAttribute("listVideo", videoList);
		request.setAttribute("pageSize", startPage.getPages());
		return INDEX_VIDEO;
	}

	@RequestMapping("/videoDetails")
	public String videoDetails(HttpServletRequest request, Integer id) {
		VideoInfo videoInfo = videoInfoService.getVideoInfo(id);
		request.setAttribute("videoInfo", videoInfo);
		return VIDEO_DETAILS;
	}

	@RequestMapping("/locaAddVideo")
	public String locaVideo(HttpServletRequest request) {
		List<VideoType> listVideoType = videoTypeService.showVideoType(null);
		request.setAttribute("listVideoType", listVideoType);
		return ADD_VIDEO;
	}

	@RequestMapping("/addVideo")
	public String addVideo(@RequestParam(value = "file", required = false) MultipartFile file, VideoInfo videoInfo,
			HttpServletRequest req, HttpServletResponse res) {
		
		try {
			// 获取当前上下文
			String path = req.getSession().getServletContext().getRealPath("/static/imgs");
			// 文件名称
			String newName = System.currentTimeMillis() + ".png";
			File targetFile = new File(path, newName);
			// 文件夹不存在,则创建文件夹
			if (!targetFile.exists()) {
				targetFile.mkdirs();
			}
			// 保存
			try {
				file.transferTo(targetFile);
			} catch (Exception e) {
				log.error(e);
			}
			videoInfo.setVideoUrl(newName);
			videoInfoService.addVideoInfo(videoInfo);
			req.setAttribute("result", "封面上传成功!");
			return "redirect:/"+INDEX_VIDEO;
		} catch (Exception e) {
			log.error(e);
			req.setAttribute("result", "上传失败!");
			return ADD_VIDEO;
		}

	}
	
	@ResponseBody
	@RequestMapping("/getVideoInfoList")
	public List<VideoInfo> getVideoInfoList() {
		return videoInfoService.getVideoInfos();
	}

	public Map<String, Object> setRuest(int code, String msg) {
		Map<String, Object> resutMap = new HashMap<String, Object>();
		resutMap.put("code", "200");
		resutMap.put("msg", "添加元素成功!");
		return resutMap;
	}

}
