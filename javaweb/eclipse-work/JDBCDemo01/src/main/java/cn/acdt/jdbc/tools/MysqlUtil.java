package cn.acdt.jdbc.tools;

import static cn.acdt.jdbc.tools.MyStatic.DRIVER_CLASS_NAME;
import static cn.acdt.jdbc.tools.MyStatic.MYSQL_CONNECT_URL;
import static cn.acdt.jdbc.tools.MyStatic.MYSQL_USER_NAME;
import static cn.acdt.jdbc.tools.MyStatic.MYSQL_USER_PASSWORD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * MySql工具类
 * 
 * @author 孟繁兴
 * @date 2022/11/17
 */
public class MysqlUtil {
    private static Connection conn = null;
    private static Statement stmt = null;
    private static ResultSet rs = null;

    /**
     * static块会在类被加载的时候执行且只会执行一次
     */
    static {
        try {
            Class.forName(DRIVER_CLASS_NAME);
            System.out.println("数据库连接成功");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("数据库连接失败");
        }
    }

    /**
     * 获取数据库Connection
     * 
     * @return connection
     */
    private Connection getConnection() {
        try {
            conn = DriverManager.getConnection(MYSQL_CONNECT_URL, MYSQL_USER_NAME, MYSQL_USER_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 获取数据库statement
     * 
     * @return Statement
     */
    private Statement getStatement() {
        try {
            stmt = getConnection().createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stmt;

    }

    public ResultSet executeQuery(String sql, Object... object) {
        try {
            rs = getStatement().executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    /**
     * 关闭连接
     */
    private void mysqlDestroy(Connection conn, Statement stmt, ResultSet rs) {
        if (conn != null) {
            try {

                conn.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (stmt != null) {
            try {
                stmt.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 关闭连接
     */
    private void mysqlDestroy(Connection conn, Statement stmt) {
        if (conn != null) {
            try {

                conn.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (stmt != null) {
            try {
                stmt.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
