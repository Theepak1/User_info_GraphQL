package com.capg.user.mapstruct.mapper;

import com.capg.user.bean.User;
import com.capg.user.mapstruct.dto.UserDTO;

public interface IUserMapper {
	
	public UserDTO UserToUserDTO(User user);
	public User UserDTOToUser(UserDTO user);

}
