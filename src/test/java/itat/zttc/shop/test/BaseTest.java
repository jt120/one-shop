package itat.zttc.shop.test;


import com.google.common.collect.Maps;
import itat.zttc.shop.mapper.AddressMapper;
import itat.zttc.shop.mapper.CartProductMapper;
import itat.zttc.shop.mapper.CategoryMapper;
import itat.zttc.shop.mapper.OrderMapper;
import itat.zttc.shop.mapper.ProductMapper;
import itat.zttc.shop.mapper.UserMapper;
import itat.zttc.shop.model.Address;
import itat.zttc.shop.model.CartProduct;
import itat.zttc.shop.model.Category;
import itat.zttc.shop.model.Orders;
import itat.zttc.shop.model.Product;
import itat.zttc.shop.model.ProductStatus;
import itat.zttc.shop.model.User;
import itat.zttc.shop.model.UserTypeEnum;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.io.Reader;
import java.io.StringReader;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class BaseTest {

    @Autowired
    protected DataSource dataSource;

    @Autowired
    protected ProductMapper pm;

    @Autowired
    protected CategoryMapper cm;

    @Autowired
    protected AddressMapper am;

    @Autowired
    protected UserMapper um;

    @Autowired
    protected OrderMapper om;

    @Autowired
    protected CartProductMapper cpm;

    @Before
    public void init() {
        Connection connection = null;
        try {

            StringBuffer sb = new StringBuffer();
            sb.append("truncate t_user;").append("\n");
            sb.append("truncate t_address;").append("\n");
            sb.append("truncate t_category;").append("\n");
            sb.append("truncate t_product;").append("\n");
            sb.append("truncate t_orders;").append("\n");
            sb.append("truncate t_cart_product;").append("\n");
            sb.append("truncate t_product_orders;").append("\n");

            connection = dataSource.getConnection();
            ScriptRunner runner = new ScriptRunner(connection);
            Reader reader = new StringReader(sb.toString());
            runner.runScript(reader);
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    protected User buildUser(String username) {
        User u = new User();
        u.setNickname("test");
        u.setPassword("123");
        u.setType(UserTypeEnum.USER);
        u.setUsername(username);
        return u;
    }

    protected User buildUser() {

        return buildUser("test");
    }

    protected Address buildAddress() {
        Address address = new Address();
        address.setName("北京");
        address.setPhone("123");
        address.setPostcode("100");
        return address;
    }

    protected Address buildAddress(String name) {
        Address address = new Address();
        address.setName(name);
        address.setPhone("123");
        address.setPostcode("100");
        return address;
    }

    protected Product buildProduct() {
        Product product = new Product();
        product.setName("tv");
        product.setImg("d:/1.bmp");
        product.setIntro("intro");
        product.setStock(10);
        product.setPrice(new BigDecimal("100"));
        product.setStatus(ProductStatus.NOT_SALE);
        return product;
    }

    protected Category buildCategory() {
        Category category = new Category();
        category.setName("家电");
        return category;
    }

    protected Address addAddress() {
        User user = buildUser();
        um.add(user);

        Address address = buildAddress();
        address.setUser(user);
        am.add(address);
        assertTrue(address.getId() > 0);
        return address;
    }


    protected Product addProduct() {
        Category category = new Category();
        category.setName("家电");
        cm.add(category);


        Product product = buildProduct();

        product.setCategory(category);

        pm.add(product);
        assertTrue(product.getId() > 0);
        return product;
    }

    protected Orders addOrders() {
        Orders orders = new Orders();

        Product product = addProduct();

        Address address = addAddress();

        orders.setUser(address.getUser());
        orders.setAddress(address);

        CartProduct cartProduct = new CartProduct();
        cartProduct.setPrice(product.getPrice().multiply(new BigDecimal("1")));
        orders.setPrice(cartProduct.getPrice());

        orders.setBuyDate(new Date());
        orders.setConfirmDate(new Date());
        orders.setPayDate(new Date());
        om.add(orders);
        assertTrue(orders.getId() > 0);
        return orders;
    }

    protected Map<String, Object> buildMap() {
        Map<String, Object> params = Maps.newHashMap();
        params.put("pageOffset", 0);
        params.put("pageSize", 10);
        return params;
    }

}
