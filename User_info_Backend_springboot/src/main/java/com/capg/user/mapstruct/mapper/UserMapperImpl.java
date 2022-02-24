package com.capg.user.mapstruct.mapper;

import org.springframework.stereotype.Component;

import com.capg.user.bean.User;
import com.capg.user.mapstruct.dto.UserDTO;

@Component
public class UserMapperImpl implements IUserMapper {

	@Override
	public UserDTO UserToUserDTO(User user) {

		UserDTO userDTO = new UserDTO();

		userDTO.setId(user.getId());
		userDTO.setName(user.getName());
		userDTO.setEmail(user.getEmail());
		userDTO.setCity(user.getCity());
		userDTO.setContact(user.getContact());

		return userDTO;
	}

	@Override
	public User UserDTOToUser(UserDTO userDTO) {
		User user = new User();

		user.setId(userDTO.getId());
		user.setName(userDTO.getName());
		user.setEmail(userDTO.getEmail());
		user.setCity(userDTO.getCity());
		user.setContact(userDTO.getContact());

		return user;
	}

}
