package itat.zttc.shop.mapper;

import itat.zttc.shop.model.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
	void add(User user);
	void delete(int id);
	void update(User user);
	User loadByUsername(String username);
	User load(int id);
    List<User> find(Map<String, Object> params);
    int findCount(Map<String, Object> params);
}
