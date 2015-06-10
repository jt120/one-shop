package itat.zttc.shop.service;

import itat.zttc.shop.model.Address;

import java.util.List;

/**
 * since 2015/6/10.
 */
public interface IAddressService {

    Address add(Address address);

    Address update(Address address);

    void delete(int id);

    Address load(int id);

    List<Address> list(int userId);
}
