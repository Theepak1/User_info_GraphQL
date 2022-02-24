package com.capg.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capg.user.bean.User;
import com.capg.user.repository.IUserRepository;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class UserDataFetcher implements DataFetcher<User> {

	@Autowired
	IUserRepository repo;

	public User get(DataFetchingEnvironment dataFetchingEnvironment) {

		int id= dataFetchingEnvironment.getArgument("id");

		return repo.findById(id).get();
	}
}
