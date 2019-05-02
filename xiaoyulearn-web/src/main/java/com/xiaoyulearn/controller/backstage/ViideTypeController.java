
package com.xiaoyulearn.controller.backstage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiaoyulearn.entity.VideoType;
import com.xiaoyulearn.service.VideoTypeService;

@Controller
public class ViideTypeController {
	@Autowired
	private VideoTypeService videoTypeService;

	@ResponseBody
	@RequestMapping("/getViideTypeList")
	public List<VideoType> getViideTypeList() {
		return videoTypeService.showVideoType(null);
	}

	
}
