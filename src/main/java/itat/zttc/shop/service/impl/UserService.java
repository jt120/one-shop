package itat.zttc.shop.service.impl;

import com.google.common.collect.Maps;
import itat.zttc.shop.mapper.UserMapper;
import itat.zttc.shop.model.Pager;
import itat.zttc.shop.model.ShopException;
import itat.zttc.shop.model.User;
import itat.zttc.shop.service.BaseService;
import itat.zttc.shop.service.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
* since 2015/6/10.
*/
@Service
public class UserService extends BaseService<User> implements IUserService {


    private UserMapper userMapper;

    @Autowired
    public UserService(UserMapper userDao) {
        this.userMapper = userDao;
    }

    @Override
    public User add(User user) {
        User tu = this.loadByUsername(user.getUsername());
        if (tu != null) throw new ShopException("要添加的用户已经存在");
        userMapper.add(user);
        return user;
    }

    @Override
    public void delete(int id) {
        userMapper.delete(id);
    }

    @Override
    public User update(User user) {
        userMapper.update(user);
        return user;
    }

    @Override
    public User loadByUsername(String username) {
        return userMapper.loadByUsername(username);
    }

    @Override
    public User load(int id) {
        return userMapper.load(id);
    }

    @Override
    public User login(String username, String password) {
        User u = this.loadByUsername(username);
        if (u == null) throw new ShopException("用户名不存在!");
        if (!password.equals(u.getPassword())) throw new ShopException("用户名密码不正确");
        return u;
    }

    @Override
    public Pager<User> find(String name) {
        Map<String, Object> params = Maps.newHashMap();
        if (StringUtils.isNotEmpty(name)) {
            params.put("name", name + "%");
        }
        return super.find(params);
    }

    @Override
    protected List<User> findList(Map<String, Object> params) {
        return userMapper.find(params);
    }

    @Override
    protected int findCount(Map<String, Object> params) {
        return userMapper.findCount(params);
    }
}
