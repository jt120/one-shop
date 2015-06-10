package itat.zttc.shop.service;

import itat.zttc.shop.model.Address;
import itat.zttc.shop.model.ShopException;
import itat.zttc.shop.model.User;
import itat.zttc.shop.test.BaseTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
/**
 * since 2015/6/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:beans.xml"})
public class TestAddressService extends BaseTest {

    @Autowired
    private IAddressService addressService;

    @Autowired
    private IUserService userService;

    @Test
    public void testAdd() throws Exception {
        User user = buildUser();
        userService.add(user);

        Address address = buildAddress();
        address.setUser(user);
        Address add = addressService.add(address);
        assertTrue(add.getId() > 0);
    }

    @Test(expected = ShopException.class)
    public void testAddEx() throws Exception {
        User user = buildUser();
        user.setId(10000);
        Address address = buildAddress();
        address.setUser(user);
        Address add = addressService.add(address);

    }
}
