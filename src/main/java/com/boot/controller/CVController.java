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

	@RequestMapping("/cv_write")
	public String write(CVDTO cv) {
		log.info("@# cv_write");
		
		service.write(cv);
		
		return "cv_write";
	}
	
	 @RequestMapping("/cv_save")
	   public String cv_save(CVDTO cv) {
	      log.info("@# cv_save");
	      
	      service.cv_save(cv);
	      
	      return "redirect:myPage";
	   }

	
	@RequestMapping("/cv_contentView")
	public String content_view(@RequestParam HashMap<String, String> param, Model model) {
		log.info("@# cv_contentView"+param);
		
		CVDTO dto = service.contentView(param);
		model.addAttribute("contentView", dto);
		
		return "cv_contentView";
	}
	
	@RequestMapping("/cv_modify")
	public String cv_modify(@RequestParam HashMap<String, String> param) {
		log.info("@# cv_modify");
		
		service.cv_modify(param);
		
		return "redirect:myPage";
	}
	@RequestMapping("/faq")
	public String faq() {
		log.info("@# faq");
		
		return "faq";
	}
}