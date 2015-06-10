package itat.zttc.shop.suit;

import itat.zttc.shop.mapper.TestAddressMapper;
import itat.zttc.shop.mapper.TestCartProductMapper;
import itat.zttc.shop.mapper.TestCategoryMapper;
import itat.zttc.shop.mapper.TestOrderMapper;
import itat.zttc.shop.mapper.TestProductMapper;
import itat.zttc.shop.mapper.TestUserMapper;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * since 2015/6/10.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses(
        value = {TestAddressMapper.class,
        TestCartProductMapper.class,
        TestCategoryMapper.class,
        TestOrderMapper.class,
        TestProductMapper.class,
        TestUserMapper.class}
)
public class TestMapper {


}
