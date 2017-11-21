package com.jesus.sshframework.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jesus.sshframework.model.User;
import com.jesus.sshframework.service.IUserService;

@Controller
public class UserController {

	@Resource
	private IUserService userService;
	
//	@RequestMapping(value = "/users/create" ,method=RequestMethod.POST)
	@RequestMapping("/users/create")
	public String add() {
		User user = new User("我的名字", "我是密码");
		user.setChannel("mychannel");
//		userService.save(user);
		userService.findUserByName("ss");
		return "/index";
	}
}
