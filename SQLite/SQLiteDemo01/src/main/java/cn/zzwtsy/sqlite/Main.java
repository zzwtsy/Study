package cn.zzwtsy.sqlite;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.sql.*;
import java.util.Scanner;

/**
 * @author zzwtsy
 */
@Slf4j
public class Main {
    static final String FILE_NAME = "test.db";

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        SqliteHelper sqliteHelper = new SqliteHelper(FILE_NAME);
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            sqliteHelper.getConnection(FILE_NAME);
            try {
                String sql = "CREATE TABLE T_userSettings (NAME CHAR(10) PRIMARY KEY NOT NULL,PASSWORD VARCHAR(16),THEME CHAR(6))";
                sqliteHelper.executeQuery(sql);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            log.info("表创建成功");
        } else {
            try {
                sqliteHelper.getConnection(FILE_NAME);
            } catch (ClassNotFoundException | SQLException e) {
                throw new RuntimeException(e);
            }
        }
        String userName, password;
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入用户名:");
        userName = scanner.next();
        System.out.print("请输入密码:");
        password = scanner.next();
        try {
            String insertStatement = "INSERT INTO T_userSettings(NAME, PASSWORD, THEME) VALUES("
                    + userName
                    + "," + password
                    + ",'DARK')";
            sqliteHelper.executeUpdate(insertStatement);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            ResultSet resultSet = sqliteHelper.executeQuery("SELECT * FROM T_userSettings");
            String name = resultSet.getString("NAME");
            String pwd = resultSet.getString("PASSWORD");
            System.out.println(name + "\n" + pwd);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}