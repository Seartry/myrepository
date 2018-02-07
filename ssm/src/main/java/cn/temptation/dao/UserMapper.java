package cn.temptation.dao;

import java.util.List;

import cn.temptation.model.User;
/**
 * 描述：用户mapper接口
 * @author y
 *
 */
public interface UserMapper {
	void saveUser(User user);
    boolean updateUser(User user);
    boolean deleteUser(String userid);
    User findByUserid(String userid);
    List<User> findAll();
}