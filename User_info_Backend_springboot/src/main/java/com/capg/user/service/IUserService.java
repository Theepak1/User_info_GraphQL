package com.capg.user.service;

import com.capg.user.bean.User;
import com.capg.user.mapstruct.dto.UserDTO;

public interface IUserService {
	
	public UserDTO addUser(User user);
	public UserDTO updateUser(User user);
	public void deleteUser(int id);

}
