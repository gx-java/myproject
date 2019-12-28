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
/*@Controller  ��spring���������ĸ�����һģһ��,ֻ�Ƕ�������ò㲻ͬ
 * .���������controller��
 *@Component .��������ڳ��������������������
  @Repository .���������dao��
  @Service .��������ڷ����
 * 
 * @RequestMapping(value="user"):ӳ��·��
 * @Resource(name="userBiz"):����ע�����
 * @RequestParam:�ֶε�ǿ�ư�
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
    	
		  System.out.println("-�û���¼-");
		  //�����һ����ͼ,�������÷���ҳ��Ĳ������Լ�ҳ��·��
		System.out.println(name+"--"+gender);
		//����Session
		User user=new User();
		user.setName(name);
		user.setGender(gender);
		userBiz.save(user);
		session.setAttribute("user", user);
	    return "hello";
		  
	}
}

