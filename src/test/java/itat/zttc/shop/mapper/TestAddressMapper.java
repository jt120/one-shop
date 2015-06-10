package itat.zttc.shop.mapper;

import itat.zttc.shop.model.Address;
import itat.zttc.shop.model.User;
import itat.zttc.shop.test.BaseTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * since 2015/6/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:beans.xml"})
public class TestAddressMapper extends BaseTest{

    @Test
    public void testAdd() throws Exception {
        addAddress();

    }

    @Test
    public void testUpdate() throws Exception {
        Address address = addAddress();

        Address load = am.load(address.getId());
        load.setPostcode("111");
        am.update(load);

        Address nl = am.load(address.getId());
        assertEquals(nl.getPostcode(),"111");

    }

    @Test
    public void testDelete() throws Exception {
        Address address = addAddress();

        am.delete(address.getId());

        Address load = am.load(address.getId());
        assertNull(load);
    }

    @Test
    public void testLoad() throws Exception {

        Address address = addAddress();

        Address load = am.load(address.getId());
        assertNotNull(load);
        assertEquals(address, load);
    }

    @Test
    public void testList() throws Exception {

        User user = buildUser();
        um.add(user);

        Address address = buildAddress();
        address.setUser(user);
        am.add(address);

        Address address1 = buildAddress("天津");
        address1.setUser(user);
        am.add(address1);

        List<Address> list = am.list(user.getId());
        assertNotNull(list);
        assertEquals(list.size(),2);
    }

}
