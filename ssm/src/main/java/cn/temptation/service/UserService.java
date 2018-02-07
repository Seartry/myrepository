package cn.temptation.service;

import java.util.List;

import cn.temptation.model.User;

public interface UserService {
	void saveUser(User user);
    boolean updateUser(User user);
    boolean deleteUser(String userid);
    User findByUserid(String userid);
    List<User> findAll();
}
