package com.qiwx.dao;

import com.qiwx.User;

public interface UserDao {
	//��½
	public User login(String userName,String password);
	//ע��
	public void regist(User user);
	//���
	public boolean check(String userName);
	

}
