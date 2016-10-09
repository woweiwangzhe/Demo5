package com.gl.app.mapper;

import java.util.List;

import com.gi.app.util.Page;
import com.gl.app.entity.User;

public interface UserMapper {

	public void addUser(User user);

	public List<User> getAllUser();

	public User getUserById(int id);

	public void deleteById(int id);

	public void update(User user);

	public long getAllUserCount();

	public List<User> getUsers(Page page);

}
