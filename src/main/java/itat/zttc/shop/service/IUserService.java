package itat.zttc.shop.service;

import itat.zttc.shop.model.Pager;
import itat.zttc.shop.model.User;

import java.util.Map;

/**
 * since 2015/6/10.
 */
public interface IUserService {

    User add(User user);

    void delete(int id);

    User update(User user);

    User loadByUsername(String username);

    User load(int id);

    User login(String username, String password);

    Pager<User> find(String name);
}
