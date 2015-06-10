package itat.zttc.shop.service;

import com.google.common.collect.Maps;
import itat.zttc.shop.model.Address;
import itat.zttc.shop.model.Pager;
import itat.zttc.shop.model.ShopException;
import itat.zttc.shop.model.SystemContext;
import itat.zttc.shop.model.User;
import itat.zttc.shop.test.BaseTest;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.Reader;
import java.io.StringReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
/**
 * since 2015/6/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:beans.xml"})
public class TestUserService extends BaseTest {

    @Autowired
    IUserService us;


    @Test
    public void testAdd() {
        User u = buildUser();
        User add = us.add(u);
        Assert.assertTrue(add.getId() > 0);
    }

    @Test(expected = ShopException.class)
    public void testAddChong() throws Exception {
        User u = buildUser();
        User add = us.add(u);
        User u2 = buildUser();
        us.add(u2);
    }


    @Test
    public void testLogin() {
        User u = buildUser();
        us.add(u);
        User login = us.login(u.getUsername(), u.getPassword());
        assertNotNull(login);

    }

    @Test(expected = ShopException.class)
    public void testLoginNotPass() throws Exception {
        User u = buildUser();
        us.add(u);
        User login = us.login(u.getUsername(), u.getPassword()+"111");
    }

    @Test
    public void testFind() {
        SystemContext.setPageOffset(0);
        SystemContext.setPageSize(15);
        SystemContext.setOrder("desc");
        SystemContext.setSort("nickname");

        User u1 = buildUser();
        us.add(u1);

        User u2 = buildUser("test2");
        us.add(u2);

        Pager<User> ps = us.find("test");
        System.out.println(ps.getTotalRecord());
        for (User u : ps.getDatas()) {
            System.out.println(u);
        }
        Assert.assertTrue(ps.getDatas().size() == 2);

    }

}
