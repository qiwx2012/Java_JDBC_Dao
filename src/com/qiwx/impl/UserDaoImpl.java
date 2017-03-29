package com.qiwx.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.qiwx.DBUtils;
import com.qiwx.User;
import com.qiwx.dao.UserDao;

public class UserDaoImpl implements UserDao {

	@Override
	public User login(String userName, String password) {
		String sql="select * from user where username=? and password=?";
		  DBUtils dbUtils=new DBUtils();
		  Connection connection=dbUtils.getConnection();
		   try {
			PreparedStatement pStatement=connection.prepareStatement(sql);
			pStatement.setString(1,userName);
			pStatement.setString(2,password);
			ResultSet rSet=pStatement.executeQuery();
			if(rSet.next()){
				int id=rSet.getInt(1);
				/*String name=rSet.getString(2);
				String pwd=rSet.getString(3);*/
				User user=new User();
				user.setId(id);
				//因为如果能走到这一步说明用户名和密码一致不需要再取
				user.setUserName(userName);
				user.setPassword(password);
				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			dbUtils.closeDb(connection);
		}
		return null;
	}

	@Override
	public void regist(User user) {
	  String sql="insert into User (id,username,password)values(?,?,?)";
	  DBUtils dbUtils=new DBUtils();
	  Connection connection=dbUtils.getConnection();
	   try {
		PreparedStatement pStatement=connection.prepareStatement(sql);
		pStatement.setInt(1, user.getId());
		pStatement.setString(2, user.getUserName());
		pStatement.setString(3, user.getPassword());
		pStatement.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		dbUtils.closeDb(connection);
	}
	   
		
	}

	@Override
	public boolean check(String userName) {
		// TODO Auto-generated method stub
		String sql="select * from user where username=? ";
		  DBUtils dbUtils=new DBUtils();
		  Connection connection=dbUtils.getConnection();
		   try {
			PreparedStatement pStatement=connection.prepareStatement(sql);
			pStatement.setString(1,userName);
			ResultSet rSet=pStatement.executeQuery();
			if(rSet.next()){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			dbUtils.closeDb(connection);
		}
		return false;
	}

}
