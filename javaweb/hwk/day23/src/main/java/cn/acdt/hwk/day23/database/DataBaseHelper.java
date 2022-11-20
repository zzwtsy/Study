package cn.acdt.hwk.day23.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static cn.acdt.hwk.day23.tools.DataBaseStatic.*;

/**
 * @author 孟繁兴
 */
public class DataBaseHelper {
    private static Connection conn = null;
    private static PreparedStatement pstmt = null;
    private static ResultSet rs = null;

    static {
        try {
            Class.forName(DRIVER_CLASS_NAME);
        } catch (ClassNotFoundException e) {
            System.err.println("数据库连接失败");
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库Connection
     *
     * @return connection
     */
    private static Connection getConnection() throws SQLException {
        conn = DriverManager.getConnection(MYSQL_CONNECT_URL, MYSQL_USER_NAME, MYSQL_USER_PASSWORD);
        return conn;
    }

    /**
     * 获取数据库statement
     *
     * @return Statement
     */
    private static PreparedStatement getStatement(String sql) throws SQLException {
        pstmt = getConnection().prepareStatement(sql);
        return pstmt;
    }

    /**
     * 执行sql查询并返回查询结果
     *
     * @param sql    sql语句
     * @param object sql参数
     * @return {@code List<Map<Object, Object>>}
     * @throws SQLException sqlexception异常
     */
    public static List<Map<Object, Object>> executeQuery(String sql, Object... object) throws SQLException {
        List<Map<Object, Object>> listFromResultSet = null;
        pstmt = getStatement(sql);
        for (int i = 0; i < object.length; i++) {
            pstmt.setObject(i + 1, object[i]);
        }
        try {
            rs = pstmt.executeQuery();
            listFromResultSet = getListFromResultSet(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return listFromResultSet;
    }

    /**
     * 执行增删改操作
     *
     * @param sql    sql语句
     * @param object sql参数
     * @return int
     * @throws SQLException sqlexception异常
     */
    public static int executeUpdate(String sql, Object... object) throws SQLException {
        int executeStatic = 0;
        pstmt = getStatement(sql);
        for (int i = 0; i < object.length; i++) {
            pstmt.setObject(i + 1, object[i]);
        }
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

    /**
     * 从ResultSet获取列表
     *
     * @param rs ResultSet
     * @return {@code List<Map<Object, Object>>}
     * @throws SQLException sqlexception异常
     */
    private static List<Map<Object, Object>> getListFromResultSet(ResultSet rs) throws SQLException {
        List<Map<Object, Object>> list = new ArrayList<>();
        ResultSetMetaData rsMetaData = rs.getMetaData();
        int columnCount = rsMetaData.getColumnCount();
        while (rs.next()) {
            Map<Object, Object> map = new HashMap<>(columnCount);
            for (int i = 1; i <= columnCount; i++) {
                String column = rsMetaData.getColumnLabel(i);
                Object object = rs.getObject(column);
                if (object != null) {
                    map.put(column, object);
                }
            }
            list.add(map);
        }
        return list;
    }

    private static void close() {
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                System.err.println("PreparedStatement关闭失败");
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.err.println("Connection关闭失败");
                e.printStackTrace();
            }
        }
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                System.err.println("ResultSet关闭失败");
                e.printStackTrace();
            }
        }
    }
}
