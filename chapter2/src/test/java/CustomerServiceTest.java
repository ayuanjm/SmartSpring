import org.junit.Before;
import org.junit.Test;
import org.smart4j.chapter2.helper.DatabaseHelper;
import org.smart4j.chapter2.model.Customer;
import org.smart4j.chapter2.service.CustomerService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerServiceTest {
    private final CustomerService customerService;
    public CustomerServiceTest(){
        customerService = new CustomerService();
    }

    @Before
    public void init() {
        //DatabaseHelper.executeSqlFile("sql/customer_init.sql");
    }
    @Test
    public void getCustomerList() {
        List<Customer> list = customerService.getCustomerList();
        System.out.println(list);
    }
    @Test
    public void insertCustomer() {
        Map<String,Object> map = new HashMap<>();
        //map.put("id",5);
        map.put("name","yu");
        map.put("phoneTel","697574");
        boolean b = customerService.createCustomer(map);
        System.out.println(b);
    }
    @Test
    public void updateCustomer() {
        Map<String,Object> map = new HashMap<>();
        map.put("id",5);
        map.put("name","xinyu");
        map.put("phoneTel","697574");
        boolean b = customerService.updateCustomer(5,map);
        System.out.println(b);
    }

    @Test
    public void deleteCustomer() {
        Map<String,Object> map = new HashMap<>();
        boolean b = customerService.deleteCustomer(5);
        System.out.println(b);
    }
}

