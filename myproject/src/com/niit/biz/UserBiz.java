package com.niit.biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.niit.dao.IUserDao;
import com.niit.entity.User;

@Service
public class UserBiz implements IUserBiz {
	//×¢Èëdao¶ÔÏó
	@Resource(name="userDao")
	private IUserDao userDao;
	

	@Override
	public void save(User u) {
		userDao.save(u);
	}

	@Override
	public void update(User u) {
		userDao.update(u);
	}

	@Override
	public void delete(Integer id) {
		userDao.delete(id);
	}

	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}

	@Override
	public User findById(Integer id) {
		return userDao.findById(id);
	}

}

