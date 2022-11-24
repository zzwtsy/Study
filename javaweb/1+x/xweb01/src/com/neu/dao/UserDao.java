package com.neu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
     * 
     * @param userName 用户名字
     * @return User 用户Bean
     */
    public User getUserByName(String userName) {
        // 代码编写处
        User user = new User();
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        connection = DBUtil.getConnection();
        String sql = "SELECT * FROM user WHERE userName=?";
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, userName);
            rs = pstmt.executeQuery();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            user.setId(rs.getString("id"));
            user.setUserName(rs.getString("userName"));
            user.setPassword(rs.getString("password"));
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return user;// 请修改代码
    }

    /**
     * 所有用户表的信息
     * 
     * @return 用户列表
     */
    public List<User> getAll() {
        // 代码编写处
        List<User> userList = new ArrayList<>();
        User user = new User();
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        connection = DBUtil.getConnection();
        String sql = "SELECT * FROM user";
        try {
            pstmt = connection.prepareStatement(sql);
            rs = pstmt.executeQuery();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (connection != null) {
                DBUtil.closeConnection(connection);
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        try {
            while (rs.next()) {
                user.setId(rs.getString("id"));
                user.setUserName(rs.getString("userName"));
                user.setPassword(rs.getString("password"));
                userList.add(user);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

        return userList;// 请修改代码
    }

}
