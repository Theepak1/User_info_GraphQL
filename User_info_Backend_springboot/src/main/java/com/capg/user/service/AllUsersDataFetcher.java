package com.capg.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capg.user.bean.User;
import com.capg.user.repository.IUserRepository;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class AllUsersDataFetcher implements DataFetcher<List<User>> {

	@Autowired
	IUserRepository repo;

	public List<User> get(DataFetchingEnvironment dataFetchingEnvironment) {
		return repo.findAll();
	}

}
