package org.smart4j.framework.helper;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smart4j.framework.util.CollectionUtil;
import org.smart4j.framework.util.PropsUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class DatabaseHelper {
    private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseHelper.class);
    private static final QueryRunner QUERY_RUNNER = new QueryRunner();
    private static final ThreadLocal<Connection> CONNECTION_HOLDER = new ThreadLocal<Connection>();
    private static final BasicDataSource DATA_SOURCE;

    static {
        Properties properties = PropsUtil.loadProps("config.properties");
        String drive = properties.getProperty("jdbc.driver");
        String url = properties.getProperty("jdbc.url");
        String userName = properties.getProperty("jdbc.username");
        String passWord = properties.getProperty("jdbc.password");
        DATA_SOURCE = new BasicDataSource();
        DATA_SOURCE.setDriverClassName(drive);
        DATA_SOURCE.setUrl(url);
        DATA_SOURCE.setPassword(passWord);
        DATA_SOURCE.setUsername(userName);
    }


    /**
     * 获取数据库连接
     *
     * @return
     */
    public static Connection getConnection() {
        Connection connection = CONNECTION_HOLDER.get();
        if (connection == null) {
            try {
                connection = DATA_SOURCE.getConnection();
            } catch (SQLException e) {
                LOGGER.info("get connection fail", e);
            } finally {
                CONNECTION_HOLDER.set(connection);
            }
        }
        return connection;
    }

    /**
     * 关闭数据库连接
     */
    public static void closeConnection() {
        Connection connection = CONNECTION_HOLDER.get();
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                LOGGER.error("close connection fail", e);
            }
        }
    }

    public static void executeSqlFile(String filePath) {
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(filePath);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String sql;
        try {
            while ((sql = bufferedReader.readLine()) != null) {
                DatabaseHelper.executeUpdate(sql);
            }
        } catch (IOException e) {
            LOGGER.error("execute sql file fail");
            throw new RuntimeException(e);
        }
    }

    /**
     * 查询用户列表
     *
     * @param entityClass
     * @param sql
     * @param param
     * @param <T>
     * @return
     */
    public static <T> List<T> queryEntityList(Class<T> entityClass, String sql, Object... param) {
        List<T> entityList = null;
        Connection connection = getConnection();
        try {
            entityList = QUERY_RUNNER.query(connection, sql, new BeanListHandler<T>(entityClass), param);
        } catch (SQLException e) {
            LOGGER.error("");
        }
        return entityList;
    }

    /**
     * 查询用户实体类
     *
     * @param entityClass
     * @param sql
     * @param param
     * @param <T>
     * @return
     */
    public static <T> T queryEntity(Class<T> entityClass, String sql, Object... param) {
        T entity = null;
        Connection connection = getConnection();
        try {
            entity = QUERY_RUNNER.query(connection, sql, new BeanHandler<T>(entityClass), param);
        } catch (SQLException e) {
            LOGGER.error("");
        }
        return entity;
    }

    /**
     * 执行查询
     *
     * @param sql
     * @param param
     * @return
     */
    public static List<Map<String, Object>> executeQuery(String sql, Object... param) {
        List<Map<String, Object>> mapList = null;
        Connection connection = getConnection();
        try {
            mapList = QUERY_RUNNER.query(connection, sql, new MapListHandler(), param);
        } catch (SQLException e) {
            LOGGER.error("execute select failure");
        }
        return mapList;
    }

    //执行更新语句（dml）
    public static int executeUpdate(String sql, Object... param) {
        int rows = 0;
        Connection connection = getConnection();
        try {
            rows = QUERY_RUNNER.update(connection, sql, param);
        } catch (SQLException e) {
            LOGGER.error("execute update failure");
        }
        return rows;
    }

    /**
     * 插入实体
     */
    public static <T> boolean insertEntity(Class<T> entityClass, Map<String, Object> fileMap) {
        if (CollectionUtil.isEmpty(fileMap)) {
            LOGGER.error("can not insert entity null");
            return false;
        }
        String sql = "insert into " + getTableName(entityClass);
        StringBuffer columns = new StringBuffer("(");
        StringBuffer values = new StringBuffer("(");
        for (String fileName : fileMap.keySet()) {
            columns.append(fileName).append(", ");
            values.append("?, ");
        }
        columns.replace(columns.lastIndexOf(", "), columns.length(), ")");
        values.replace(values.lastIndexOf(", "), values.length(), ")");
        sql += columns + "VALUES" + values;
        Object[] params = fileMap.values().toArray();
        return executeUpdate(sql, params) == 1;

    }

    /**
     * 更新实体
     *
     * @param entityClass
     * @param id
     * @param fileMap
     * @param <T>
     * @return
     */
    public static <T> boolean updateEntity(Class<T> entityClass, long id, Map<String, Object> fileMap) {
        if (CollectionUtil.isEmpty(fileMap)) {
            LOGGER.error("can not update entity null");
            return false;
        }
        String sql = "update " + getTableName(entityClass) + " set ";
        StringBuffer columns = new StringBuffer();
        for (String fileName : fileMap.keySet()) {
            columns.append(fileName).append("=?, ");
        }
        sql += columns.substring(0, columns.lastIndexOf(", ")) + " where id = ?";
        List<Object> paramList = new ArrayList<>();
        paramList.addAll(fileMap.values());
        paramList.add(id);
        Object[] params = paramList.toArray();
        return executeUpdate(sql, params) == 1;
    }

    /**
     * 删除实体
     */
    public static <T> boolean deleteEntity(Class<T> entityClass, long id) {
        String sql = "delete from " + getTableName(entityClass) + " where id = ?";
        return executeUpdate(sql, id) == 1;
    }

    /**
     * 得到类名
     *
     * @param entity
     * @return
     */
    private static String getTableName(Class<?> entity) {
        return entity.getSimpleName();
    }


    /**
     * 开启事务
     */
    public static void beginTransaction() {
        Connection connection = getConnection();
        if (connection != null) {
            try {
                connection.setAutoCommit(false);
            } catch (SQLException e) {
                LOGGER.error("begin transaction fail", e);
                throw new RuntimeException(e);
            } finally {
                CONNECTION_HOLDER.set(connection);
            }

        }
    }

    /**
     * 提交事务
     */
    public static void commitTransaction() {
        Connection connection = getConnection();
        if (connection != null) {
            try {
                connection.commit();
                connection.close();
            } catch (SQLException e) {
                LOGGER.error("commit transaction fail", e);
                throw new RuntimeException(e);
            } finally {
                CONNECTION_HOLDER.remove();
            }
        }
    }

    /**
     * 回滚事务
     */
    public static void rollbackTransaction() {
        Connection connection = getConnection();
        if (connection != null) {
            try {
                connection.rollback();
                connection.close();
            } catch (SQLException e) {
                LOGGER.error("rollback transaction fail", e);
                throw new RuntimeException(e);
            } finally {
                CONNECTION_HOLDER.remove();
            }
        }
    }
}
