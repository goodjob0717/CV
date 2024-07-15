package com.boot.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.boot.dto.CVDTO;
import com.boot.service.CVService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class CVController {
	@Autowired
    private CVService service;

	@RequestMapping("/write")
	public String write(CVDTO cv) {
		log.info("@# write");
		
		service.write(cv);
		
		return "write";
	}
	
	@RequestMapping("/contentView")
	public String content_view(@RequestParam HashMap<String, String> param, Model model) {
		log.info("@# contentView"+param);
		
		CVDTO dto = service.contentView(param);
		model.addAttribute("contentView", dto);
		
		return "contentView";
	}
	
	@RequestMapping("/modify")
	public String modify(@RequestParam HashMap<String, String> param) {
		log.info("@# modify");
		
		service.modify(param);
		
		return "list";
	}
}