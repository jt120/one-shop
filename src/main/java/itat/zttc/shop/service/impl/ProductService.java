package itat.zttc.shop.service.impl;

import com.google.common.collect.Maps;
import itat.zttc.shop.mapper.CategoryMapper;
import itat.zttc.shop.mapper.ProductMapper;
import itat.zttc.shop.model.Category;
import itat.zttc.shop.model.Pager;
import itat.zttc.shop.model.Product;
import itat.zttc.shop.model.ProductStatus;
import itat.zttc.shop.model.ShopException;
import itat.zttc.shop.service.BaseService;
import itat.zttc.shop.service.IProductService;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * since 2015/6/10.
 */
public class ProductService extends BaseService<Product> implements IProductService {

    private ProductMapper productMapper;

    private CategoryMapper categoryMapper;



    @Override
    protected List<Product> findList(Map<String, Object> params) {
        return productMapper.find(params);
    }

    @Override
    protected int findCount(Map<String, Object> params) {
        return productMapper.findCount(params);
    }

    @Override
    public Product add(Product product) {
        int id = product.getCategory().getId();
        Category load = categoryMapper.load(id);
        if (load == null) {
            throw new ShopException("类别不存在");
        }
        productMapper.add(product);
        return product;
    }

    @Override
    public Product update(Product product) {
        int id = product.getCategory().getId();
        Category load = categoryMapper.load(id);
        if (load == null) {
            throw new ShopException("类别不存在");
        }
        productMapper.update(product);
        return product;
    }

    @Override
    public void delete(int id) {
        productMapper.delete(id);

    }

    @Override
    public Product load(int id) {
        return productMapper.load(id);
    }

    @Override
    public Pager<Product> find(int cid, String name, ProductStatus status) {
        Map<String, Object> params = Maps.newHashMap();
        if (cid > 0) {
            params.put("cid", cid);
        }
        if (StringUtils.isNotEmpty(name)) {
            params.put("name", "%"+name+"%");
        }
        if (status != null) {
            params.put("status", status);
        }
        return super.find(params);
    }
}
