package cn.temptation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.temptation.dao.UserMapper;
import cn.temptation.model.User;
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;

	@Override
	public void saveUser(User user) {
		userMapper.saveUser(user);
	}

	@Override
	public boolean updateUser(User user) {
		return userMapper.updateUser(user);
	}

	@Override
	public boolean deleteUser(String userid) {
		return userMapper.deleteUser(userid);
	}

	@Override
	public User findByUserid(String userid) {
		return userMapper.findByUserid(userid);
	}
	
	@Override
	public List<User> findAll() {
		return userMapper.findAll();
	}

}
