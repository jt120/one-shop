package itat.zttc.shop.service;

import itat.zttc.shop.model.Category;

import java.util.List;

/**
 * since 2015/6/10.
 */
public interface ICategoryService {
    Category add(Category category);

    void delete(int id);

    Category update(Category category);

    List<Category> list(String name);

    Category load(int id);
}
