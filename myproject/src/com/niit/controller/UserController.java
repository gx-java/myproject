package com.niit.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.biz.IUserBiz;
import com.niit.entity.User;
/*@Controller  由spring创建对象四个功能一模一样,只是定义的作用层不同
 * .这个作用于controller层
 *@Component .这个作用于除了这三层意外的其他层
  @Repository .这个作用于dao层
  @Service .这个作用于服务层
 * 
 * @RequestMapping(value="user"):映射路径
 * @Resource(name="userBiz"):依赖注入对象
 * @RequestParam:字段的强制绑定
 * */
@Controller
@RequestMapping(value="user")
public class UserController {
	
	@Resource(name="userBiz")
	private IUserBiz userBiz;
	
    @RequestMapping(value="login")
	public String login(@RequestParam(value="name") String name,
			            @RequestParam(value="gender") String gender,
			            HttpSession session)  {
    	
		  System.out.println("-用户登录-");
		  //这个是一个视图,用于设置返回页面的参数的以及页面路径
		System.out.println(name+"--"+gender);
		//放在Session
		User user=new User();
		user.setName(name);
		user.setGender(gender);
		userBiz.save(user);
		session.setAttribute("user", user);
	    return "hello";
		  
	}
}

