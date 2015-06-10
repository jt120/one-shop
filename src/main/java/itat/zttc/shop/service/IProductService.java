package itat.zttc.shop.service;

import itat.zttc.shop.model.Pager;
import itat.zttc.shop.model.Product;
import itat.zttc.shop.model.ProductStatus;

import java.util.List;
import java.util.Map;

/**
 * since 2015/6/10.
 */
public interface IProductService {
    Product add(Product product);

    Product update(Product product);

    void delete(int id);

    Product load(int id);

    Pager<Product> find(int cid, String name, ProductStatus status);

}
