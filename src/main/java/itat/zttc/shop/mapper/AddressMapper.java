package itat.zttc.shop.mapper;

import itat.zttc.shop.model.Address;

import java.util.List;

public interface AddressMapper {
	void add(Address address);
	void update(Address address);
	void delete(int id);
	Address load(int id);
	List<Address> list(int userId);
}
