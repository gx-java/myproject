package com.niit.dao;

import java.util.List;

import com.niit.entity.User;

public interface IUserDao {
//	1:��Ӳ���
	public void save(User u);
//	2:���²���
	public void update(User u);
//	3:ɾ������
	public void delete(Integer id);
//	4:��ѯ����
	public List<User> findAll();
//	5:����ID��ѯ
	public User findById(Integer id);
}

