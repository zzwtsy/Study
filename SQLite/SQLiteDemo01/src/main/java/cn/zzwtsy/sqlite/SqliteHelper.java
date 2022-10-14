package cn.zzwtsy.sqlite;

import java.sql.*;
import java.util.List;

import lombok.extern.log4j.Log4j2;


/**
 * sqlite帮助类，直接创建该类示例，并调用相应的借口即可对sqlite数据库进行操作
 * <p>
 * 本类基于 sqlite jdbc v56
 *
 * @author haoqipeng
 */
@Log4j2
public class SqliteHelper {

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private final String dbFilePath;

    /**
     * 构造函数
     *
     * @param dbFilePath sqlite db 文件路径
     */
    public SqliteHelper(String dbFilePath) {
        this.dbFilePath = dbFilePath;
    }

    /**
     * 获取数据库连接
     *
     * @param dbFilePath db文件路径
     * @return 数据库连接
     * @throws ClassNotFoundException ClassNotFoundException
     * @throws SQLException           SQLException
     */
    public Connection getConnection(String dbFilePath) throws ClassNotFoundException, SQLException {
        Connection conn;
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:" + dbFilePath);
        return conn;
    }

    /**
     * 执行sql查询
     *
     * @param sql sql select 语句
     * @return 查询结果
     * @throws SQLException           SQLException
     * @throws ClassNotFoundException ClassNotFoundException
     */
    public ResultSet executeQuery(String sql) throws SQLException, ClassNotFoundException {
        ResultSet resultSet1;
//        try {
            resultSet1 = getStatement().executeQuery(sql);
//        } finally {
//            destroyed();
//        }
        return resultSet1;
    }

    /**
     * 执行数据库更新sql语句
     *
     * @param sql sql语句
     * @throws SQLException           SQLException
     * @throws ClassNotFoundException ClassNotFoundException
     */
    public void executeUpdate(String sql) throws SQLException, ClassNotFoundException {
        try {
            getStatement().executeUpdate(sql);
        } finally {
            destroyed();
        }

    }

    /**
     * 执行多个sql更新语句
     *
     * @param sqlList sql列表
     * @throws SQLException           SQLException
     * @throws ClassNotFoundException ClassNotFoundException
     */
    public void executeUpdate(String... sqlList) throws SQLException, ClassNotFoundException {
        try {
            for (String sql : sqlList) {
                getStatement().executeUpdate(sql);
            }
        } finally {
            destroyed();
        }
    }

    /**
     * 执行数据库更新 sql List
     *
     * @param sqlList sql列表
     * @throws SQLException           SQLException
     * @throws ClassNotFoundException ClassNotFoundException
     */
    public void executeUpdate(List<String> sqlList) throws SQLException, ClassNotFoundException {
        try {
            for (String sql : sqlList) {
                getStatement().executeUpdate(sql);
            }
        } finally {
            destroyed();
        }
    }

    private Connection getConnection() throws ClassNotFoundException, SQLException {
        if (null == connection) {
            connection = getConnection(dbFilePath);
        }
        return connection;
    }

    private Statement getStatement() throws SQLException, ClassNotFoundException {
        if (null == statement) {
            statement = getConnection().createStatement();
        }
        return statement;
    }

    /**
     * 数据库资源关闭和释放
     */
    public void destroyed() {
        try {
            if (null != connection) {
                connection.close();
                connection = null;
            }

            if (null != statement) {
                statement.close();
                statement = null;
            }

            if (null != resultSet) {
                resultSet.close();
                resultSet = null;
            }
        } catch (SQLException e) {
            log.error("Sqlite数据库关闭时异常", e);
        }
    }
}