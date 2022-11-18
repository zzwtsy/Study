package cn.acdt.hwk.day23.database;

import lombok.extern.log4j.Log4j2;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

import static cn.acdt.hwk.day23.tools.MyStatic.*;

/**
 * DbUtils
 *
 * @author 孟繁兴
 * @date 2022/11/18
 */
@Log4j2
public class DataBaseHelper {
    private static Connection conn = null;
    private static PreparedStatement pstmt = null;
    private static ResultSet rs = null;

    static {
        try {
            Class.forName(DRIVER_CLASS_NAME);
            log.info("数据库连接成功");
        } catch (ClassNotFoundException e) {
            log.error("数据库连接失败");
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库Connection
     *
     * @return connection
     */
    private static Connection getConnection() {
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
    private static PreparedStatement getStatement(String sql) {
        try {
            pstmt = getConnection().prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pstmt;
    }

    /**
     * 执行sql查询并返回查询结果
     *
     * @param sql    sql语句
     * @param object sql参数
     * @return 查询结果
     */
    public static Map<Object, Object> executeQuery(String sql, Object... object) throws SQLException {
        Map<Object, Object> map = new HashMap<>();
        pstmt = getStatement(sql);
        for (int i = 0; i < object.length; i++) {
            pstmt.setObject(i + 1, object[i]);
        }
        try {
            rs = pstmt.executeQuery();
            if (rs.next()) {
                map.put("id", rs.getInt("id"));
                map.put("username", rs.getString("username"));
                map.put("password", rs.getString("password"));
                map.put("ident", rs.getString("ident"));
                map.put("telephone", rs.getString("telephone"));
                map.put("address", rs.getString("address"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return map;
    }

    /**
     * 执行增删改查
     *
     * @param sql    sql语句
     * @param object sql参数
     * @return int 1:执行成功 0：执行失败
     */
    public static int executeUpdate(String sql, Object... object) throws SQLException {
        pstmt = getStatement(sql);
        for (int i = 0; i < object.length; i++) {
            pstmt.setObject(i + 1, object[i]);
        }
        int executeStatic = 0;
        try {
            int i = pstmt.executeUpdate();
            if (i > 0) {
                executeStatic = 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return executeStatic;
    }

    private static void close() {
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                log.error("PreparedStatement关闭失败");
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                log.error("Connection关闭失败");
                e.printStackTrace();
            }
        }
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                log.error("ResultSet关闭失败");
                e.printStackTrace();
            }
        }
    }
}
