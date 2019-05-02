/**  
 * @Title:  TestController.java   
 * @Package com.xiaoyulearn.controller   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: PengHui     
 * @date:   2019年5月1日 下午3:20:07   
 * @version V1.0 
 */
package com.xiaoyulearn.controller.backstage;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiaoyulearn.entity.VideoInfo;
import com.xiaoyulearn.entity.VideoType;
import com.xiaoyulearn.service.VideoInfoService;
import com.xiaoyulearn.service.VideoTypeService;

/**   
 * @ClassName:  TestController   
 * @Description:测试TestController
 * @author: PengHui 
 * @date:   2019年5月1日 下午3:20:07   
 *     
 */

@Controller
public class TestController {
	
	@Autowired
	private VideoTypeService videoTypeService;
	
	@Autowired
	private VideoInfoService videoInfoService;

	private static final String TEST = "test";
	
	private static Logger log = Logger.getLogger(TestController.class);
	
	@RequestMapping("/hello")
	public String hello() {
		System.out.println("Hello SSM");
		return TEST;
	}
	
	@ResponseBody
	@RequestMapping("/getVideoType")
	public List<VideoType> getVideoType() {
		log.info("###getViideType() start()###");
		List<VideoType> listVideoType = videoTypeService.showVideoType(null);
		log.info("###getViideType() end()###");
		return listVideoType;
	}
	
	
	@ResponseBody
	@RequestMapping("/getVideoInfo")
	public List<VideoInfo> getVideoInfo() {
		log.info("###getVideoInfo() start()###");
		List<VideoInfo> videoAll = videoInfoService.getVideoAll(null);
		log.info("###getVideoInfo() end()###");
		return videoAll;
	}
}
