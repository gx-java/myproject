package com.niit.dao;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.niit.dao.IUserDao;
import com.niit.entity.User;

import jdk.nashorn.internal.ir.annotations.Reference;

/**
 * ³Ö¾Ã²ã
 * @author Andy
 *@Repository(value="userDao")=@Repository
 */
@Repository
public class UserDao implements IUserDao {
	
	//×¢ÈëHibernateTemplate
	@Resource(name="ht")
	private HibernateTemplate ht;
	

	@Override
	public void save(User u) {
		ht.save(u);
	}

	@Override
	public void update(User u) {
		ht.update(u);
	}

	@Override
	public void delete(Integer id) {
		ht.delete(findById(id));
	}

	@Override
	public List<User> findAll() {
		return ht.loadAll(User.class);
	}

	@Override
	public User findById(Integer id) {
		return ht.get(User.class, id);
	}
}

