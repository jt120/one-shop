package itat.zttc.shop.service;

import itat.zttc.shop.model.Orders;
import itat.zttc.shop.model.Pager;

import java.util.List;
import java.util.Map;

/**
 * since 2015/6/10.
 */
public interface IOrderService {
    Orders add(Orders orders);

    void delete(int id);

    Orders update(Orders orders);

    Orders load(int id);

    Pager<Orders> find(Map<String, Object> params);

}
