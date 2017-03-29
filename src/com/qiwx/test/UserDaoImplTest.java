package com.qiwx.test;

import com.qiwx.User;
import com.qiwx.dao.UserDao;
import com.qiwx.impl.UserDaoImpl;

import junit.framework.TestCase;

public class UserDaoImplTest extends TestCase {

	// �Զ����ò�ִ��
	UserDao dao;

	protected void setUp() throws Exception {
		super.setUp();
		dao = new UserDaoImpl();
	}

	// ���н���ִ��
	protected void tearDown() throws Exception {
		super.tearDown();
		for (int i = 0; i < 10; i++) {

		}
	}

	// ����������˳��ִ��

	public void testRegist() {
		User user = new User();
		user.setId(1001);
		user.setUserName("С��");
		user.setPassword("123456");
		dao.regist(user);
	}

	public void testLogin() {
		User user = dao.login("С��", "123456");
		System.out.println(user.getUserName());
	}

	public void testCheck() {
		boolean b = dao.check("С��");
		System.out.println(b);

	}

}
