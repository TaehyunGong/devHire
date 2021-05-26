package com.project.devhire.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class mainController {

	@RequestMapping("/")
	public ModelAndView init() {
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("test");
		
		return mav;
	}
	
	@RequestMapping("/layout")
	public ModelAndView layout() {
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("layout/default-layout");
		
		return mav;
	}
}
