package itat.zttc.shop.mapper;

import com.google.common.collect.Maps;
import itat.zttc.shop.model.Category;
import itat.zttc.shop.test.BaseTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Objects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * since 2015/6/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:beans.xml"})
public class TestCategoryMapper extends BaseTest{

    @Test
    public void testAdd() throws Exception {
        Category category = new Category();
        category.setName("家电");
        cm.add(category);

        assertTrue(category.getId() > 0);
    }

    @Test
    public void testDelete() throws Exception {
        Category category = new Category();
        category.setName("家电");
        cm.add(category);

        cm.delete(category.getId());

        Category load = cm.load(category.getId());
        assertNull(load);

    }

    @Test
    public void testUpdate() throws Exception {
        Category category = new Category();
        category.setName("家电");
        cm.add(category);

        cm.load(category.getId());
        category.setName("建材");
        cm.update(category);

        Category load = cm.load(category.getId());

        assertEquals("建材", load.getName());
    }

    @Test
    public void testList() throws Exception {
        Category category = new Category();
        category.setName("家电");
        cm.add(category);

        Category category2 = new Category();
        category2.setName("家具");
        cm.add(category2);

        List<Category> list = cm.list(null);
        assertEquals(2, list.size());
    }

    @Test
    public void testLoad() throws Exception {
        Category category = new Category();
        category.setName("家电");
        cm.add(category);

        Category load = cm.load(category.getId());
        assertEquals(category, load);
    }
}
