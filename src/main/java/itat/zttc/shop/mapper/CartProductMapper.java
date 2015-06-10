package itat.zttc.shop.mapper;

import itat.zttc.shop.model.CartProduct;

public interface CartProductMapper {
	void add(CartProduct cp);
	void deleteByOrders(int oid);
}
