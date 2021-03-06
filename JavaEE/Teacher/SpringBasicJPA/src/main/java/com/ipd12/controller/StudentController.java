package com.ipd12.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ipd12.service.StudentManager;

@Controller
public class StudentController {
	@RequestMapping("/hello")
	public ModelAndView showMessage() {
		String message = "Response from Hello";
		
		ModelAndView mv = new ModelAndView("firstPage");
		mv.addObject("message", message);
		return mv;
	}
	
	@RequestMapping("/testParam")
	public ModelAndView showMessage5(@RequestParam("uname") String uname) {
		String message = "Response from testParam "+uname;
 
		ModelAndView mv = new ModelAndView("result");
		mv.addObject("message", message);
		return mv;
	}
	
	@Autowired
	StudentManager sm;
	
	@RequestMapping(value="/getStudent", method={RequestMethod.POST})
	public ModelAndView getStudent() {
		
		String res = sm.callStudentManager();
		System.out.println("Testing AutoWiring for Student "+res);
		
		ModelAndView mv = new ModelAndView("result2");
		return mv;
	}
}
