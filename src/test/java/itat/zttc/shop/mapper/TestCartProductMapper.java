package itat.zttc.shop.mapper;

import itat.zttc.shop.model.CartProduct;
import itat.zttc.shop.model.Category;
import itat.zttc.shop.model.Orders;
import itat.zttc.shop.model.Product;
import itat.zttc.shop.test.BaseTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * since 2015/6/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:beans.xml"})
public class TestCartProductMapper extends BaseTest {

    @Test
    public void testAdd() throws Exception {

        Orders orders = addOrders();

        Product product = addProduct();

        CartProduct cartProduct = new CartProduct();
        cartProduct.setPrice(product.getPrice().multiply(new BigDecimal("1")));
        cartProduct.setNumber(1);
        cartProduct.setOrders(orders);
        cartProduct.setProduct(product);
        cpm.add(cartProduct);
        assertTrue(cartProduct.getId() > 0);
    }

    @Test
    public void testDeleteByOrders() throws Exception {

    }
}
