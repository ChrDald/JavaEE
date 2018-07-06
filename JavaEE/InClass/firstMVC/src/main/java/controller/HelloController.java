package controller;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import service.EmployeeManager;


@Controller
public class HelloController {
	
	
	@RequestMapping("/name")
	public ModelAndView showName() {
		
		ModelAndView mv = new ModelAndView("result");
		mv.addObject("message", "hello world");
		return mv;
	
	}
	
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
	
	
	/*
	@Autowired
	StudentManager sm;
	
	@RequestMapping("/getStudent")
	public ModelAndView getStudent() {
		
		
		String res = sm.callStudentManager();
		
		ModelAndView mv = new ModelAndView("result2");
		mv.addObject("message", res);
		mv.addObject("message", res);
		return mv;
	}
	*/
}

