package org.smart4j.chapter2.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smart4j.chapter2.helper.DatabaseHelper;
import org.smart4j.chapter2.model.Customer;
import org.smart4j.chapter2.utils.PropsUtil;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class CustomerService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);
    private static final String DRIVER;
    private static final String URL;
    private static final String USERNAME;
    private static final String PASSWORD;

    static {
        Properties properties = PropsUtil.loadProps("config.properties");
        DRIVER = properties.getProperty("jdbc.driver");
        URL = properties.getProperty("jdbc.url");
        USERNAME = properties.getProperty("jdbc.username");
        PASSWORD = properties.getProperty("jdbc.password");
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            LOGGER.error("can not load jdbc driver",e);
        }
    }

    public List<Customer> getCustomerList() {
        try {
            String sql = "select * from customer";
            return DatabaseHelper.queryEntityList(Customer.class,sql);
        } catch (Exception e) {
            LOGGER.error("execute sql fail",e);
        }
        return null;
    }

    public Customer getCustomer(long id){
        String sql = "select * from customer where id = ?";
        return DatabaseHelper.queryEntity(Customer.class,sql,id);
    };

    /**
     * 创建客户
     * @param map
     * @return
     */
    public boolean createCustomer(Map<String,Object> map) {
        return DatabaseHelper.insertEntity(Customer.class,map);
    }

    /**
     * 更新客户
     * @param id
     * @param map
     * @return
     */
    public  boolean updateCustomer(long id,Map<String,Object> map) {
        return DatabaseHelper.updateEntity(Customer.class,id,map);
    }

    /**
     * 删除客户
     * @param id
     * @return
     */
    public  boolean deleteCustomer(long id) {
        return DatabaseHelper.deleteEntity(Customer.class,id);
    }
}
