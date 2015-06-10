package itat.zttc.shop.mapper;

import com.google.common.collect.Lists;
import itat.zttc.shop.model.Address;
import itat.zttc.shop.model.CartProduct;
import itat.zttc.shop.model.Category;
import itat.zttc.shop.model.OrderStatus;
import itat.zttc.shop.model.Orders;
import itat.zttc.shop.model.Product;
import itat.zttc.shop.model.User;
import itat.zttc.shop.test.BaseTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * since 2015/6/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:beans.xml"})
public class TestOrderMapper extends BaseTest {


    @Test
    public void testAdd() throws Exception {
        addOrders();

    }

    @Test
    public void testDelete() throws Exception {
        Orders orders = addOrders();
        om.delete(orders.getId());
        Orders load = om.load(orders.getId());
        assertNull(load);
    }

    @Test
    public void testUpdate() throws Exception {
        Orders orders = addOrders();
        orders.setStatus(OrderStatus.PAY);
        om.update(orders);
        Orders load = om.load(orders.getId());
        assertEquals(OrderStatus.PAY, load.getStatus());

    }

    @Test
    public void testLoad() throws Exception {
        Orders orders = addOrders();
        Orders load = om.load(orders.getId());
        assertNotNull(load);
    }

    @Test
    public void testFindByUser() throws Exception {
        Orders orders = addOrders();
        Map<String, Object> map = buildMap();
        List<Orders> byUser = om.find(map);
        assertEquals(1,byUser.size());
    }

    @Test
    public void testFindByStatus() throws Exception {

    }

    @Test
    public void testFindByUserCount() throws Exception {

    }

    @Test
    public void testFindByStatusCount() throws Exception {

    }
}
