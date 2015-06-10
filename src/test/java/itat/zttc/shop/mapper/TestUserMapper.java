package itat.zttc.shop.mapper;


import itat.zttc.shop.model.Address;
import itat.zttc.shop.model.User;
import itat.zttc.shop.test.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:beans.xml"})
public class TestUserMapper extends BaseTest {

    @Test
    public void testAdd() {
        User u = buildUser();
        um.add(u);
        Assert.assertTrue(u.getId() > 0);
    }

    @Test
    public void testUpdate() {
        User u = buildUser();
        um.add(u);

        u = um.load(u.getId());
        u.setPassword("2222");
        um.update(u);
        u = um.load(u.getId());
        Assert.assertTrue(u.getPassword().equals("2222"));
    }

    @Test
    public void testDelete() {
        User u = buildUser();
        um.add(u);

        um.delete(u.getId());

        User load = um.load(u.getId());
        Assert.assertNull(load);
    }

    @Test
    public void testLoad() {
        User u2 = buildUser();
        um.add(u2);

        Address address = buildAddress();
        address.setUser(u2);

        am.add(address);
        User u = um.load(u2.getId());
        List<Address> addresses = u.getAddresses();
        Assert.assertTrue(addresses.size() == 1);
    }


}
