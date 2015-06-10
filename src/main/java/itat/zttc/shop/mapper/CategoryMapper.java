package itat.zttc.shop.mapper;

import itat.zttc.shop.model.Category;

import java.util.List;
import java.util.Map;

public interface CategoryMapper {
    void add(Category category);

    void delete(int id);

    void update(Category category);

    List<Category> list(Map<String,Object> params);

    Category load(int id);
}
