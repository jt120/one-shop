package itat.zttc.shop.mapper;

import itat.zttc.shop.model.Product;

import java.util.List;
import java.util.Map;

public interface ProductMapper {
    void add(Product product);

    void update(Product product);

    void delete(int id);

    Product load(int id);

    List<Product> find(Map<String, Object> params);

    int findCount(Map<String, Object> params);
}
