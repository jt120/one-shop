package itat.zttc.shop.service.impl;

import com.google.common.collect.Maps;
import itat.zttc.shop.mapper.CategoryMapper;
import itat.zttc.shop.model.Category;
import itat.zttc.shop.service.ICategoryService;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * since 2015/6/10.
 */
@Service
public class CategoryService implements ICategoryService {

    private CategoryMapper categoryMapper;

    @Autowired
    public CategoryService(CategoryMapper categoryMapper) {
        this.categoryMapper = categoryMapper;
    }

    @Override
    public Category add(Category category) {
        categoryMapper.add(category);
        return category;
    }

    @Override
    public void delete(int id) {
        categoryMapper.delete(id);
    }

    @Override
    public Category update(Category category) {
        categoryMapper.update(category);
        return category;
    }

    @Override
    public List<Category> list(String name) {
        Map<String, Object> params = Maps.newHashMap();
        if (StringUtils.isNotEmpty(name)) {
            params.put("name", name);
        }
        return categoryMapper.list(params);
    }

    @Override
    public Category load(int id) {
        return categoryMapper.load(id);
    }
}
