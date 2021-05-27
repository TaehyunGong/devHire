package com.project.devhire.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class mainController {

	@Autowired
	private MainService service;

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
