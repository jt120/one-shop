package itat.zttc.shop.mapper;

import com.google.common.collect.Maps;
import itat.zttc.shop.model.Category;
import itat.zttc.shop.model.Product;
import itat.zttc.shop.test.BaseTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * since 2015/6/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:beans.xml"})
public class TestProductMapper extends BaseTest {

    @Test
    public void testAdd() throws Exception {
        addProduct();

    }

    @Test
    public void testDelete() throws Exception {

        Product product = addProduct();

        cm.delete(product.getId());
        Category load = cm.load(product.getId());
        assertNull(load);


    }

    @Test
    public void testUpdate() throws Exception {
        Product product = addProduct();
        product.setName("kt");
        pm.update(product);
        Product load = pm.load(product.getId());
        assertEquals("kt", load.getName());
    }

    @Test
    public void testLoad() throws Exception {
        Product product = addProduct();
        Product load = pm.load(product.getId());
        assertNotNull(load);
    }

    @Test
    public void testFind() throws Exception {
        Product product = addProduct();
        Map<String, Object> params = buildMap();
        List<Product> products = pm.find(params);
        assertEquals(1, products.size());
    }
}
