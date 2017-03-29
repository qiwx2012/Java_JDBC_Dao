package com.qiwx.dao;

import com.qiwx.User;

public interface UserDao {
	//µÇÂ½
	public User login(String userName,String password);
	//×¢²á
	public void regist(User user);
	//¼ì²é
	public boolean check(String userName);
	

}
