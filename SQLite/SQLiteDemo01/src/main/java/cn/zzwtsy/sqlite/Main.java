package cn.zzwtsy.sqlite;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author zzwtsy
 */
public class Main {
    public static void main(String[] args) {
        Connection connection;
        Statement statement;
        File file = new File("test.db");
        if (!file.exists()) {
            connection = connectDatabase();
            try {
                statement = connection.createStatement();
                String sql = "CREATE TABLE T_userSettings"
                        + "(NAME TEXT NOT NULL,"
                        + "PASSWORD VARCHAR(16),"
                        + "THEME CHAR(6)"
                        + ")";
                statement.execute(sql);
                statement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            System.out.println("表创建成功");
        }else {
            connectDatabase();
        }
    }

    /**
     * 连接数据库
     */
    public static Connection connectDatabase(){
        Connection connection;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:test.db");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("加载数据库成功");
        return connection;
    }
}