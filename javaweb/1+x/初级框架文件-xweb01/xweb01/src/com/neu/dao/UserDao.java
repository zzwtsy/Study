package com.neu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.neu.bean.User;
import com.neu.util.DBUtil;

/**
 * 对应user表的持久层
 */
public class UserDao {
	/**
	 * 根据用户名查找用户一条记录
	 * @param userName 用户名字
	 * @return User 用户Bean
	 */
	public User getUserByName(String userName) {
		//代码编写处
		
		return null;//请修改代码
	}
	
	/**
	 * 所有用户表的信息
	 * @return 用户列表
	 */
	public List<User> getAll() {
		//代码编写处
		
		
		return null;//请修改代码
	}

}
