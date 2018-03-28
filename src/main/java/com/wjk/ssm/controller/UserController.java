package com.wjk.ssm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wjk.ssm.service.UserService;

@Controller
@RequestMapping(value="/user")
public class UserController {

//	private static Logger log = Logger.getLogger(UserController.class);

	@Autowired
	UserService userService;

	@ResponseBody
	@RequestMapping(value = "/login/toLogin.go",method=RequestMethod.GET)
	public ModelAndView loginToLogin() {
		ModelAndView mv= new ModelAndView();
		mv.setViewName("login");
		return mv;
	}
	
	@ResponseBody
	@RequestMapping(value = "/login.go",method=RequestMethod.POST)
	public String login(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		String account = request.getParameter("account");  
		String password = request.getParameter("password");  

//		userService.login(account,password);
		
//		mv.setViewName("user/success");
//		mv.addObject("java", "javac");
//		return mv;

		return "javac";
	}

	@ResponseBody
	@RequestMapping(value = "/register/toRegister.go",method=RequestMethod.GET)
	public ModelAndView registerToRegister() {
		ModelAndView mv= new ModelAndView();
		mv.setViewName("register");
		return mv;
	}

	@ResponseBody
	@RequestMapping(value = "/register.go",method=RequestMethod.POST)
	public ModelAndView register(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		
		String username = request.getParameter("username");  
		String password = request.getParameter("password");  

		userService.register(username,password);
		
		mv.setViewName("user/success");

		return mv;

	}
	
}
