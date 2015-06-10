package itat.zttc.shop.mapper;

import itat.zttc.shop.model.Orders;

import java.util.List;
import java.util.Map;


public interface OrderMapper {
	void add(Orders orders);
	void delete(int id);
	void update(Orders orders);
	Orders load(int id);
    List<Orders> find(Map<String,Object> params);
    List<Orders> findByStatus(Map<String, Object> params);
    int findCount(Map<String, Object> params);
    int findByStatusCount(Map<String, Object> params);
}
