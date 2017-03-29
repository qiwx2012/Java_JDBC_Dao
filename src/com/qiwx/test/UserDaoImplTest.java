package com.qiwx.test;

import com.qiwx.User;
import com.qiwx.dao.UserDao;
import com.qiwx.impl.UserDaoImpl;

import junit.framework.TestCase;

public class UserDaoImplTest extends TestCase {

	// 自动调用并执行
	UserDao dao;

	protected void setUp() throws Exception {
		super.setUp();
		dao = new UserDaoImpl();
	}

	// 运行结束执行
	protected void tearDown() throws Exception {
		super.tearDown();
		for (int i = 0; i < 10; i++) {

		}
	}

	// 其他方法会顺序执行

	public void testRegist() {
		User user = new User();
		user.setId(1001);
		user.setUserName("小明");
		user.setPassword("123456");
		dao.regist(user);
	}

	public void testLogin() {
		User user = dao.login("小明", "123456");
		System.out.println(user.getUserName());
	}

	public void testCheck() {
		boolean b = dao.check("小明");
		System.out.println(b);

	}

}
