package itat.zttc.shop.service.impl;

import itat.zttc.shop.mapper.AddressMapper;
import itat.zttc.shop.mapper.UserMapper;
import itat.zttc.shop.model.Address;
import itat.zttc.shop.model.ShopException;
import itat.zttc.shop.model.User;
import itat.zttc.shop.service.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * since 2015/6/10.
 */
@Service
public class AddressService implements IAddressService {

    private AddressMapper addressMapper;

    private UserMapper userMapper;

    @Autowired
    public AddressService(AddressMapper addressMapper, UserMapper userMapper) {
        this.addressMapper = addressMapper;
        this.userMapper = userMapper;
    }

    @Override
    public Address add(Address address) {
        User u = userMapper.load(address.getUser().getId());
        if (u == null) {
            throw new ShopException("用户不存在");
        }
        addressMapper.add(address);
        return address;
    }

    @Override
    public Address update(Address address) {
        addressMapper.update(address);
        return address;
    }

    @Override
    public void delete(int id) {
        addressMapper.delete(id);
    }

    @Override
    public Address load(int id) {
        return addressMapper.load(id);
    }

    @Override
    public List<Address> list(int userId) {
        return addressMapper.list(userId);
    }
}
